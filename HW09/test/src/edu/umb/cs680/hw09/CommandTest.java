package edu.umb.cs680.hw09;

import edu.umb.cs680.ModelABC.PrintJobExecutor;
import edu.umb.cs680.PrintingFramework.Command;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandTest {

    @Test
    public void testPrintingFunctionality(){
        User user = new User();
        SecurityContext sec = new SecurityContext(user);
        assertEquals(sec.getState(), LoggedOut.getInstance(sec));
        EncryptedString pwd = new EncryptedString();
        sec.login(pwd);

        PrintJobExecutor ex = new PrintJobExecutor();
        Command job = null;
        String msg = "Printing from Printer";
        ex.execute(job, pwd, sec);
    }
}
