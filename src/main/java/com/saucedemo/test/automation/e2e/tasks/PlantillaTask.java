package com.saucedemo.test.automation.e2e.tasks;

import com.saucedemo.test.automation.e2e.tasks.javadoc.TasksJavaDoc;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

/**
 * Para mas informacion:
 * @see TasksJavaDoc#CLASE
 */
@AllArgsConstructor
public class PlantillaTask implements Task
{
    //private {{Pantalla}}Params parametros;

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#PERFORM_AS
     */
    @Override
    public <T extends Actor> void performAs(T actor)
    {
        /**
         * Para mas informacion:
         * @see TasksJavaDoc#ENLAZAR_ACCIONES
         */
        actor.attemptsTo(

        );
    }

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#ENLACE
     */
    public static PlantillaTask enlace(/*{{Pantalla}}Params parametros*/)
    {
       return Tasks.instrumented(
               PlantillaTask.class/*,
               parametros
               */
       );
    }
}
