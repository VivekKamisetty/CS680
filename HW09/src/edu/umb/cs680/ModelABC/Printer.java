package edu.umb.cs680.ModelABC;

public class Printer {
    private static Printer instance = null;

    private Printer() {
    }

    public static Printer getInstance() {
        if (instance == null) {
            instance = new Printer();
        }
        return instance;
    }

    public void print() {
        System.out.println("Printing From Printer");
    }
}
