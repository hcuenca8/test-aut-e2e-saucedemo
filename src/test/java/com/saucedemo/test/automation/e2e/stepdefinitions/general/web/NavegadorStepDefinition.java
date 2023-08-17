package com.saucedemo.test.automation.e2e.stepdefinitions.general.web;


import com.saucedemo.test.automation.e2e.interactions.Depurar;
import com.saucedemo.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.saucedemo.test.automation.e2e.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import com.saucedemo.test.automation.e2e.tasks.general.web.portal.EntrarAlPortal;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

/**
 * Para mas informacion:
 * @see StepDefinitionsJavaDoc#CLASE
 */
public class NavegadorStepDefinition {

    @Managed
    static WebDriver suNavegador;

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#DADO
     */
    @Dado("^que \"(.*)\" ingresó a su navegador.*")
    public static void dadoQueIngresoAlNavegador(String actor)
    {
        //if  (   !Protagonista.haActuadoPreviamente(actor) )
        //{
            Protagonista.haActuadoPreviamente(actor);
            Protagonista.entraEnEscena(actor)
                .whoCan(BrowseTheWeb.with(suNavegador))
                .attemptsTo(
                    Depurar.enConsola("Inicio del Test")
                );
        //}
    }

    @Cuando("^ingresa al portal.*")
    public static void cuandoIngresaAlPortal ()
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_TAREAS
         */
        Protagonista.enEscena().attemptsTo(
            EntrarAlPortal.web()
        );
    }
}
