package io.zipcoder;

/**
 * Created by roberthitchens3 on 2/2/16.
 */
public class BusinessAccount extends Account {
    private String type;
    public BusinessAccount(int pin, double balance){
        super(pin, balance);
        this.type = "business";
    }
    @Override
    public String getType(){
        return type;
    }
}
