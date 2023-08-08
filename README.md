# Huawei notes to txt file
This is a simple tool written in Java 17 to convert Huawei Notes to text notes

## Retrieve Huawei notes
You can download a zip archive from huawei's website containing all your notes, but first you have to synchronize them to Huawei cloud.
You can follow this guide to download your data: [guide](https://consumer.huawei.com/en/support/content/en-us00746223/).

## Build
Building the project is pretty simple using Maven, just run:

`mnv clean package`

## Usage
The program takes as input the directory where all notes are stored and then will store all the converted
notes in the same folder, giving the timestamp of the note as name of the file.

Usage: `java -jar HuaweiNotesTxt.jar <directory>`

## Limitations
Currently only notes with plain text can be converted correctly .