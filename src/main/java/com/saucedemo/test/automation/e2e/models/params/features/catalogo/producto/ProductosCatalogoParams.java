package com.saucedemo.test.automation.e2e.models.params.features.catalogo.producto;

import com.saucedemo.test.automation.e2e.models.params.javadoc.ParamsJavaDoc;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


/**
 * Para mas informacion:
 * @see ParamsJavaDoc#CLASE
 */
@Builder
@Data
public class ProductosCatalogoParams
{

    private List<ProductoCatalogoParams> lstProductos;

    private static final String SEPARADOR_PRODUCTOS = ";";


    /**
     * Para mas informacion:
     * @see ParamsJavaDoc#CREAR_PARAMS
     */
    public static ProductosCatalogoParams crearParams(String nombres)
    {
        List<ProductoCatalogoParams> lstProductos = new ArrayList<>();
        for(String nombre : nombres.split(SEPARADOR_PRODUCTOS))
        {
            lstProductos.add(ProductoCatalogoParams.crearParams(nombre.trim()));
        }

        return ProductosCatalogoParams.builder()
                .lstProductos(lstProductos)
                .build();
    }
}
