package com.taxlibrary.Exceptions;

/**
 * Created by ktoloc on 07.06.2016.
 */
public class TooManyBikesException extends Exception{
    TooManyBikesException(String msgText)
    {
        super(msgText);
    }
}
