package io.zipcoder;

/**
 * Created by roberthitchens3 on 2/2/16.
 */
import org.junit.Test;
import static org.junit.Assert.*;
public class SpecBusinessAccount {
    Account baccount = (Account)new BusinessAccount(1234, 100000);
    @Test
    public void testBusinessAccount(){
        double balance = baccount.getBalance();
        assertNotEquals("the returned value should not be -1", -1, balance, 0.01);
    }
    @Test
    public void testChangeBalance(){
        double balance =baccount.getBalance();
        baccount.changeBalance(1000, false);
        double balChange = baccount.getBalance();
        assertTrue("initial balance and cheanged balance should not be the same", balChange != balance);
        baccount.changeBalance(1000, true);
        balChange = baccount.getBalance();
        assertTrue("balChange should be equal to initial balance: ", balChange == balance);
    }
}
