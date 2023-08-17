package com.saucedemo.test.automation.e2e.models.params.features.cuenta.acceso;

import com.saucedemo.test.automation.e2e.models.params.javadoc.ParamsJavaDoc;
import lombok.Builder;
import lombok.Data;


/**
 * Para mas informacion:
 * @see ParamsJavaDoc#CLASE
 */
@Builder
@Data
public class AccesoParams
{

    private String usuario;

    private String clave;


    /**
     * Para mas informacion:
     * @see ParamsJavaDoc#CREAR_PARAMS
     */
    public static AccesoParams crearParams(String usuario, String clave)
    {
        return AccesoParams.builder()
                .usuario(usuario)
                .clave(clave)
                .build();
    }
}
