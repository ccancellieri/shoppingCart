package it.ccancellieri.utils;

import java.math.BigDecimal;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

public class RoundTaxRatioTest {
    private static RoundBigDecimal tax,tax2;

    @BeforeClass
    public static void beforeClass() {
        tax = new RoundTaxRatio(new BigDecimal("12.08"));
        tax2 = new RoundTaxRatio(new BigDecimal("12.033"));
    }

    @Test
    public void givenARoundTaxRatioWithDefaultParamsWrappingABigDecimalValue_whenRoundIsCalled_thenTheReturnedBigDecimalShouldBeRoundedToTheColsest0dot05() {
        Assert.assertTrue("Tax is: " + tax + " and rounded tax is: " + tax.round(), tax.round().equals(new BigDecimal("12.10")));
        Assert.assertTrue("Tax is: " + tax2 + " and rounded tax is: " + tax2.round(), tax2.round().equals(new BigDecimal("12.05")));
    }

}
