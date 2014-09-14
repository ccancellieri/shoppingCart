package it.ccancellieri.goods;

import it.ccancellieri.taxes.Tax;
import it.ccancellieri.utils.RoundBigDecimal;

import java.math.BigDecimal;

/**
 * This class represents a Good. It is responsible to track the status of the
 * Good and it's main
 */
public class Good {

    private final String name;

    private final RoundBigDecimal price;

    private final Tax tax;

    /**
     * @param name (optional: the class name will be used if no one is provided)
     * @param price (mandatory)
     * @param tax (mandatory)
     */
    protected Good(final String name, final BigDecimal price, final Tax tax) {
        if (price == null) {
            throw new IllegalArgumentException("Unable to create a good with null price");
        } else if (tax == null) {
            throw new IllegalArgumentException("Unable to create a good without taxes");
        }
        if (name == null || name.isEmpty()) {
            this.name = getClass().getSimpleName();
        } else {
            this.name = name;
        }
        this.tax = tax;
        this.price = new RoundBigDecimal(price);
    }

    protected Good(final BigDecimal price, final Tax tax) {
        this(null, price, tax);
    }
    
    public BigDecimal getPrice() {
        return price.round();
    }

    public BigDecimal getTotal() {
        return price.add(getTaxes()).getBigDecimal();
    }

    public BigDecimal getTaxes() {
        return tax.calculateTax(price.getBigDecimal());
    }

    public BigDecimal getTaxRate() {
        return tax.getRate();
    }

    public String getName() {
        return name;
    }

}
