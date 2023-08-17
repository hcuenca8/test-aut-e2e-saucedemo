package com.saucedemo.test.automation.e2e.tasks.features.compra.comprador;

import com.saucedemo.test.automation.e2e.constants.enums.configuracion.Esperas;
import com.saucedemo.test.automation.e2e.interactions.Detener;
import com.saucedemo.test.automation.e2e.models.params.features.compra.comprador.CompradorParams;
import com.saucedemo.test.automation.e2e.tasks.javadoc.TasksJavaDoc;
import com.saucedemo.test.automation.e2e.userinterfaces.features.compra.comprador.DatosCompradorUI;
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
public class ConfirmarDatosCliente implements Task
{

    private CompradorParams parametros;

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

            DiligenciarDatosCliente.deLaCompra(this.parametros),

            Click.on(DatosCompradorUI.BTN_CONTINUAR),

            Detener.por(Esperas.FINALIZANDO_TAREA.getTiempo()).segundos()
        );
    }

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#ENLACE
     */
    public static ConfirmarDatosCliente deLaCompra(CompradorParams parametros)
    {
       return Tasks.instrumented(
           ConfirmarDatosCliente.class,
           parametros
       );
    }
}
