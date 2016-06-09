package com.taxlibrary.Streams;

/**
 * Created by ktoloc on 09.06.2016.
 */
public class Bike implements java.io.Serializable {
    String model;
    transient double price;//скрыть данные во время сериализации

}
