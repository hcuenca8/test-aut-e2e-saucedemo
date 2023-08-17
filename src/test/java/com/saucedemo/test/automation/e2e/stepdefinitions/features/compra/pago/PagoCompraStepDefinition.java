package com.saucedemo.test.automation.e2e.stepdefinitions.features.compra.pago;

import com.saucedemo.test.automation.e2e.models.scena.Libreto;
import com.saucedemo.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.saucedemo.test.automation.e2e.stepdefinitions.features.compra.comprador.DatosCompradorStepDefinition;
import com.saucedemo.test.automation.e2e.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import com.saucedemo.test.automation.e2e.tasks.features.compra.pago.ConfirmarPago;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;

/**
 * Para mas informacion:
 * @see StepDefinitionsJavaDoc#CLASE
 */
public class PagoCompraStepDefinition
{
    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#DADO
     */
    @Dado("^que el \"(.*)\" se encuentra confirmando el pago de su compra.*")
    public static void dadoQueSeEncuentraConfirmandoElPagoDeSuCompra(String actor, Libreto libreto)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_ESCENA_PREVIA_PANTALLA_ANTERIOR
         */
        DatosCompradorStepDefinition.dadoQueSeEncuentraCompletandoSuInformacionPersonalParaSuCompra(actor, libreto);
        DatosCompradorStepDefinition.cuandoConfirmaSusDatosPersonales(libreto);
    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#CUANDO
     */
    @Cuando("^confirma su pago.*")
    public static void cuandoConfirmaSuPago()
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_TAREAS
         */
        Protagonista.enEscena().attemptsTo(
            ConfirmarPago.deLaCompra()
        );
    }

}
