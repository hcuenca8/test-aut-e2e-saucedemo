package com.saucedemo.test.automation.e2e.stepdefinitions.features.compra.comprador;

import com.saucedemo.test.automation.e2e.models.scena.Libreto;
import com.saucedemo.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.saucedemo.test.automation.e2e.stepdefinitions.features.compra.carrito.CarritoCompraStepDefinition;
import com.saucedemo.test.automation.e2e.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import com.saucedemo.test.automation.e2e.tasks.features.compra.comprador.ConfirmarDatosCliente;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;

/**
 * Para mas informacion:
 * @see StepDefinitionsJavaDoc#CLASE
 */
public class DatosCompradorStepDefinition
{
    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#DADO
     */
    @Dado("^que el \"(.*)\" se encuentra completando su informacion personal para su compra.*")
    public static void dadoQueSeEncuentraCompletandoSuInformacionPersonalParaSuCompra(String actor, Libreto libreto)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_ESCENA_PREVIA_PANTALLA_ANTERIOR
         */
        CarritoCompraStepDefinition.dadoQueSeEncuentraRevisandoSusArticulosEnSuCarritoDeCompras(actor, libreto);
        CarritoCompraStepDefinition.cuandoConfirmaElPedidoDeArticulosDeSuCarritoDeCompras();
    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#CUANDO
     */
    @Cuando("^confirma sus datos datos personales.*")
    public static void cuandoConfirmaSusDatosPersonales(Libreto libreto)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_TAREAS
         */
        Protagonista.enEscena().attemptsTo(
            ConfirmarDatosCliente.deLaCompra(libreto.getParametrosComprador())
        );
    }

}
