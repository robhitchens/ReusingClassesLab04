package io.zipcoder;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by roberthitchens3 on 2/2/16.
 */
public class SpecSavingsAccount {
    Account saccount = (Account)new SavingsAccount(1234, 100000);
    @Test
    public void testBusinessAccount(){
        double balance = saccount.getBalance();
        assertNotEquals("the returned value should not be -1", -1, balance, 0.01);
    }
    @Test
    public void testChangeBalance(){
        double balance =saccount.getBalance();
        saccount.changeBalance(1000, false);
        double balChange = saccount.getBalance();
        assertTrue("initial balance and cheanged balance should not be the same", balChange != balance);
        saccount.changeBalance(1000, true);
        balChange = saccount.getBalance();
        assertTrue("balChange should be equal to initial balance: ", balChange == balance);
    }
}
