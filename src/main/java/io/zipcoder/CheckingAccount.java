package io.zipcoder;



/**
 * Created by roberthitchens3 on 2/2/16.
 */
public class CheckingAccount extends Account {
    private String type;
    public CheckingAccount(int pin, double balance){
        super(pin, balance);
        this.type = "checking";
    }
    public String getType(){
        return type;
    }

}
