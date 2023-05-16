package edu.umb.cs680.ModelABC;

import edu.umb.cs680.PrintingFramework.Command;
import edu.umb.cs680.hw09.EncryptedString;
import edu.umb.cs680.hw09.LoggedIn;
import edu.umb.cs680.hw09.SecurityContext;

public class PrintJobExecutor extends edu.umb.cs680.PrintingFramework.PrintJobExecutor {

    @Override
    public void execute(Command job, EncryptedString pwd, SecurityContext ctx) throws Exception {
        try {
            this.doAuthentication(pwd, ctx);
        }
        catch (Exception e){
            doErrorHandling();
            throw e;
        }

        this.doAccessControl();
        this.doPrint(job, pwd, ctx);
        this.doErrorHandling();
    }

    @Override
    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws Exception{
            ctx.login(pwd);
    }

    @Override
    protected void doAccessControl() {

    }

    @Override
    protected void doPrint(Command job, EncryptedString pwd, SecurityContext ctx) {

        try {
            doAuthentication(pwd, ctx);
        }
        catch (Exception e){
            doErrorHandling();
        }
        if(ctx.getState() instanceof LoggedIn) {
            job.execute();
        }
        else{
            doErrorHandling();
        }

    }

    @Override
    protected void doErrorHandling() {

    }
}