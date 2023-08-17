package com.saucedemo.test.automation.e2e.interactions.web.ventana;

import com.saucedemo.test.automation.e2e.utils.web.navegador.VentanaUtil;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

@AllArgsConstructor
public class Cerrar implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        VentanaUtil.cerrarPestanya(actor);
    }

    public static Cerrar pestanya()
    {
        return Tasks.instrumented(Cerrar.class);
    }
}
