package it.ccancellieri.taxes;

import it.ccancellieri.utils.RoundTaxRatio;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class TaxTest {

    @Test
    public void givenATax_whenTaxIsMorePreciseThan2_thenTaxMayBeRoundTo0dot05() {
        BigDecimal tax = new BigDecimal("14.03");
        final RoundTaxRatio rounder = new RoundTaxRatio(tax);

        tax = rounder.round();

        BigDecimal roundedTax = new BigDecimal("14.05");
        Assert.assertTrue("Rounded tax is:" + tax + " while should be: " + roundedTax, rounder.round().equals(roundedTax));
    }

}
