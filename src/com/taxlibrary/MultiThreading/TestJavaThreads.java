package com.taxlibrary.MultiThreading;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.ObjDoubleConsumer;

/**
 * Created by ktoloc on 09.06.2016.
 */
public class TestJavaThreads {
    //--------------------
    //пример остановки потоков
    public static void KillThread()
    {
        PortfolioVolatile p = new PortfolioVolatile("Portfolio data");
        p.start();

        // Some code implementation business logic goes here
        int i=0;
        do {
            System.out.println(" i= " + i++);
        }while (i<100);

        // and now it's time to kill the thread
        p.stopMe();
    }

    //
    public static void TestCallableThread() throws InterruptedException, ExecutionException {

        // Lambda expression for Market News
        Callable<Integer> mn = () -> {
            for (int i=0; i<10;i++){
                Thread.sleep (1000);  // sleep for 1 second
                System.out.println( "The market is improving " + i);
            }
            // Just return some number to illustrate return
            return 12345;
        };


        // Lambda expression for Portfolio
        Callable<Integer> port = () ->{
            for (int i=0; i<10;i++){
                Thread.sleep (700);    // Sleep for 700 milliseconds
                System.out.println( "You have " +  (500 + i) +
                        " shares of IBM");
            }

            // Just return some number
            return 10;
        };


        //A placeholder for Future objects
        List<Future<Integer>> futures =
                new ArrayList<Future<Integer>>();

        // A placeholder for results returned by threads
        List<Integer> results = new ArrayList<Integer>();

        final ExecutorService service =
                Executors.newFixedThreadPool(2);

        try {

            futures.add(service.submit(port));
            futures.add(service.submit(mn));

            for (Future<Integer> future : futures) {
                results.add(future.get());
            }

        } finally {
            service.shutdown();
        }

        for (Integer res: results){
            System.out.println("\nGot the result: " + res);
        }
    }

    public static void TestMarket()
    {
        MarketNews mn = new MarketNews("Market News");
        mn.start();

        Portfolio p = new Portfolio("Portfolio data");
        p.start();

        System.out.println( "TestThreads is finished");
    }

    //напоминает Task ->>> Action C#
    public static void Thread2Lamda()
    {

        Thread mn = new Thread(()-> System.out.println( "The stock market is improving!"),
                "Market News");
        mn.start();

        Thread p = new Thread(() -> System.out.println( "You have 500 shares of IBM "),
                "Portfolio Data");
        p.start();

        System.out.println( "TestThreads2Lambda is finished");
    }

    public static void Thread3Lambda()
    {
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

        System.out.println( "The main method of TestThreads3Lambda is finished");
    }

    public static void Thread3LambdaJoin()
    {
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


        Thread marketNews = new Thread(mn, "Market News");
        Thread portfolio = new Thread(port,"Portfolio data");

        marketNews.start();
        portfolio.start();

        try{
            marketNews.join();
            portfolio.join();

        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println( "The main method of TestThreads3LambdaJoin is finished");
    }

    public static void TestThreadsWait()
    {
        Object locked=new Object();

        synchronized (locked)
        {
            try{
            System.out.println("Starting to wait");
                locked.wait(15000);

            }
            catch (InterruptedException e)
            {
                System.out.println("Interrupted...");
            }
        }

    }
    public static void TestThreadsWait2()
    {
        ReentrantLock locked=new ReentrantLock();

        final Condition notDone=locked.newCondition();

        locked.lock();
        try{

            System.out.println("Starting to wait...");
            notDone.await(15, TimeUnit.SECONDS);

        }
        catch (InterruptedException e)
        {
            System.out.println("the main thread is interrupted");
        }
    }
}
