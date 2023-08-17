package com.saucedemo.test.automation.e2e.constants.enums;


public enum EtiquetadoComo
{
    //Etiquetas en Pantalla

    ADICIONAR("Add to cart"),
    RETIRAR("Remove"),
    ;

    private final String etiqueta;

    EtiquetadoComo(String etiqueta)
    {
        this.etiqueta = etiqueta;
    }

    public String enPantalla()
    {
        return this.etiqueta;
    }
}
