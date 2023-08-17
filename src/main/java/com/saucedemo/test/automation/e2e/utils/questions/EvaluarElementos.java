package com.saucedemo.test.automation.e2e.utils.questions;

import com.saucedemo.test.automation.e2e.constants.enums.configuracion.Esperas;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class EvaluarElementos implements Question<Boolean>
{
    private Target[] elementos;

    @Override
    public Boolean answeredBy(Actor actor)
    {
        actor.attemptsTo(
                WaitUntil.the(this.elementos[0], WebElementStateMatchers.isVisible()).forNoMoreThan(Esperas.GENERAL.getTiempo()).seconds()
        );

        boolean resultado = true;

        for (   Target elemento : this.elementos )
        {
            if  (   !(resultado = this.validaQue(actor,elemento))  ){
                break;
            }
        }

        return resultado;
    }

    protected abstract boolean validaQue(Actor actor, Target elemento);

}
