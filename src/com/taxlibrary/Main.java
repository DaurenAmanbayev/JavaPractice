package com.taxlibrary;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //ArrayTest();
        Compare(45,56,"Google", "Facebook");
    }

    static void ArrayTest()
    {
        String[] friends=new String[5];

        friends[0]="Masha";
        friends[1]="Matilda";
        friends[4]="Roma";
        //инициализация массива
        String[] people={"Masha", "Roma", "Sharon"};
        //многоразмерные массивы
        String orcs[][]=new String[5][2];

        orcs[0][0]="Orgrim";
        orcs[0][1]="74455464646";

        Print("---Обычный цикл----");
        //перебор элементов в обычном цикле
        for (int i=0; i<friends.length; i++)
        {
            System.out.println(friends[i]);
        }
        Print("----Цикл с перебором----");
        //перебор элементов в массиве
        for (String item: friends) {
            System.out.println(item);

        }

        Print("While цикл");
        int i=0;
        while (i<friends.length)
        {
            if(friends[i]==null)
            {
                i++;
                continue;
            }
            if (friends[i]=="Matilda")
            {
                break;
            }
            Print("I love my friend "+friends[i]);
            i++;
        }
    }

    static void Print(String str)
    {
        System.out.println(str);
    }
    static void Compare(int arg1, int arg2, String str1, String str2)
    {
        String compMessage=arg1<arg2? str1:str2;
        Print(compMessage+" win!!!");
    }
}
