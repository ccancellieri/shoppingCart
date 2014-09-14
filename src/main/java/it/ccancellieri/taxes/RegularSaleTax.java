package it.ccancellieri.taxes;

import it.ccancellieri.goods.Good;
import it.ccancellieri.goods.RegularGood;

import java.math.BigDecimal;

/**
 * represents the Taxes to apply to a {@link Good}
 * @see {@link RegularGood}
 */
public class RegularSaleTax extends Tax {

    // 10 %
    final private static BigDecimal RATE = new BigDecimal(10);

    public RegularSaleTax() {
        super(RATE);
    }

}
