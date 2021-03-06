package com.taxlibrary.MultiThreading;

/**
 * Created by ktoloc on 09.06.2016.
 */
public class TestThreads3LambdaWait {
    public static void Test(String args[]){

        // Lambda expression for Market News
        Runnable mn = () -> {
            try{
                for (int i=0; i<10;i++){
                    Thread.sleep (1000);  // sleep for 1 second
                    System.out.println( "The market is improving " + i);
                }
            }catch(InterruptedException e ){
                System.out.println(Thread.currentThread().getName()
                        + e.toString());
            }
        };

        Thread marketNews = new Thread(mn, "Market News");
        marketNews.start();

        // Lambda expression for Portfolio
        Runnable port = () ->{
            try{
                for (int i=0; i<10;i++){
                    Thread.sleep (700);    // Sleep for 700 milliseconds
                    System.out.println( "You have " +  (500 + i) +
                            " shares of IBM");
                }
            }catch(InterruptedException e ){
                System.out.println(Thread.currentThread().getName()
                        + e.toString());
            }
        };


        Thread portfolio = new Thread(port,"Portfolio data");
        portfolio.start();

        TestThreads3LambdaWait thisInstance = new TestThreads3LambdaWait();

        synchronized (thisInstance) {
            try{
                thisInstance.wait(15000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println( "The main method of TestThreads3Lambda is finished");
    }
}
