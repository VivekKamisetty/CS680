package edu.umb.cs680.PrintingFramework;

import edu.umb.cs680.ModelABC.PrintJob;
import edu.umb.cs680.hw09.EncryptedString;
import edu.umb.cs680.hw09.SecurityContext;

public abstract class PrintJobExecutor {
    public void execute(Command job, EncryptedString pwd, SecurityContext ctx) throws Exception{
        try {
            doAuthentication(pwd, ctx);
        }
        catch (Exception e) {
            doErrorHandling();
            throw e;
        }
        doPrint(job, pwd, ctx);
    }

    protected abstract void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws Exception;

    protected abstract void doAccessControl();


    protected abstract void doPrint(Command job, EncryptedString pwd, SecurityContext ctx);

    protected abstract void doErrorHandling();

}