package com.taxlibrary.Abstracts;

import com.taxlibrary.PersonInterface;

/**
 * Created by ktoloc on 07.06.2016.
 */
public abstract class Pet {
    String voice;
    public Pet(String voice)
    {
        this.voice=voice;
    }
    public abstract void Say();

    protected void Print(String str)
    {
        System.out.println(str);
    }
}
