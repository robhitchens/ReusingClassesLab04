package io.zipcoder;

/**
 * Created by roberthitchens3 on 2/2/16.
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class SpecAccountManager {
    AccountManager accman = new AccountManager();
    @Test
    public void testCreateAccountDeleteAccount(){
        accman.createAccount(1234, 10000, "business");
        Account deleted= accman.deleteAccount(1234);
        assertTrue("", deleted.getBalance() == 10000);
        assertTrue("", deleted.getType().equals("business"));
    }
}
