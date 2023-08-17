package com.saucedemo.test.automation.e2e.interactions.web.ventana;


import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

@AllArgsConstructor
public class Navegar implements Interaction
{
    private String url;

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        actor.attemptsTo(
            Open.url(this.url)
        );
    }

    public static Navegar hacia(String url)
    {
       return Tasks.instrumented(
               Navegar.class,
               url
       );
    }
}
