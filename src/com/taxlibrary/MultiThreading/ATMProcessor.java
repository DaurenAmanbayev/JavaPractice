package com.taxlibrary.MultiThreading;

/**
 * Created by ktoloc on 09.06.2016.
 */
public class ATMProcessor extends Thread {

    //попробовать организовать возможности синхронизации wait notify lock and other concurrency tools
    synchronized void witdhdrawCash(int accountID, int amount)
    {
        //рекомендуется делать синхронизацию на блок кода
        boolean allowTransaction=validateWithdrawal(accountID, amount);
        if(allowTransaction)
        {
            updateBalance(accountID, amount, "Withdraw");
        }
        else
        {
            System.out.println("Not enough money on the account");
        }
    }

    void updateBalance(int accountiD, int amount , String card)
    {

    }
    boolean validateWithdrawal(int accountID, int amount)
    {
        return true;
    }
}
