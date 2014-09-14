package it.ccancellieri.goods;

import it.ccancellieri.taxes.ImportedSaleTax;
import it.ccancellieri.taxes.NoSaleTax;

import java.math.BigDecimal;

/**
 * This class classify the Goods as:<br/>
 * 1. A not taxed Good<br/>
 * 2. A Good with {@link ImportedSaleTax}<br/>
 * 
 * @see {@link Tax}, {@link Good}
 */
class Exceptions extends Good {

    protected Exceptions(BigDecimal price) {
        super(price, new NoSaleTax());
    }

    protected Exceptions(final String name, final BigDecimal price) {
        super(name, price, new NoSaleTax());
    }

    protected Exceptions(BigDecimal price, ImportedSaleTax tax) {
        super(price, tax);
    }

    protected Exceptions(final String name, final BigDecimal price, final ImportedSaleTax tax) {
        super(name, price, tax);
    }
}
