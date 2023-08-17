package com.saucedemo.test.automation.e2e.constants.enums.tablasgherkin.features.catalogo.producto;

import com.saucedemo.test.automation.e2e.models.params.features.catalogo.producto.ProductosCatalogoParams;
import com.saucedemo.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.saucedemo.test.automation.e2e.utils.gherkin.tabla.interfaces.ITablaGherkin;
import com.saucedemo.test.automation.e2e.utils.gherkin.tabla.utils.TablaGherkinUtil;

public enum ProductosCatalogoTblGherkin implements ITablaGherkin<ProductosCatalogoParams>
{
    NOMBRES("productos_catalogo"),
    ;

    private final String columna;

    ProductosCatalogoTblGherkin(String columna)
    {
        this.columna = columna;
    }

    @Override
    public ProductosCatalogoParams crearScreen(TablaGherkinUtil deLaTablaGherkin)
    {
        ProductosCatalogoParams parametros = ProductosCatalogoParams.crearParams(
                deLaTablaGherkin.obtener(NOMBRES)
        );
        Protagonista.principal().getLibreto().setParametrosProductosCatalogo(parametros);

        return parametros;
    }

    @Override
    public String getColumna() {
        return columna;
    }
}
