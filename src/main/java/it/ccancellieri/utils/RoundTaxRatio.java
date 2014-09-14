package it.ccancellieri.utils;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Helper class which is responsible to define and setup a default safe
 * {@link BigDecimal} implementing round and default settings
 */
public class RoundTaxRatio extends RoundBigDecimal {

    public RoundTaxRatio(BigDecimal bigDecimal) {
        super(bigDecimal);
    }

    /**
     * The rounding rules for sales tax are that for a tax rate of n%, a shelf
     * price of 'p' contains n*p/100 rounded up to the nearest 0.05
     */
    public BigDecimal round() {
        final BigDecimal result = new BigDecimal(Math.ceil(getBigDecimal().doubleValue() * 20) / 20, MathContext.DECIMAL32);
        return result.setScale(getScale(), getRoundingMode());
    }

}
