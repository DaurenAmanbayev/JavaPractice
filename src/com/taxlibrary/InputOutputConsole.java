package com.taxlibrary;

import java.util.Scanner;

/**
 * Created by ktoloc on 07.06.2016.
 */
public class InputOutputConsole {

    static String ReadConsole()
    {
        Scanner input=new Scanner(System.in);
        String result=input.nextLine();
        return result;
    }
    static  void Print(String str)
    {
        System.out.println(str);
    }
}
