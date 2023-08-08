package it.jonnysciar;

import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please specify directory");
            return;
        }
        Path path = Paths.get(args[0]);
        DirectoryParser.getAllNotes(path, path);
    }
}
