package com.saucedemo.test.automation.e2e.userinterfaces.general.web.pantalla;

import net.serenitybdd.screenplay.targets.Target;

public class ContenidoWebUI
{
    private ContenidoWebUI()
    {
        throw new UnsupportedOperationException();
    }

    public static final Target LBL_TEXTO=
        Target.the("texto similar a: {0}")
            .locatedBy("//*[contains(text(),'{0}')]");

    public static final Target LBL_TEXTO_EXACTO=
        Target.the("exactamente el texto: {0}")
            .locatedBy("//*[text()='{0}']");


}
