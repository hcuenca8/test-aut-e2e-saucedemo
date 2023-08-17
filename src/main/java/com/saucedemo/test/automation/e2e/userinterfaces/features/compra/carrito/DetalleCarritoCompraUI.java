package com.saucedemo.test.automation.e2e.userinterfaces.features.compra.carrito;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DetalleCarritoCompraUI
{
    private DetalleCarritoCompraUI()
    {
        throw new UnsupportedOperationException();
    }

    public static final Target BTN_CONFIRMA_PEDIDO=
        Target.the("Checkout")
            .located(By.id("checkout"));

}
