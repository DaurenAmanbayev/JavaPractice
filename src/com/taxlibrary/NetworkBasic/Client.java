package com.taxlibrary.NetworkBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by ktoloc on 09.06.2016.
 */
//потестировать!!!!
    /*
    * изучить возможности non blocking sockets
    * RMI remote method invocation
    * */
public class Client {
    public static void Start(String[] args) {

        if (args.length==0){
            System.out.println("Usage: java Client Symbol");
            System.exit(-1);
        }

        Socket clientSocket = null;
        try{
            // Open a client socket connection
            clientSocket = new Socket("localhost", 3000);//подключаемся к адресу и порту
            System.out.println("Client: " + clientSocket);
        }catch (UnknownHostException uhe){
            System.out.println("UnknownHostException: " + uhe);
        } catch (IOException ioe){
            System.err.println("IOException: " + ioe);
        }

        try (OutputStream outbound = clientSocket.getOutputStream();//поток выходной
             BufferedReader inbound = new  BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()));  ){

            // Send stock symbol to the server
            outbound.write((args[0]+"\n").getBytes());//отправляем данные

            String quote;
            //ожидаем ответа
            while (true){
                quote = inbound.readLine();//парсим входящий поток
                if (quote.length() == 0) continue;//проверяем не пустой ли он

                if (quote.equals("End")){//если строка заканчивается останавливаем цикл
                    break;
                }
                //вывод квоты
                System.out.println("Got the quote for " + args[0]+":" + quote);
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
