package com.taxlibrary.Expressions;

/**
 * Created by ktoloc on 09.06.2016.
 */
public class BusinessMan {
    public String name;
    public double grossIncome;

    public void applyTaxCalcFunction(TaxFunction taxFunc) {

        double calculatedTax = taxFunc.calcTax(grossIncome);
        System.out.println( "The calculated tax for " + name + " is "+ calculatedTax );

    }
}
