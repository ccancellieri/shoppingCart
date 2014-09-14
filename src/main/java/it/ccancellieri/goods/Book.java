package it.ccancellieri.goods;

import it.ccancellieri.taxes.ImportedSaleTax;
import it.ccancellieri.taxes.NoSaleTax;

import java.math.BigDecimal;

/**
 * Represents one of the excepting classes of Goods it only supports
 * ImportedSaleTax and the default {@link NoSaleTax}
 */
public class Book extends Exceptions {

    public Book(BigDecimal price, ImportedSaleTax tax) {
        super(price, tax);
    }

    public Book(BigDecimal price) {
        super(price);
    }

    public Book(String name, BigDecimal price, ImportedSaleTax tax) {
        super(name, price, tax);
    }

    public Book(String name, BigDecimal price) {
        super(name, price);
    }

}
