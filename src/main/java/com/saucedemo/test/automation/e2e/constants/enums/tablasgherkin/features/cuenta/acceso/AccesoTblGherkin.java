package com.saucedemo.test.automation.e2e.constants.enums.tablasgherkin.features.cuenta.acceso;

import com.saucedemo.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.saucedemo.test.automation.e2e.models.params.features.cuenta.acceso.AccesoParams;
import com.saucedemo.test.automation.e2e.utils.gherkin.tabla.interfaces.ITablaGherkin;
import com.saucedemo.test.automation.e2e.utils.gherkin.tabla.utils.TablaGherkinUtil;

public enum AccesoTblGherkin implements ITablaGherkin<AccesoParams>
{
    USUARIO("usuario_acceso"),
    CLAVE("clave_acceso"),
    ;

    private final String columna;

    AccesoTblGherkin(String columna)
    {
        this.columna = columna;
    }

    @Override
    public AccesoParams crearScreen(TablaGherkinUtil deLaTablaGherkin)
    {
        AccesoParams pantalla = AccesoParams.crearParams(
                deLaTablaGherkin.obtener(USUARIO),
                deLaTablaGherkin.obtener(CLAVE)
        );
        Protagonista.principal().getLibreto().setParametrosAcceso(pantalla);

        return pantalla;
    }

    @Override
    public String getColumna() {
        return columna;
    }
}
