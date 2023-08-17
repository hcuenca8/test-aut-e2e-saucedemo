package com.saucedemo.test.automation.e2e.tasks.general.web.portal;

import com.saucedemo.test.automation.e2e.constants.enums.configuracion.serenity.SerenityConf;
import com.saucedemo.test.automation.e2e.interactions.web.ventana.Navegar;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

@AllArgsConstructor
public class EntrarAlPortal implements Task
{

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        actor.attemptsTo(
            Navegar.hacia(SerenityConf.URL_BASE.getValor())
        );
    }

    public static EntrarAlPortal web()
    {
       return Tasks.instrumented(
               EntrarAlPortal.class
       );
    }
}
