package com.saucedemo.test.automation.e2e.models.params.features.catalogo.producto;

import com.saucedemo.test.automation.e2e.models.params.javadoc.ParamsJavaDoc;
import lombok.Builder;
import lombok.Data;


/**
 * Para mas informacion:
 * @see ParamsJavaDoc#CLASE
 */
@Builder
@Data
public class ProductoCatalogoParams
{

    private String nombre;


    /**
     * Para mas informacion:
     * @see ParamsJavaDoc#CREAR_PARAMS
     */
    public static ProductoCatalogoParams crearParams(String nombre)
    {
        return ProductoCatalogoParams.builder()
                .nombre(nombre)
                .build();
    }
}
