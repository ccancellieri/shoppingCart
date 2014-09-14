package it.ccancellieri.cart;

import it.ccancellieri.goods.Good;

import java.io.PrintStream;

/**
 * This class represents a Receipt and is responsible to print itself against an
 * open PrintStream (note that the responsibility to close the PrintStream is left to the caller)
 */
public class Receipt {

    private ShoppingCart cart;

    private PrintStream printer;

    public Receipt(ShoppingCart cart) {
        this.cart = cart;
        this.printer = System.out;
    }

    public Receipt(ShoppingCart cart, PrintStream printer) {
        if (cart == null || printer == null) {
            throw new IllegalArgumentException("Unable to build a receipt with null arguments");
        }
        this.cart = cart;
        this.printer = printer;
    }

    public void printReceipt() {
        for (Good item : cart.getItems()) {
            printer.print("1 ");
            printer.append(item.getName());
            printer.append(": ");
            printer.append(item.getTotal().toString());
            printer.append("\n");
        }
        printer.append("Sales Taxes: ");
        printer.append(cart.getSalesTaxes().toString());
        printer.append("\n");
        printer.append("Total: ");
        printer.append(cart.getTotal().toString());
        printer.append("\n");
        printer.flush();
    }

}
