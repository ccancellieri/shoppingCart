package it.ccancellieri.goods;

import it.ccancellieri.taxes.ImportedRegularSaleTax;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class GoodTest {

    @Test
    public void givenARegularGood_whenPriceIsMorePreciseThan2_thenPriceMayBeUnchanged() {
        BigDecimal price = new BigDecimal("12.49");
        Good g = new RegularGood(price, new ImportedRegularSaleTax());
        Assert.assertTrue("Price is:" + g.getPrice() + " while should be: " + price, g.getPrice().equals(price));
    }

    @Test
    public void givenARegularGood_whenPriceIsMorePreciseThan2_thenPriceMayBeRoundedTo2() {
        BigDecimal price = new BigDecimal("12.4964");
        BigDecimal roundedPrice = new BigDecimal("12.50");
        Good g = new RegularGood(price, new ImportedRegularSaleTax());
        Assert.assertTrue("Price is:" + g.getPrice() + " while should be: " + roundedPrice, g.getPrice().equals(roundedPrice));
    }

}
