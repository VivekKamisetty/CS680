package edu.umb.cs680.hw09;

import edu.umb.cs680.ModelABC.PrintJob;
import edu.umb.cs680.ModelABC.PrintJobExecutor;
import edu.umb.cs680.ModelABC.Printer;
import edu.umb.cs680.PrintingFramework.Command;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;




public class CommandTest {

    private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream erorrContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outputContent));
        System.setErr(new PrintStream(erorrContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }


    @Test
    public void testPrintingFunctionality() throws Exception {
        User user = new User();
        SecurityContext sec = new SecurityContext(user);
        assertEquals(sec.getState(), LoggedOut.getInstance(sec));
        EncryptedString pwd = new EncryptedString();
        sec.login(pwd);

        PrintJobExecutor ex = new PrintJobExecutor();
        Command job = new PrintJob();
        String msg = "Printing From Printer\n";
        ex.execute(job, pwd, sec);
        assertEquals(msg, outputContent.toString());
    }

    @Test
    public void SingletonTest() {
        Printer a = Printer.getInstance();
        Printer b = Printer.getInstance();
        assertSame(a, b);
    }

}
