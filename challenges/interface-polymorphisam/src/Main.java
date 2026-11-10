import impl.MultiFunctionalPrinter;
import interfaces.Printable;
import interfaces.Scannable;


public class Main {
    public static void main(String[] args) {
        //printer-interface-reference
        Printable print = new MultiFunctionalPrinter();
        print. print();
        //scan-interface-reference
        Scannable scan = new MultiFunctionalPrinter();
        scan.scan();
        //multifunctional-printer-reference
        MultiFunctionalPrinter multiFunctionalPrinter = new MultiFunctionalPrinter();
        multiFunctionalPrinter.fax();
        multiFunctionalPrinter.scan();
        multiFunctionalPrinter.print();
    }
}