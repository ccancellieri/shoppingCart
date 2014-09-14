package it.ccancellieri.taxes;

import it.ccancellieri.goods.Good;
import it.ccancellieri.goods.Medical;

import java.math.BigDecimal;

/**
 * Represents the Taxes to apply to an excepting {@link Good} (no taxes at all)
 * @see {@link Food}, {@link Medical}, {@link Book}
 */
public class NoSaleTax extends Tax {

    // 0 %
    final private static BigDecimal RATE = BigDecimal.ZERO;

    public NoSaleTax() {
        super(RATE);
    }

}
