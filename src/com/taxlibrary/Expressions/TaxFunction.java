package com.taxlibrary.Expressions;

@FunctionalInterface
public interface TaxFunction {
    double calcTax(double grossIncome);
}