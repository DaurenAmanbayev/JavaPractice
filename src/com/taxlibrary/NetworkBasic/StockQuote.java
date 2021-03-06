package com.taxlibrary.NetworkBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.StringTokenizer;

/**
 * Created by ktoloc on 09.06.2016.
 */
public class StockQuote {

    public static void printStockQuote(String symbol){
        String csvString;
        URL url = null;
        URLConnection urlConn = null;

        try{
            url  = new
                    URL("http://quote.yahoo.com/d/quotes.csv?s="
                    + symbol + "&f=sl1d1t1c1ohgv&e=.csv" );
            urlConn = url.openConnection();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }

        try(InputStreamReader inStream =
                    new InputStreamReader(urlConn.getInputStream());

            BufferedReader buff  = new BufferedReader(inStream);){

            // get the quote as a csv string
            csvString =buff.readLine();

            // parse the csv string
            StringTokenizer tokenizer = new StringTokenizer(csvString, ",");
            String ticker = tokenizer.nextToken();
            String price  = tokenizer.nextToken();
            String tradeDate = tokenizer.nextToken();
            String tradeTime = tokenizer.nextToken();

            System.out.println("Symbol: " + ticker +
                    " Price: " + price + " Date: "  + tradeDate
                    + " Time: " + tradeTime);
        } catch(MalformedURLException e){
            System.out.println("Please check the spelling of "
                    + "the URL: " + e.toString() );
        } catch(IOException  e1){
            System.out.println("Can't read from the Internet: " +
                    e1.toString() );
        }
    }
}
