package com.taxlibrary.Collections;

/**
 * Created by ktoloc on 08.06.2016.
 */
public class Order<K, V> {

    private K key;
    private V value;
    public Order(K key, V value)
    {
        this.key=key;
        this.value=value;
    }
}
