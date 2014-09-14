package it.ccancellieri.goods;

import it.ccancellieri.taxes.ImportedSaleTax;

import java.math.BigDecimal;

/**
 * The food is classified as an Exception:<br/>
 */
public class Food extends Exceptions {

    public Food(String name, BigDecimal price) {
        super(name, price);
    }

    public Food(BigDecimal price, ImportedSaleTax tax) {
        super(price, tax);
    }

    public Food(BigDecimal price) {
        super(price);
    }

    public Food(String name, BigDecimal price, ImportedSaleTax tax) {
        super(name, price, tax);
    }

}
