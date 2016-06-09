package com.taxlibrary.Streams;

import java.io.*;

public class Javaiostreams {

    /**
     * Java 8 => Streams API
     * <p>
     * Reading and writing characters with Reader and Writer
     * DataInputStream and DataOutputStream can read and write Java primitives
     * FileInputStream, FileReader to work with files
     * <p>
     * java.nio and java.io
     */


    /*THREE step of working with io streams
    * Open stream that points at specific data source: a file, a socket, a URL, and so on
    * Read or write data from/to this stream
    * Close the stream unless it's auto closable
    *   *
    * */
    public static void FileReadExample() {
        FileInputStream myFile = null;
        try {
            myFile = new FileInputStream("abc.dat");
            boolean eof = false;

            while (!eof) {
                int byteValue = myFile.read();

                System.out.println(byteValue + " ");
                if (byteValue == -1) {
                    eof = true;
                }
            }

        } catch (IOException e) {
            System.out.println("Couldn't read file!");
        } finally {
            if(myFile!=null)
            {
                try
                {
                    myFile.close();
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        }
    }
    static int somedata[]={56,230,123,43,11,37};
    static FileOutputStream myWriter=null;
    public static void FileWriteExample()
    {
        try{
            myWriter=new FileOutputStream("xyz.dat");

            for (int i=0; i<somedata.length;i++)
            {
                myWriter.write(somedata[i]);
            }

        }
        catch (IOException e)
        {
            System.out.println("Couldn't write file!");
        }
        finally {
            if(myWriter!=null)
            {
                try{
                    myWriter.close();
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        }
    }

    /*
    * Buffered IO Streams
    * для чтения буферизировано
    * преимущество скорость чтения
    * */
    public static void BufferedFileReadExample(String path) {
        FileInputStream myFile = null;
        BufferedInputStream buff=null;
        try {
            myFile = new FileInputStream(path);
            buff=new BufferedInputStream(myFile);//создаем буфер для потока чтения файла
            boolean eof = false;

            while (!eof) {
                int byteValue = myFile.read();

                System.out.println(byteValue + " ");
                if (byteValue == -1) {
                    eof = true;
                }
            }

        } catch (IOException e) {
            System.out.println("Couldn't read file!");
        } finally {
            if(myFile!=null)
            {
                try
                {
                    myFile.close();
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        }
    }
    //read characters
    public static  void StreamReader(String path)
    {
        FileInputStream myFile = null;
        StringBuffer buffer=new StringBuffer();
        BufferedInputStream buff=null;
        try {
            myFile = new FileInputStream(path);
            InputStreamReader inputStreamReader=new InputStreamReader(myFile, "UTF8");
            Reader reader=new BufferedReader(inputStreamReader);
            int ch;

            while ((ch=reader.read())>-1)
            {
                buffer.append((char)ch);
            }

            String result=buffer.toString();

        } catch (IOException e) {
            System.out.println("Couldn't read file!");
        } finally {
            if(myFile!=null)
            {
                try
                {
                    myFile.close();
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        }
    }

    //write into characters
    public static void StreamWriter(String content, String path, String encoding)
    {
        FileOutputStream myFile=null;
        try {
             myFile= new FileOutputStream(path);

            Writer out = new BufferedWriter(new OutputStreamWriter(myFile, encoding));///encoding like UTF8

            out.write(content);
        }
        catch (IOException e)
        {
            System.out.println("Couldn't write to file!");
        }
        finally {
            if(myFile!=null)
            {
                try
                {
                    myFile.close();
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        }

    }

    //аналог using
    public static void TryResourcesRead(String path)
    {
        try (FileInputStream myFile = new FileInputStream(path)){

            boolean eof = false;

            while (!eof) {
                int byteValue = myFile.read();
                System.out.print(byteValue + " ");
                if (byteValue  == -1)
                    eof = true;
            }
        } catch (IOException ioe) {
            System.out.println("Could not read file: " +
                    ioe.toString());
        }
    }
    //try resourses
    public static void FileIN(String path)
    {
        try (FileInputStream myFile = new FileInputStream(path)){

            boolean eof = false;

            while (!eof) {
                int byteValue = myFile.read();
                System.out.print(byteValue + " ");
                if (byteValue  == -1)
                    eof = true;
            }
        } catch (IOException ioe) {
            System.out.println("Could not read file: " +
                    ioe.toString());
        }
    }
}



