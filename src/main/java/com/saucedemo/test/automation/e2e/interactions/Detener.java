package com.saucedemo.test.automation.e2e.interactions;


import com.saucedemo.test.automation.e2e.utils.tiempo.constants.enums.UnidadTiempo;
import com.saucedemo.test.automation.e2e.utils.tiempo.utils.EsperaUtil;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class Detener
{
    private long tiempo;

    private static final long A_SEGUNDOS= 1000;
    private static final long A_MINUTOS= A_SEGUNDOS*60;
    private static final long A_MILISEGUNDOS= 1;

    private Detener(long tiempo)
    {
        this.tiempo = tiempo;
    }

    private class DetenerPor implements Interaction
    {
        private long milisegundos;
        private UnidadTiempo unidad;

        private DetenerPor(long milisegundos, UnidadTiempo unidad){
            this.milisegundos = milisegundos;
            this.unidad = unidad;
        }

        @Override
        public <T extends Actor> void performAs(T actor)
        {
            EsperaUtil.detenerPor(this.milisegundos,this.unidad);
        }
    }

    public static Detener por(long tiempo)
    {
        return new Detener(tiempo);
    }

    public DetenerPor segundos()
    {
        //this.tiempo = this.tiempo * Detener.A_SEGUNDOS;
        return new DetenerPor(this.tiempo,UnidadTiempo.SEGUNDOS);
    }

    public DetenerPor minutos()
    {
        //this.tiempo = this.tiempo * Detener.A_MINUTOS;
        return new DetenerPor(this.tiempo,UnidadTiempo.MINUTOS);
    }

    public DetenerPor milisegundos()
    {
        //this.tiempo = this.tiempo * Detener.A_MILISEGUNDOS;
        return new DetenerPor(this.tiempo,UnidadTiempo.MILISEGUNDOS);
    }

}
