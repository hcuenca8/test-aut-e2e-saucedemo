package com.saucedemo.test.automation.e2e.interactions;
import com.saucedemo.test.automation.e2e.utils.trazas.TrazaUtil;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

@AllArgsConstructor
public class Depurar implements Interaction {

    private String mensaje;
    private boolean breakPoint;

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        TrazaUtil.informacion(this.mensaje);
        if(this.breakPoint){
            this.breakPoint = !this.breakPoint;

        }
    }

    public static Depurar enConsola(String mensaje)
    {
        return Tasks.instrumented(Depurar.class,mensaje,false);
    }

    public static Depurar breakPoint(String consola)
    {
        return Tasks.instrumented(Depurar.class,consola,true);
    }
}
