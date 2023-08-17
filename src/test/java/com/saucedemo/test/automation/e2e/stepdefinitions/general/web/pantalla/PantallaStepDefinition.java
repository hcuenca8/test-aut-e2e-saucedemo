package com.saucedemo.test.automation.e2e.stepdefinitions.general.web.pantalla;

import com.saucedemo.test.automation.e2e.questions.general.web.pantalla.SeObservaTexto;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

public class PantallaStepDefinition {

    @Entonces("^debería mostrarse en la web: \"(.*)\".*")
    public static void deberiaMostrarseEnLaWeb(String textos)
    {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        SeObservaTexto.enPantalla(textos,false)
                )
        );
    }

    @Entonces("^debería mostrarse en la web exactamente: \"(.*)\".*")
    public static void deberiaMostrarseEnLaWebExactamente(String textos)
    {
        OnStage.theActorInTheSpotlight().should(
            GivenWhenThen.seeThat(
                SeObservaTexto.enPantalla(textos,true)
            )
        );
    }

    /*
    @Entonces("deberia indicarse {string} la opción {string}, para dar continuidad al proceso")
    public static void deberiaIndicarseLaOpcionParaDarContinuidadAlProceso(String estado, String opcion)
    {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        ElEstado.deLosElementos(
                                OpcionUI.BTN_OPCION_SUBMIT.of(opcion)
                        ).sea(EstadoElemento.valueOf(estado.toUpperCase()))
                )
        );

    }
    */
}
