package com.taxlibrary.MultiThreading;

/**
 * Created by ktoloc on 09.06.2016.
 */
public class Portfolio extends Thread {
    public Portfolio (String threadName) {
        super(threadName);
    }

    public void run() {
        System.out.println( "You have 500 shares of IBM ");
    }
}