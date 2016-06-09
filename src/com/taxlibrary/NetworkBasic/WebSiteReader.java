package com.taxlibrary.NetworkBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by ktoloc on 09.06.2016.
 */
public class WebSiteReader {

    public static void Method1(String args[]){
        String nextLine;
        URL url = null;
        URLConnection urlConn = null;

        try
        {
            // Assume index.html is a default home page name
            url  = new URL("http://www.google.com" );
            urlConn = url.openConnection();
        } catch( IOException e){
            System.out.println("Can't connect to the provided URL:" +
                    e.toString() );
        }

        try(InputStreamReader inStream = new InputStreamReader(
                urlConn.getInputStream(), "UTF8");
            BufferedReader buff  = new BufferedReader(inStream);){

            // Read and print the content of the Google's home page
            while (true){
                nextLine =buff.readLine();
                if (nextLine !=null){
                    System.out.println(nextLine);
                }
                else{
                    break;
                }
            }
        } catch(IOException  e1){
            System.out.println("Can't read from the Internet: "+
                    e1.toString() );
        }
    }

    public static void Method2(String args[])
    {
        String nextLine;
        URL url = null;
        URLConnection urlConn = null;
        InputStreamReader  inStream = null;
        BufferedReader buff = null;
        try{
            // index.html is a default URL's  file name
            url  = new URL("http://finance.yahoo.com/q?s=MOT" );
            urlConn = url.openConnection();
            inStream = new InputStreamReader(
                    urlConn.getInputStream());
            buff  = new BufferedReader(inStream);

            // Read the entire trading information about Motorolla
            // into a String variable
            String theWholePage=null;
            String currentLine;
            while ((currentLine=buff.readLine()) !=null){
                theWholePage+=currentLine;
            }
            System.out.println(theWholePage);
        } catch(MalformedURLException e){
            System.out.println("Please check the URL:" +
                    e.toString() );
        } catch(IOException  e1){
            System.out.println("Can't read  from the Internet: "+
                    e1.toString() );
        }
    }
}
