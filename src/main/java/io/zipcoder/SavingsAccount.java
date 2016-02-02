package io.zipcoder;

/**
 * Created by roberthitchens3 on 2/2/16.
 */
public class SavingsAccount extends Account {
    private String type;
    public SavingsAccount(int pin, double balance){
        super(pin, balance);
        this.type = "savings";
    }
    @Override
    public String getType(){
        return type;
    }
}
