package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StateLoggedOutTest {
	@Test
    void testLoggedOut() {
        User user = new User();
        SecurityContext sec = new SecurityContext(user);

        assertEquals(sec.getState(), LoggedOut.getInstance(sec));

        EncryptedString pwd = new EncryptedString();
        sec.login(pwd);

        sec.logout();
        assertEquals(sec.getState(), LoggedOut.getInstance(sec));
    }

}
