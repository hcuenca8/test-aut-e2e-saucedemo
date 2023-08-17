package com.saucedemo.test.automation.e2e.constants.enums.tablasgherkin.features.catalogo.producto;

import com.saucedemo.test.automation.e2e.models.params.features.catalogo.producto.ProductoCatalogoParams;
import com.saucedemo.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.saucedemo.test.automation.e2e.utils.gherkin.tabla.interfaces.ITablaGherkin;
import com.saucedemo.test.automation.e2e.utils.gherkin.tabla.utils.TablaGherkinUtil;

public enum ProductoCatalogoTblGherkin implements ITablaGherkin<ProductoCatalogoParams>
{
    NOMBRE("producto_catalogo"),
    ;

    private final String columna;

    ProductoCatalogoTblGherkin(String columna)
    {
        this.columna = columna;
    }

    @Override
    public ProductoCatalogoParams crearScreen(TablaGherkinUtil deLaTablaGherkin)
    {
        ProductoCatalogoParams pantalla = ProductoCatalogoParams.crearParams(
                deLaTablaGherkin.obtener(NOMBRE)
        );
        Protagonista.principal().getLibreto().setParametrosProductoCatalogo(pantalla);

        return pantalla;
    }

    @Override
    public String getColumna() {
        return columna;
    }
}
