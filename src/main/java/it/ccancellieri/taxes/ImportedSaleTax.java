package it.ccancellieri.taxes;

import it.ccancellieri.goods.Good;
import it.ccancellieri.goods.Medical;

import java.math.BigDecimal;

/**
 * represents the Taxes to apply to an imported excepting {@link Good}
 * @see {@link Food}, {@link Medical}, {@link Book}
 */
public class ImportedSaleTax extends Tax {

    // 5 %
    final private static BigDecimal RATE = new BigDecimal(5);

    public ImportedSaleTax() {
        super(RATE);
    }
}
