package com.taxlibrary.Abstracts;

/**
 * Created by ktoloc on 07.06.2016.
 */
public class Cat extends Pet{
    public Cat()
    {
        super("Meow");
    }
    @Override
    public void Say()
    {
        Print(voice);
    }

}
