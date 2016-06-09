package com.taxlibrary.MultiThreading;

/**
 * Created by ktoloc on 09.06.2016.
 */
public class MarketNews extends Thread {
    public MarketNews (String threadName) {
        super(threadName);  // name your thread
    }

    public void run() {
        System.out.println( "The stock market is improving!");
    }
}