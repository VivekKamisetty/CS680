package edu.umb.cs680.hw05;

public class LoggedOut implements State {

    private SecurityContext ctx;

    // Static instance
    private static LoggedOut instance = null;

    // Private constructor
    private LoggedOut(SecurityContext ctx) {
        this.ctx = ctx;
    }

    // Accessor for static instance
    public static LoggedOut getInstance(SecurityContext ctx) {
//    	System.out.println("LoggedOut get instance");
        if (instance == null) {
            instance = new LoggedOut(ctx);
        }
        return instance;
    }

    @Override
    public void login(EncryptedString pwd) {
        if (Authenticator.authenticate(ctx, pwd)) {
//        	System.out.println("LoggedOut login");
            ctx.changeState(LoggedIn.getInstance(ctx));
        } else {
           	System.out.println("LoggedOut  failed");
        }
    }

    @Override
    public void logout() {

    }

}

