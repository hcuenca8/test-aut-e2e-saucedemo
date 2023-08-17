package com.saucedemo.test.automation.e2e.constants.enums.tablasgherkin;


import com.saucedemo.test.automation.e2e.constants.enums.tablasgherkin.features.catalogo.producto.ProductosCatalogoTblGherkin;
import com.saucedemo.test.automation.e2e.constants.enums.tablasgherkin.features.compra.comprador.CompradorTblGherkin;
import com.saucedemo.test.automation.e2e.constants.enums.tablasgherkin.features.cuenta.acceso.AccesoTblGherkin;
import com.saucedemo.test.automation.e2e.utils.gherkin.tabla.interfaces.ITablaGherkin;

public enum TablasGherkin
{

    ACCESO(AccesoTblGherkin.values()),
    //PRODUCTO_CATALOGO(ProductoCatalogoTblGherkin.values()),
    PRODUCTOS_CATALOGO(ProductosCatalogoTblGherkin.values()),
    COMPRADOR(CompradorTblGherkin.values()),
    ;

    private final ITablaGherkin<?>[] tablaGherkin;

    TablasGherkin(ITablaGherkin<?>[] tablaGherkin)
    {
        this.tablaGherkin = tablaGherkin;
    }

    public ITablaGherkin<?>[] getTablaGherkin() {
        return tablaGherkin;
    }
}
