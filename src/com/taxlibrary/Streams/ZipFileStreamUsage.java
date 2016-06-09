package com.taxlibrary.Streams;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by ktoloc on 09.06.2016.
 */
public class ZipFileStreamUsage {
    //************************************//
    public static void ZipFileUsage()
    {
        ZipEntry ze = null;

        try (FileInputStream myFile = new FileInputStream("e:\\test.zip");
             BufferedInputStream buff = new BufferedInputStream(myFile);
             ZipInputStream zipFile = new ZipInputStream(buff);){

            while ((ze = zipFile.getNextEntry()) != null) {
                System.out.println(ze.getName());
                zipFile.closeEntry();
            }

        } catch (IOException e) {
            System.out.println("Could not read file: " + e.toString());
        }
    }
}
