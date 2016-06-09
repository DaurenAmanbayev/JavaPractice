package com.taxlibrary.NetworkBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Created by ktoloc on 09.06.2016.
 */
public class ProxyUsage {

    public static void ThroughConnect()
    {
        Proxy myProxy=new Proxy(Proxy.Type.HTTP,
                new InetSocketAddress("http://proxy.company.com",3128));


        String nextLine;
        URL url = null;
        URLConnection urlConn = null;
        InputStreamReader inStream = null;
        BufferedReader buff = null;
        try{
            // index.html is a default URL's  file name
            url  = new URL("http://finance.yahoo.com/q?s=MOT" );
            urlConn = url.openConnection(myProxy);//используем прокси для подключения
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
        } catch(IOException e1){
            System.out.println("Can't read  from the Internet: "+
                    e1.toString() );
        }
    }
}
