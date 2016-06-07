package com.taxlibrary;

/**
 * Created by ktoloc on 07.06.2016.
 */
public class Workers extends Employee {

    public Workers(String name, String lastName, int age){
        super(name, lastName, age);

    }
    public String GetName()
    {
        return name;
    }
    @Override
    public void callToPerson(String name)
    {
        if(this.name.contentEquals(name))
            System.out.println(name+" is our Worker!");
    }
}
