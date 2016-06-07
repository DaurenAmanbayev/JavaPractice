package com.taxlibrary;


public class Car extends Transport{
    public double adjustForStudents(double tax)
    {
        return tax-500;
    }

    @Override
    public double calcTax() {
        return super.calcTax()+650;
    }
}
