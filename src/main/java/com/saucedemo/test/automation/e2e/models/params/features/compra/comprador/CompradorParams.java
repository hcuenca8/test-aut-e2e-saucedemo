package com.saucedemo.test.automation.e2e.models.params.features.compra.comprador;

import com.saucedemo.test.automation.e2e.models.params.javadoc.ParamsJavaDoc;
import lombok.Builder;
import lombok.Data;


/**
 * Para mas informacion:
 * @see ParamsJavaDoc#CLASE
 */
@Builder
@Data
public class CompradorParams
{

    private String nombre;

    private String apellido;

    private String codigoPostal;


    /**
     * Para mas informacion:
     * @see ParamsJavaDoc#CREAR_PARAMS
     */
    public static CompradorParams crearParams(String nombre, String apellido, String codigoPostal)
    {
        return CompradorParams.builder()
                .nombre(nombre)
                .apellido(apellido)
                .codigoPostal(codigoPostal)
                .build();
    }
}
