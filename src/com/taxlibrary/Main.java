package com.taxlibrary;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //ArrayTest();
       // Compare(45,56,"Google", "Facebook");
        //StringTest();
        ClassesTest();

    }
    static void ClassesTest()
    {
        Employee emp=new Employee("John", "Silver", 21);
        Workers worker=new Workers("James", "Bond",38);

        Employee wk1=new Workers("Jina", "Grey", 25);
        Employee wk2=new Contractor("Avatar", "Sun", 1000);
        //Print(worker.GetName());
       // Print(((Workers)wk1).GetName());
       // Print(((Workers)emp).GetName());//ERROR!!!

        Employee[] emps=new Employee[4];
        emps[0]=emp;
        emps[1]=worker;
        emps[2]=wk1;
        emps[3]=wk2;

        for (Employee p: emps) {
            if(p instanceof Contractor)
            {
                p.callToPerson("John");
            }
            else if(p instanceof  Workers)
            {
                Print(((Workers) p).GetName());//casting Workers
            }
            else
            {
                Print(p.toString());
            }
        }
    }
    static void StringTest()
    {
       // StringExp exp=new StringExp();
        //true
        System.out.print(StringExp.StringImmutable("Masha", "Masha"));//usage static methods
        String b1="Sasha";
        String b2="Sasha";
        System.out.print(StringExp.StringImmutable(b1, b2));//true
        String g1=new String("Masha");
        String g2=new String("Masha");

        System.out.print(StringExp.StringImmutable(g1, g2));//false

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
        String compMessage=arg1<arg2? str1:str2;//fast compare
        Print(compMessage+" win!!!");
    }

    static void ClassAndObjects()
    {
        Transport car1=new Transport();
        Transport car2=new Transport();

        car1.numberOfDoors=4;
        car1.color="Grey";
        car2.numberOfDoors=5;
        car2.color="Blue";

        System.out.println("I have painted my cars");
        System.out.println("The color of car1 is "+ car1.color);
        System.out.println("The color of car2 is "+ car2.color);
    }
}
