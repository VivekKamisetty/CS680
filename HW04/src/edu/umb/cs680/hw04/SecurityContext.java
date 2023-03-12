package edu.umb.cs680.hw04;

public class SecurityContext {
    
    State currentState;
    User user;
    
    public SecurityContext(User user) {
        this.user = user;
        currentState = LoggedOut.getInstance(this);
    }
    
    public State getState() {
        return currentState;
    }
    
    public void changeState(State s) {
    	System.out.println("Chsnging state to " + s);
    	currentState = s;
    }
    
    public void login(EncryptedString pwd) {
//    	System.out.println("SecurityContext login");
        currentState.login(pwd);
    }
    
    public void logout() {
        currentState.logout();
    }
    
    public boolean isActive() {
        if (user != null && currentState instanceof LoggedIn) {
            return true;
        }
        return false;
    }
}