package com.saucedemo.test.automation.e2e.stepdefinitions.features.portal;

import com.saucedemo.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.saucedemo.test.automation.e2e.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import com.saucedemo.test.automation.e2e.tasks.features.portal.IrDetalleCarrito;
import io.cucumber.java.es.Cuando;

/**
 * Para mas informacion:
 * @see StepDefinitionsJavaDoc#CLASE
 */
public class PortalStepDefinition
{

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#CUANDO
     */
    @Cuando("^se traslada para el detalle del carrito de compra.*")
    public static void cuandoSeTrasladaParaElDetalleDelCarritoDeCompra()
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_TAREAS
         */
        Protagonista.enEscena().attemptsTo(
            IrDetalleCarrito.deCompra()
        );
    }
}
