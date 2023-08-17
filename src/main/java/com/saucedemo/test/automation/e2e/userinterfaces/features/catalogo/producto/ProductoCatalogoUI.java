package com.saucedemo.test.automation.e2e.userinterfaces.features.catalogo.producto;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductoCatalogoUI
{
    private ProductoCatalogoUI()
    {
        throw new UnsupportedOperationException();
    }

    /**
     * Aunque el boton para adicionar carrito tiene un id, opte por utilizar xpath para darle un tratamiento dinamico,
     * en el cual la estrategia es capaz de ubicar el boton de adicionar con respecto al nombre del producto
     */
    public static final Target BTN_ACCIONAR_CARRITO =
        Target.the("Add to cart")
            .locatedBy("//div[@class='inventory_item_description'][.//div[@class='inventory_item_name'][text()='{0}']]//button[text()='{1}']");
}
