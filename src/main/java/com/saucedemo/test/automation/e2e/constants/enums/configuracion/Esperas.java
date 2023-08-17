package com.saucedemo.test.automation.e2e.constants.enums.configuracion;

public enum Esperas {

    GENERAL(20),
    FINALIZANDO_TAREA(1),

    ;

    private final long tiempo;

    Esperas(long tiempo){
        this.tiempo = tiempo;
    }

    public long getTiempo() {
        return tiempo;
    }
}
