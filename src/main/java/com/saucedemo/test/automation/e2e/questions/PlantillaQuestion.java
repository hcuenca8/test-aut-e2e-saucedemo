package com.saucedemo.test.automation.e2e.questions;

import com.saucedemo.test.automation.e2e.questions.javadoc.QuestionsJavaDoc;
import lombok.Builder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * Para mas informacion:
 * @see QuestionsJavaDoc#CLASE
 */
@Builder
public class PlantillaQuestion implements Question<Boolean>
{
    //private {{TipoParametro}} parametro;

    /**
     * Para mas informacion:
     * @see QuestionsJavaDoc#ANSWERED_BY
     */
    @Override
    public Boolean answeredBy(Actor actor)
    {
        /**
         * Para mas informacion:
         * @see QuestionsJavaDoc#ENLAZAR_VALIDACIONES_VERIFICACIONES
         */
        boolean resultado;

        resultado = false;

        return resultado;
    }

    /**
     * Para mas informacion:
     * @see QuestionsJavaDoc#ENLACE
     */
    public static PlantillaQuestion enlace(/*{{TipoParametro}} parametro*/)
    {
        return PlantillaQuestion.builder()
            //.parametro(parametro)
            .build();
    }
}
