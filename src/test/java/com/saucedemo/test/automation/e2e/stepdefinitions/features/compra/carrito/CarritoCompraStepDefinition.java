package com.saucedemo.test.automation.e2e.stepdefinitions.features.compra.carrito;

import com.saucedemo.test.automation.e2e.models.scena.Libreto;
import com.saucedemo.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.saucedemo.test.automation.e2e.stepdefinitions.features.catalogo.producto.CatalogoProductoStepDefinition;
import com.saucedemo.test.automation.e2e.stepdefinitions.features.portal.PortalStepDefinition;
import com.saucedemo.test.automation.e2e.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import com.saucedemo.test.automation.e2e.tasks.features.compra.carrito.ConfirmarPedidoCarrito;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;

/**
 * Para mas informacion:
 * @see StepDefinitionsJavaDoc#CLASE
 */
public class CarritoCompraStepDefinition
{
    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#DADO
     */
    @Dado("^que el \"(.*)\" se encuentra revisando sus articulos en su carrito de compras.*")
    public static void dadoQueSeEncuentraRevisandoSusArticulosEnSuCarritoDeCompras(String actor, Libreto libreto)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_ESCENA_PREVIA_PANTALLA_ANTERIOR
         */
        CatalogoProductoStepDefinition.dadoQueHaTerminadoDeAgregarArticulosASuCarritoDeCompras(actor, libreto);
        PortalStepDefinition.cuandoSeTrasladaParaElDetalleDelCarritoDeCompra();
    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#CUANDO
     */
    @Cuando("^confirma el pedido de articulos de su carrito de compras.*")
    public static void cuandoConfirmaElPedidoDeArticulosDeSuCarritoDeCompras()
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_TAREAS
         */
        Protagonista.enEscena().attemptsTo(
            ConfirmarPedidoCarrito.deCompra()
        );
    }

}
