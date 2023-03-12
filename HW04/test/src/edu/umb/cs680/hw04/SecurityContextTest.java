package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecurityContextTest {

    @Test
    public void testInitialStateMustBeLoggedOut() {
        User user = new User();
        SecurityContext sec = new SecurityContext(user);

        assertFalse(sec.isActive());
    }

    

    @Test
    void testLoggingOut() {
        User user = new User();
        SecurityContext sec = new SecurityContext(user);

        EncryptedString pwd = new EncryptedString();
        sec.login(pwd);
        sec.logout();

        assertFalse(sec.isActive());
    }
    
}
