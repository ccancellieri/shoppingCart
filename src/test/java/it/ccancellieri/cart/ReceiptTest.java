package it.ccancellieri.cart;

import it.ccancellieri.goods.Book;
import it.ccancellieri.goods.Food;
import it.ccancellieri.goods.RegularGood;
import it.ccancellieri.taxes.RegularSaleTax;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ReceiptTest {

    private final ShoppingCart cart = new ShoppingCart();

    @Before
    public void before() {

        cart.buy(new Book("book", new BigDecimal("12.49")));
        cart.buy(new RegularGood("music CD", new BigDecimal("14.99"), new RegularSaleTax()));
        cart.buy(new Food("chocolate bar", new BigDecimal("0.85")));

    }

    @Test
    public void givenAShoppingCart_whenPurcaseAllItems_thenIReceiveAReceiptListingAllTheNamesAndTheirPriceInTheDesiredFormat() {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = null;
        try {
            ps = new PrintStream(baos);

            final Receipt receipt = new Receipt(cart, ps);
            receipt.printReceipt();

            // System.out.println(baos.toString());
            Assert.assertTrue(baos.toString().equals("1 book: 12.49\n1 music CD: 16.49\n1 chocolate bar: 0.85\nSales Taxes: 1.50\nTotal: 29.83\n"));
        } finally {
            if (ps != null) {
                ps.close();
            }
        }

    }

}
