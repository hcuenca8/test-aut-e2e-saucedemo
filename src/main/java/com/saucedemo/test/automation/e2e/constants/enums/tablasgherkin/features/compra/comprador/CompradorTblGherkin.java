package com.saucedemo.test.automation.e2e.constants.enums.tablasgherkin.features.compra.comprador;

import com.saucedemo.test.automation.e2e.constants.enums.tablasgherkin.javadoc.TblGherkinJavaDoc;
import com.saucedemo.test.automation.e2e.models.params.features.compra.comprador.CompradorParams;
import com.saucedemo.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.saucedemo.test.automation.e2e.utils.gherkin.tabla.interfaces.ITablaGherkin;
import com.saucedemo.test.automation.e2e.utils.gherkin.tabla.utils.TablaGherkinUtil;


/**
 * Para mas informacion:
 * @see TblGherkinJavaDoc#CLASE
 */
public enum CompradorTblGherkin implements ITablaGherkin<CompradorParams>
{
    NOMBRE("nombre_comprador"),
    APELLIDO("apellido_comprador"),
    CODIGO_POSTAL("codigo_postal_comprador"),
    ;

    private final String columna;

    CompradorTblGherkin(String columna)
    {
        this.columna = columna;
    }

    @Override
    public CompradorParams crearScreen(TablaGherkinUtil deLaTablaGherkin)
    {
        CompradorParams parametros = CompradorParams.crearParams(
                deLaTablaGherkin.obtener(NOMBRE),
                deLaTablaGherkin.obtener(APELLIDO),
                deLaTablaGherkin.obtener(CODIGO_POSTAL)
        );

        Protagonista.principal().getLibreto().setParametrosComprador(parametros);

        return parametros;
    }

    @Override
    public String getColumna() {
        return columna;
    }
}
