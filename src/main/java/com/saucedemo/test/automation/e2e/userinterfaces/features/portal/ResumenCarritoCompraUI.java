package com.saucedemo.test.automation.e2e.userinterfaces.features.portal;

import net.serenitybdd.screenplay.targets.Target;

public class ResumenCarritoCompraUI
{
    private ResumenCarritoCompraUI()
    {
        throw new UnsupportedOperationException();
    }

    public static final Target BTN_RESUMEN_TOTAL_COMPRA=
        Target.the("Summary items")
            .locatedBy("//span[@class='shopping_cart_badge'][text()='{0}']");

    public static final Target LNK_CARRITO=
        Target.the("Link cart")
            .locatedBy("//a[@class='shopping_cart_link']");
}
