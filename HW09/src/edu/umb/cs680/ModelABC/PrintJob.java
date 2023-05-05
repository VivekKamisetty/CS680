package edu.umb.cs680.ModelABC;

import edu.umb.cs680.PrintingFramework.Command;

public class PrintJob implements Command {
    public void execute() {
        Printer cmdPrint = new Printer();
        cmdPrint.print();
    }
}
