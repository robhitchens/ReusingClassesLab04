package io.zipcoder;

/**
 * Created by roberthitchens3 on 2/2/16.
 */
import org.junit.Test;
import static org.junit.Assert.*;
public class SpecAccount {

    Account account = new Account(1234, 100000);
    @Test
    public void testGetBalance(){
        double balance =account.getBalance();
        assertNotEquals("the returned value should not be -1", -1, balance, 0.01);
    }
    @Test
    public void testChangeBalance(){
        double balance =account.getBalance();
        account.changeBalance(1000, false);
        double balChange = account.getBalance();
        assertTrue("initial balance and cheanged balance should not be the same", balChange != balance);
        account.changeBalance(1000, true);
        balChange = account.getBalance();
        assertTrue("balChange should be equal to initial balance: ", balChange == balance);
    }

}
