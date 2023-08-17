package com.saucedemo.test.automation.e2e.stepdefinitions.features.cuenta.acceso;

import com.saucedemo.test.automation.e2e.models.scena.Libreto;
import com.saucedemo.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.saucedemo.test.automation.e2e.stepdefinitions.general.web.NavegadorStepDefinition;
import com.saucedemo.test.automation.e2e.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import com.saucedemo.test.automation.e2e.tasks.features.cuenta.acceso.Acceder;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;

/**
 * Para mas informacion:
 * @see StepDefinitionsJavaDoc#CLASE
 */
public class AccesoStepDefinition
{
    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#DADO
     */
    @Dado("^que el \"(.*)\" se encuentra en el control de acceso.*")
    public static void dadoQueSeEncuentraEnElControlDeAcceso(String actor)
    {
        //if  (   !Protagonista.haActuadoPreviamente(actor) )
        //{
            /**
             * @see StepDefinitionsJavaDoc#ENLAZAR_ESCENA_PREVIA_PANTALLA_ANTERIOR
             */

            NavegadorStepDefinition.dadoQueIngresoAlNavegador(actor);
            NavegadorStepDefinition.cuandoIngresaAlPortal();
        //}

    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#CUANDO
     */
    @Cuando("^intenta acceder con credenciales.*")
    public static void cuandoIntentaAccederConCredenciales(Libreto libreto)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_TAREAS
         */
        Protagonista.enEscena().attemptsTo(
            Acceder.aLaCuenta(libreto.getParametrosAcceso())
        );
    }


}
