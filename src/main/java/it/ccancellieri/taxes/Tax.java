package it.ccancellieri.taxes;

import it.ccancellieri.utils.RoundBigDecimal;
import it.ccancellieri.utils.RoundTaxRatio;

import java.math.BigDecimal;

/**
 * This class represents a 'tax' to pay defined in terms of {@link #rate} ('%').
 * It is responsible to calculate the tax amount given a price.
 * 
 * @see {@link Tax#calculateTax(BigDecimal)}
 */
public class Tax {

    private BigDecimal rate;

    private static BigDecimal percent = new BigDecimal("100");

    protected Tax(BigDecimal rate) {
        if (rate == null) {
            this.rate = BigDecimal.ZERO;
        } else {
            this.rate = rate;
        }
    }

    protected Tax() {
        this(BigDecimal.ZERO);
    }

    public BigDecimal getRate() {
        return rate;
    }

    protected void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * @param price not null price
     * @return the amount of taxes
     */
    public BigDecimal calculateTax(BigDecimal price) {

        if (price == null) {
            throw new IllegalArgumentException("Price should be !null");
        } else if (rate.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        } else if (price.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }

        final RoundBigDecimal taxAmount = new RoundTaxRatio(price.multiply(rate.divide(percent)));
        return taxAmount.round();
    }
}
