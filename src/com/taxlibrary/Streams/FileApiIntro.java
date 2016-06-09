package com.taxlibrary.Streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

/**
 * Created by ktoloc on 09.06.2016.
 */
public class FileApiIntro {
    Path path1 = FileSystems.getDefault().getPath(".", "c:\\smap\\java.txt");
    Path path2 = FileSystems.getDefault().getPath(".", "/smap/java.txt");

    public static List<String> ReadStrings(Path path) throws IOException {
        return Files.readAllLines(path, Charset.defaultCharset());
    }

    public static byte[] ReadBytes(Path path) throws IOException {
        return Files.readAllBytes(path);
    }

    public static Reader BufferedReaderWithPath(Path path) throws IOException {
        return Files.newBufferedReader(path, Charset.defaultCharset());
    }

    public static void ReadFromPath() {
        Path statesFile = Paths.get("states.txt");

        try (BufferedReader reader =
                     Files.newBufferedReader(statesFile, StandardCharsets.UTF_8)) {

            String stateName;
            while ((stateName = reader.readLine()) != null) {
                System.out.println("Got the state " + stateName);
            }

        } catch (IOException ioe) {
            System.out.println("Error while reading states.txt: " + ioe.getMessage());
        }
    }

    public static void FileCopy() {
        // Get the path to the file states.txt located in dir
        // this program was launched from
        Path sourceFilePath = Paths.get("states.txt");

        // Will copy the source file to this destination
        Path destFilePath = Paths.get("states.bak");

        if (Files.exists(sourceFilePath)) {
            System.out.println("The file  " + sourceFilePath + " exists");
            System.out.println("The absolute path is " + sourceFilePath.toAbsolutePath());

            try {
                // Check the file size (in bytes)
                System.out.println("It's size is " + Files.size(sourceFilePath));

                // Copy the file from states.txt to states.bak
                Files.copy(sourceFilePath, destFilePath, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Copy completed. The backup file is at " + destFilePath.toAbsolutePath());

            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

}
