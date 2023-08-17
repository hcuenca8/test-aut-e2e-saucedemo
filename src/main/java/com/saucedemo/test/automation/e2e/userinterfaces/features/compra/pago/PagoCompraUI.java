package com.saucedemo.test.automation.e2e.userinterfaces.features.compra.pago;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PagoCompraUI
{
    private PagoCompraUI()
    {
        throw new UnsupportedOperationException();
    }

    public static final Target BTN_FINALIZAR=
        Target.the("Finish")
            .located(By.id("finish"));

}
