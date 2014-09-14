package it.ccancellieri.taxes;

import it.ccancellieri.goods.Good;
import it.ccancellieri.goods.RegularGood;

import java.math.BigDecimal;

/**
 * Represents the Taxes to apply to an imported {@link Good}
 * 
 * @see {@link RegularGood}
 */
public class ImportedRegularSaleTax extends Tax {

    // 15 %
    final private static BigDecimal RATE = new BigDecimal(15);

    public ImportedRegularSaleTax() {
        super(RATE);
    }

}
