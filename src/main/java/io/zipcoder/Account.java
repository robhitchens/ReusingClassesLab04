package io.zipcoder;

/**
 * Created by roberthitchens3 on 2/2/16.
 */
public class Account {

    private double balance;
    private int pin;
    private String type;
    public Account(int pin, double balance){
        this.pin = pin;
        this.balance = balance;

    }
    public double getBalance(){
        return balance;
    }
    public boolean changeBalance(double amount, boolean incOrDec){
        if(incOrDec){
            balance += amount;
            return true;
        }else{
            if(amount > balance){
                return false;
            }else{
                balance -= amount;
                return true;
            }
        }
    }
    public String getType(){return type;}
}
