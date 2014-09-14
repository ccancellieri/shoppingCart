package it.ccancellieri.goods;

import it.ccancellieri.taxes.ImportedRegularSaleTax;
import it.ccancellieri.taxes.RegularSaleTax;

import java.math.BigDecimal;

public class RegularGood extends Good {

    public RegularGood(String name, BigDecimal price, RegularSaleTax tax) {
        super(name, price, tax);
    }

    public RegularGood(BigDecimal price, RegularSaleTax tax) {
        super(price, tax);
    }

    public RegularGood(String name, BigDecimal price, ImportedRegularSaleTax tax) {
        super(name, price, tax);
    }

    public RegularGood(BigDecimal price, ImportedRegularSaleTax tax) {
        super(price, tax);
    }

}
