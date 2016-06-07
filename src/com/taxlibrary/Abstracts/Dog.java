package com.taxlibrary.Abstracts;

/**
 * Created by ktoloc on 07.06.2016.
 */
public class Dog extends Pet {
    String name;
    public Dog(String voice, String name)
    {
        super(voice);
        this.name=name;
    }
    @Override
    public void Say()
    {
        Print(voice+name);
    }
}
