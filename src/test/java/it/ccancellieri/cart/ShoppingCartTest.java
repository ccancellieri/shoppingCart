package it.ccancellieri.cart;

import it.ccancellieri.goods.Book;
import it.ccancellieri.goods.Food;
import it.ccancellieri.goods.RegularGood;
import it.ccancellieri.taxes.RegularSaleTax;

import java.math.BigDecimal;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

public class ShoppingCartTest {

    private final static ShoppingCart cart = new ShoppingCart();

    @BeforeClass
    public static void before() {
        cart.buy(new Book("book", new BigDecimal("12.49")));
        cart.buy(new RegularGood("music CD", new BigDecimal("14.99"), new RegularSaleTax()));
        cart.buy(new Food("chocolate bar", new BigDecimal("0.85")));
    }

    @Test
    public void givenAListOfGoods_whenBuy2Items_thenCartIsAbleToCalculateSalesTax() {
        Assert.assertTrue(cart.getSalesTaxes().equals(new BigDecimal("1.50")));
    }
    

    @Test
    public void givenAListOfGoods_whenBuy2Items_thenCartIsAbleToCalculateTheTotal() {
        Assert.assertTrue(cart.getTotal().equals(new BigDecimal("29.83")));
    }


}
