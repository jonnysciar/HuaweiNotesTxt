package it.jonnysciar;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Note implements Serializable {
    private String content;
    private Date date;

    public Note(String content, long epochTime) {
        this.content = content;
        this.date = new Date(epochTime);
    }

    public String getContent() {
        return content;
    }


    public Date getDate() {
        return date;
    }

    public String getFormattedDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        return dateFormat.format(date);
    }

    public void save(String directory) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(directory + "/" + getFormattedDate() + ".txt"));
            printWriter.println(getFormattedDate());
            printWriter.println(content);
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
