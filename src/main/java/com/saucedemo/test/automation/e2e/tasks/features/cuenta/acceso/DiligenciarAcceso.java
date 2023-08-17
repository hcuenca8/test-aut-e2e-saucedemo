package com.saucedemo.test.automation.e2e.tasks.features.cuenta.acceso;

import com.saucedemo.test.automation.e2e.constants.enums.configuracion.Esperas;
import com.saucedemo.test.automation.e2e.interactions.Detener;
import com.saucedemo.test.automation.e2e.interactions.Esperar;
import com.saucedemo.test.automation.e2e.models.params.features.cuenta.acceso.AccesoParams;
import com.saucedemo.test.automation.e2e.tasks.javadoc.TasksJavaDoc;
import com.saucedemo.test.automation.e2e.userinterfaces.features.cuenta.acceso.AccesoUI;
import com.saucedemo.test.automation.e2e.utils.gherkin.tabla.utils.TablaGherkinUtil;
import com.saucedemo.test.automation.e2e.utils.questions.estadoelementos.constants.enums.EstadoElemento;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;

/**
 * Para mas informacion:
 * @see TasksJavaDoc#CLASE
 */
@AllArgsConstructor
public class DiligenciarAcceso implements Task
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

            Esperar.hastaQue(AccesoUI.TXT_USUARIO)
                   .este(EstadoElemento.VISIBLE)
                   .porNoMasDe(Esperas.GENERAL.getTiempo()).segundos(),

            Check.whether(TablaGherkinUtil.campoNoNull(this.parametros.getUsuario()))
                .andIfSo(
                    Enter.theValue(this.parametros.getUsuario())
                        .into(AccesoUI.TXT_USUARIO)
                ),

            Check.whether(TablaGherkinUtil.campoNoNull(this.parametros.getClave()))
                .andIfSo(
                    Enter.theValue(this.parametros.getClave())
                        .into(AccesoUI.TXT_CLAVE)
                ),

            Detener.por(Esperas.FINALIZANDO_TAREA.getTiempo()).segundos()
        );
    }

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#ENLACE
     */
    public static DiligenciarAcceso aLaCuenta(AccesoParams parametros)
    {
       return Tasks.instrumented(
           DiligenciarAcceso.class,
           parametros

       );
    }
}
