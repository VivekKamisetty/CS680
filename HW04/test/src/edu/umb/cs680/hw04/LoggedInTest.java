package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LoggedInTest {

	@Test
    public void testLoggingIn() {
        User user = new User();
        SecurityContext sec = new SecurityContext(user);
        assertEquals(sec.getState(), LoggedOut.getInstance(sec));
        EncryptedString pwd = new EncryptedString();
        sec.login(pwd);

        assertTrue(sec.isActive());
        assertEquals(sec.getState(), LoggedIn.getInstance(sec));
        sec.logout();
    }
}
