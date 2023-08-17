package com.saucedemo.test.automation.e2e.interactions.web.ventana;


import com.saucedemo.test.automation.e2e.interactions.Detener;
import com.saucedemo.test.automation.e2e.utils.web.navegador.VentanaUtil;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Switch;

@AllArgsConstructor
public class Trasladar implements Interaction {

    private boolean porTitulo;
    private String contenido;

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        //String idPestanyaActual = VentanaUtils.getIdPestanyaActual(actor);

        for (   String idPestanya : VentanaUtil.getIdPestanyas(actor)  )
        {
            //if  (   !idPestanyaActual.equals(idPestanya)  )
            //{
                actor.attemptsTo(
                        Switch.toWindow(idPestanya),
                        Detener.por(1).segundos()
                );
                if  (   this.porTitulo
                    &&  VentanaUtil.getTituloPestanya(actor).contains(this.contenido)
                    ||  !this.porTitulo
                    &&  VentanaUtil.getURLPestanyaActual(actor).contains(this.contenido)
                ) {
                    break;
                }
            //}
        }
    }

    public static Trasladar aPestanya(boolean porTitulo, String contenido)
    {
        return Tasks.instrumented(Trasladar.class,porTitulo, contenido);
    }
}
