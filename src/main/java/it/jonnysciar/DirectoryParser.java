package it.jonnysciar;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class DirectoryParser {
    private static Gson gson = new Gson();

    private static Note getNoteFromFile(Path path) {
        try {
            Scanner scanner = new Scanner(new FileReader(path.toString()));
            String str = scanner.nextLine().substring(11);
            JsonObject jsonObject = gson.fromJson(str, JsonObject.class).get("content").getAsJsonObject();
            return new Note(jsonObject.get("content").getAsString().substring(5),
                    jsonObject.get("created").getAsLong());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return new Note("", 0);
    }

    public static void getAllNotes(Path mainPath, Path output_dir) {
        List<Note> notes = new ArrayList<>();

        if (!Files.exists(mainPath) || !Files.isDirectory(mainPath)) {
            return;
        }

        try (Stream<Path> stream = Files.list(mainPath)) {
            List<Path> paths = stream.toList();
            for (Path path : paths) {
                if (Files.isDirectory(path)) {
                    getAllNotes(path, output_dir);
                    continue;
                }

                if (!path.getFileName().toString().equals("json.js")) {
                    continue;
                }

                getNoteFromFile(path).save(output_dir.toString());
            }
        } catch (IOException | SecurityException e) {
            System.out.println(e.getMessage());
        }
    }
}
