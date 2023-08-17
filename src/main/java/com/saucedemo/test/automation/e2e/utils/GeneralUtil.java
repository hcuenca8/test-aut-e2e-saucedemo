package com.saucedemo.test.automation.e2e.utils;

import com.saucedemo.test.automation.e2e.utils.javadoc.JavaDocUtil;

/**
 * Utilidades de uso general y transversal para el proyecto
 */
public class GeneralUtil
{
    /**
     * Constructor privado con el soporte para que no permita instanciar
     * <br/>Para mas informacion:
     * @see JavaDocUtil#CONSTRUCTOR
     */
    private GeneralUtil(){
        GeneralUtil.noPermitaInstanciar();
    }

    /**
     * Impedir la instancia directa (new), tanto para uso interno, como desde otras clases
     */
    public static void noPermitaInstanciar(){
        throw new UnsupportedOperationException();
    }

    /**
     * excepcion de operacion no soportada
     */
    public static void operacionNoSoportada(){
        throw new UnsupportedOperationException();
    }
}
