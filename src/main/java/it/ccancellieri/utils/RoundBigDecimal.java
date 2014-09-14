package it.ccancellieri.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Helper class which is responsible to define and setup a default safe
 * {@link BigDecimal} implementing round default setup
 */
public class RoundBigDecimal {

    private BigDecimal bigDecimal;

    private static int defaultScale = 2;
    private int scale;

    private static RoundingMode defaultRoundingMode = RoundingMode.HALF_UP;
    private RoundingMode roundingMode;

    public RoundBigDecimal(BigDecimal bigDecimal, int scale, RoundingMode roundingMode) {
        if (bigDecimal == null) {
            throw new IllegalArgumentException("Null value argument for bigDecimal");
        }
        if (roundingMode == null) {
            throw new IllegalArgumentException("Null value argument for roundingMode");
        }
        this.bigDecimal = bigDecimal;
        this.scale = scale;
        this.roundingMode = roundingMode;
    }

    public RoundBigDecimal(BigDecimal bigDecimal) {
        this(bigDecimal, defaultScale, defaultRoundingMode);
    }

    @Override
    public String toString() {
        return this.bigDecimal.toString();
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    protected int getScale() {
        return scale;
    }

    protected void setScale(int scale) {
        this.scale = scale;
    }

    protected RoundingMode getRoundingMode() {
        return roundingMode;
    }

    protected void setRoundingMode(RoundingMode roundingMode) {
        this.roundingMode = roundingMode;
    }

    public BigDecimal round() {
        return getBigDecimal().setScale(scale, roundingMode);
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    /**
     * delegate method
     * 
     * @return
     */
    public int compareTo(BigDecimal val) {
        return getBigDecimal().compareTo(val);
    }

    public RoundBigDecimal add(BigDecimal toAdd) {
        return new RoundBigDecimal(getBigDecimal().add(toAdd));
    }

    public RoundBigDecimal divide(BigDecimal divisor) {
        return new RoundBigDecimal(getBigDecimal().divide(divisor));
    }

}
