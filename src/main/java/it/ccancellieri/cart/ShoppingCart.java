package it.ccancellieri.cart;

import it.ccancellieri.goods.Good;
import it.ccancellieri.utils.RoundBigDecimal;
import it.ccancellieri.utils.RoundTaxRatio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible to handle the ShoppingCart
 */
public class ShoppingCart {

    final private List<Good> items = new ArrayList<Good>();

    private RoundBigDecimal total=new RoundBigDecimal(BigDecimal.ZERO);

    private RoundBigDecimal salesTaxes=new RoundTaxRatio(BigDecimal.ZERO);

    public void buy(Good good) {
        if (good==null){
            throw new IllegalArgumentException("Unable to buy a null item");
        }
        total=total.add(good.getTotal());
        salesTaxes=salesTaxes.add(good.getTaxes());
        items.add(good);
    }
    
    List<Good> getItems() {
        return items;
    }

    public BigDecimal getTotal() {
        return total.round();
    }

    public BigDecimal getSalesTaxes() {
        return salesTaxes.round();
    }

}
