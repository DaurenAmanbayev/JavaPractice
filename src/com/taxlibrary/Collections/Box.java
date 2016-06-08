package com.taxlibrary.Collections;

/**
 * Created by ktoloc on 08.06.2016.
 */
//defining parametrized class
public class Box<T> {

    private  T t;
    public void add(T t)
    {
        this.t=t;
    }
    public T get()
    {
        return t;
    }
}
