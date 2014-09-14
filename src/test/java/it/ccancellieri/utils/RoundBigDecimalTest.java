package it.ccancellieri.utils;

import java.math.BigDecimal;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

public class RoundBigDecimalTest {
    private static RoundBigDecimal price;

    @BeforeClass
    public static void beforeClass() {
        price = new RoundBigDecimal(new BigDecimal("12.495"));
    }

    @Test
    public void givenARoundBigDecimalWithDefaultParamsWrapsAnHigherNumberOfDecimalPlacesBigDecimalValue_whenRoundIsCalled_thenTheReturnedBigDecimalShouldBeRoundedToDefaultDecimalPlaces() {
        Assert.assertTrue("Price is: " + price + " and rounded price is: " + price.round(), price.round().equals(new BigDecimal("12.50")));
    }
}
