package com.saucedemo.test.automation.e2e.utils.tiempo.constants.enums;

public enum UnidadTiempo {

    SEGUNDOS(1000),
    MINUTOS(1000*60),
    MILISEGUNDOS(1),
    ;

    private final long escalaMilisegundos;

    UnidadTiempo(long escalaMilisegundos){
        this.escalaMilisegundos = escalaMilisegundos;
    }

    public long getEscalaMilisegundos(){
        return this.escalaMilisegundos;
    }

}
