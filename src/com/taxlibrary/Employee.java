package com.taxlibrary;

/**
 * Created by ktoloc on 07.06.2016.
 */
public class Employee implements PersonInterface{
    protected String name;
    protected String lastName;
    protected int age;

    public Employee(String name, String lastName, int age)
    {
        this.name=name;
        this.lastName=lastName;
        this.age=age;
    }
    @Override
    public void setPerson(String name, String lastName, int age)
    {
        this.name=name;
        this.lastName=lastName;
        this.age=age;
    }
    @Override
    public void callToPerson(String name)
    {
        if(this.name.contentEquals(name))
            System.out.print(true);
        else
            System.out.print(false);
    }

   // @Override
    //how to override to string??? java 8
    public String ToString()
    {
        return name+lastName;
    }
}
