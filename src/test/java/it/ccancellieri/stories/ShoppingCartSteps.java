package it.ccancellieri.stories;

import it.ccancellieri.goods.Good;
import it.ccancellieri.goods.RegularGood;
import it.ccancellieri.taxes.ImportedRegularSaleTax;
import it.ccancellieri.taxes.ImportedSaleTax;
import it.ccancellieri.taxes.RegularSaleTax;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import junit.framework.Assert;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class ShoppingCartSteps {

    private static final String PACKAGE = "it.ccancellieri.goods.";

    private BigDecimal price;
    private Good good;

    @Given("a <quantity> of <good_name> at <price>")
    public void givenAquantityOfgood_nameAtprice(@Named("quantity")
    String quantity, @Named("good_name")
    String goodName, @Named("price")
    String price) {
        this.price = new BigDecimal(price);
    }

    @When("the <good_name> is <imported> and is <regular>")
    public void whenThegood_nameIsimportedAndIsregular(@Named("good_name")
    String goodName, @Named("imported")
    Boolean imported, @Named("regular")
    Boolean regular) {
        try {
            good = mapNameToGood(goodName, price, regular, imported);
        } catch (Exception e) {
            // e.printStackTrace(); // TODO removeMe (DEBUG)
            Assert.fail(e.getLocalizedMessage());
        }
    }

    @Then("the sales taxes is <taxes>")
    public void thenTheSalesTaxesIstaxes(@Named("taxes")
    String taxes) {
        // System.out.println("---------------------------");
        // System.out.println("TAXES: " + (good.getTaxes()));
        // System.out.println("TAXES_IN: " + taxes);
        Assert.assertTrue(good.getTaxes().compareTo(new BigDecimal(taxes)) == 0);
    }

    @Then("the price is <price_after_taxes>")
    public void thenThePriceIsprice_after_taxes(@Named("price_after_taxes")
    String priceAfterTaxes) {
        // System.out.println("---------------------------");
        // System.out.println("NAME: " + (good.getName()));
        // System.out.println("PRICE: " + (good.getPrice()));
        // System.out.println("SUM: " + good.getTotal());
        // System.out.println("PRICEaFTERtAXES: " + priceAfterTaxes);
        // System.out.println("EQUALS: " + (good.getTotal()).compareTo(new
        // BigDecimal(priceAfterTaxes)));

        Assert.assertTrue(good.getTotal().compareTo(new BigDecimal(priceAfterTaxes)) == 0);

    }

    private Good mapNameToGood(String goodName, BigDecimal price, boolean regular, boolean imported) throws SecurityException, NoSuchMethodException, IllegalArgumentException,
        InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {

        if (regular) {
            if (imported) {
                return new RegularGood(goodName, price, new ImportedRegularSaleTax());
            } else {
                return new RegularGood(goodName, price, new RegularSaleTax());
            }
        } else {
            final Class goodClass = Class.forName(PACKAGE + goodName);
            if (imported) {
                Constructor<Good> constructor = goodClass.getConstructor(new Class[] {String.class, BigDecimal.class, ImportedSaleTax.class});
                return constructor.newInstance(goodName, price, new ImportedSaleTax());
            } else {
                Constructor<Good> constructor = goodClass.getConstructor(new Class[] {String.class, BigDecimal.class});
                return constructor.newInstance(goodName, price);
            }
        }
    }
}
