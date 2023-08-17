package com.saucedemo.test.automation.e2e.tasks.features.portal;

import com.saucedemo.test.automation.e2e.tasks.javadoc.TasksJavaDoc;
import com.saucedemo.test.automation.e2e.userinterfaces.features.portal.ResumenCarritoCompraUI;
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
public class IrDetalleCarrito implements Task
{
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
            Click.on(ResumenCarritoCompraUI.LNK_CARRITO)
        );
    }

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#ENLACE
     */
    public static IrDetalleCarrito deCompra()
    {
       return Tasks.instrumented(
               IrDetalleCarrito.class
       );
    }
}
