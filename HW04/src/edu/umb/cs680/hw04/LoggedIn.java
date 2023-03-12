package edu.umb.cs680.hw04;

public class LoggedIn implements State {

    private SecurityContext ctx;

    // Static instance
    private static LoggedIn instance = null;

    // Private constructor
    private LoggedIn(SecurityContext ctx) {
        this.ctx = ctx;
    }

    // Accessor for static instance
    public static LoggedIn getInstance(SecurityContext ctx) {
//        System.out.println("LoggedIn getInstance");
    	if (instance == null) {
            instance = new LoggedIn(ctx);
        }
        return instance;
    }

    @Override
    public void login(EncryptedString pwd) {
        if ((!ctx.isActive())) {
            ctx.changeState(LoggedOut.getInstance(ctx));
            ctx.login(pwd);
        }

    }

    @Override
    public void logout() {
        ctx.changeState(LoggedOut.getInstance(ctx));
//        System.out.println("logout from LoggedIn");

    }

}