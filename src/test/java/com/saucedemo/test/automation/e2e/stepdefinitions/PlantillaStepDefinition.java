package com.saucedemo.test.automation.e2e.stepdefinitions;

import com.saucedemo.test.automation.e2e.stepdefinitions.general.web.pantalla.PantallaStepDefinition;
import com.saucedemo.test.automation.e2e.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import com.saucedemo.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.saucedemo.test.automation.e2e.questions.PlantillaQuestion;
import com.saucedemo.test.automation.e2e.tasks.PlantillaTask;
import net.serenitybdd.screenplay.GivenWhenThen;

/**
 * Para mas informacion:
 * @see StepDefinitionsJavaDoc#CLASE
 */
public class PlantillaStepDefinition
{
    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#DADO
     */
    //@Dado("^que \"(.*)\" se encuentra {{active la sentencia y adapte la expresion que satisfaga el enunciado gherkin}}.*")
    public static void dadoQueSeEncuentra(String actor/*, Libreto libreto*/)
    {
        if  (   !Protagonista.haActuadoPreviamente(actor) )
        {
            /**
             * @see StepDefinitionsJavaDoc#ENLAZAR_ESCENA_PREVIA_PANTALLA_ANTERIOR
             */
            //{{PantallaAnterior}}StepDefinition.dado{{QueMeEncuentroEnLaPantallaAnterior}}(/*libreto*/);
            //{{PantallaAnterior}}StepDefinition.cuando{{EjecutoLoQueMePermiteEncontrarmeAqui}}(/*libreto*/);

        }
    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#CUANDO
     */
    //@Cuando("^{{active la sentencia y adapte la expresion que satisfaga el enunciado gherkin}}.*")
    public static void cuando(/*Libreto libreto*/)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_TAREAS
         */
        Protagonista.enEscena().attemptsTo(
            //tasks/features/../{{Tarea}}.{{sobreLaPantalla}}(libreto.getDatosPantalla{{Pantalla}}) // enlazar con Task
            PlantillaTask.enlace()
        );
    }

    /**
     * VALIDE SI ES NECESARIO UTILIZAR LA ZONA DE DEFINICION DE "ENTONCES", para realizar validaciones/verificaciones
     * especificas, puede explorar en la zona de stepdefinitions.general algunas definiciones de "ENTONCES", genericas
     * que estan disponibles para su uso, por ejemplo:
     * <br/>{@link PantallaStepDefinition#deberiaMostrarseEnLaWeb(String)}
     * PantallaStepDefinition.deberiaMostrasEnPantalla()
     * <br/>EN CASO DE NO UTILIZAR ESTA ZONA, REMUEVALA POR COMPLETO (COMENTARIO Y METODO) DE SU StepDefinition,
     * <br/>EN CASO CONTRARIO ASEGURESE DE REMOVER DEL COMENTARIO DESQUE AQUI, HACIA ATRAS.
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#ENTONCES
     */
    //@Entonces("^deberia{{active la sentencia y adapte la expresion que satisfaga el enunciado gherkin}}.*")
    public static void entoncesDeberia()
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_PREGUNTAS
         */
        Protagonista.enEscena().should(
            GivenWhenThen.seeThat(
                PlantillaQuestion.enlace() // Enlazar con Question
            )
        );
    }

}
