package com.saucedemo.test.automation.e2e.tasks.features.cuenta.acceso;

import com.saucedemo.test.automation.e2e.constants.enums.configuracion.Esperas;
import com.saucedemo.test.automation.e2e.interactions.Detener;
import com.saucedemo.test.automation.e2e.models.params.features.cuenta.acceso.AccesoParams;
import com.saucedemo.test.automation.e2e.tasks.javadoc.TasksJavaDoc;
import com.saucedemo.test.automation.e2e.userinterfaces.features.cuenta.acceso.AccesoUI;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

/**
 * Para mas informacion:
 * @see TasksJavaDoc#CLASE
 */
@AllArgsConstructor
public class Acceder implements Task
{
    private AccesoParams parametros;

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#PERFORM_AS
     */
    @Override
    public <T extends Actor> void performAs(T actor)
    {
        /**
         * Para mas informacion:
         * @see TasksJavaDoc#ENLAZAR_ACCIONES
         */
        actor.attemptsTo(

            DiligenciarAcceso.aLaCuenta(this.parametros),

            Click.on(AccesoUI.BTN_ACCEDER),

            Detener.por(Esperas.FINALIZANDO_TAREA.getTiempo()).segundos()
        );
    }

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#ENLACE
     */
    public static Acceder aLaCuenta(AccesoParams parametros)
    {
       return Tasks.instrumented(
           Acceder.class,
           parametros
       );
    }
}
