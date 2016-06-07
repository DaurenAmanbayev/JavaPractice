package com.taxlibrary;

public class Transport {
    String color;
    int numberOfDoors;

    boolean StartEngine()
    {
        return true;
    }
    boolean StopEngine()
    {
        return false;
    }
    public double calcTax() {
        return 650;
    }
}
