package impl;

import interfaces.Printable;
import interfaces.Scannable;

public class MultiFunctionalPrinter implements Printable, Scannable {

    @Override
    public void print() {
        System.out.println("Printing.....!!");
    }

    @Override
    public void scan() {
        System.out.println("Scanning.....!!");
    }

    public void fax(){
        System.out.println("Faxing.....!!   ");
    }
}
