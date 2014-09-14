package it.ccancellieri.goods;

import it.ccancellieri.taxes.ImportedSaleTax;

import java.math.BigDecimal;

public class Medical extends Exceptions {

    public Medical(String name, BigDecimal price) {
        super(name, price);
    }

    public Medical(BigDecimal price, ImportedSaleTax tax) {
        super(price, tax);
    }

    public Medical(BigDecimal price) {
        super(price);
    }

    public Medical(String name, BigDecimal price, ImportedSaleTax tax) {
        super(name, price, tax);
    }

}
