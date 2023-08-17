package com.saucedemo.test.automation.e2e.userinterfaces.features.compra.comprador;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatosCompradorUI
{
    private DatosCompradorUI()
    {
        throw new UnsupportedOperationException();
    }

    public static final Target TXT_NOMBRE=
        Target.the("First Name")
            .located(By.id("first-name"));

    public static final Target TXT_APELLIDO=
        Target.the("Last Name")
            .located(By.id("last-name"));

    public static final Target TXT_CODIGO_POSTAL=
        Target.the("Postal Code")
            .located(By.id("postal-code"));

    public static final Target BTN_CONTINUAR=
        Target.the("Continue")
            .located(By.id("continue"));

}
