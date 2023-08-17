package com.saucedemo.test.automation.e2e.stepdefinitions.javadoc;


/**
 * Clase que centraliza la documentacion asociada al concepto de la definacion de paso (StepDefinitions), en el patron
 * Screenplay
 */
public class StepDefinitionsJavaDoc {

    /**
     * Clase que permite a Cucumber, conectar/enrutar el lenguaje funcional con su equivalente resolucion tecnica, al
     * encontrar un metodo StepDefinition que satisfaga el enunciado gherkin plasmado en el archivo .feature
     */
    public static final String CLASE = null;

    /**
     * Permite la traduccion e interpretacion de los enunciados gherkin Dado (Given), que se relacionan con la secuencia
     * de acciones previas, necesarias para alcanzar el contexto en el que se realizara la escena de prueba
     * <br/>Para mas informacion de los parametros comunmente utilizados:
     * @see StepDefinitionsJavaDoc#PARAMETRO_ACTOR
     * @see StepDefinitionsJavaDoc#PARAMETRO_LIBRETO
     */
    public static final String DADO = null;

    /**
     * Enlace secuencialmente con los metodos DADO y CUANDO de la pantalla anterior (stepDefinition anterior), que segun el flujo,
     * al ejecutarse permita llegar a donde el enunciado gherkin del DADO dice encontrarse
     */
    public static final String ENLAZAR_ESCENA_PREVIA_PANTALLA_ANTERIOR = null;


    /**
     * Permite la traduccion e interpretacion de los enunciados gherkin Cuando (When), que se relacionan con la secuencia
     * de acciones, que se realizaran durante la escena de prueba
     * <br/>Para mas informacion de los parametros comunmente utilizados:
     * @see StepDefinitionsJavaDoc#PARAMETRO_LIBRETO
     */
    public static final String CUANDO = null;

    /**
     * Enlace con el metodo DADO de la pantalla actual (este stepDefinition), que segun el flujo,
     * al estar ubicado en la pantalla actual, procedera a desencadenar las acciones propuestas por el escenario
     */
    public static final String ENLAZAR_ESCENA_EN_ACCION_DADO_ACTUAL = null;

    /**
     * Continue con la integracion hacia la(s) Tarea(s) (Task(s)), responsable(s) de ejecutar las acciones del actor
     * durante la escena
     */
    public static final String ENLAZAR_TAREAS = null;

    /**
     * Permite la traduccion e interpretacion de los enunciados gherkin Entonces (Then), que se relacionan con los
     * comportamientos esperados, consecuencias, al terminar las acciones realizadas durante la escena de prueba
     */
    public static final String ENTONCES = null;

    /**
     * Continue con la integracion hacia la(s) Preguntas(s) (Question(s)), responsable(s) de ejecutar la(s)
     * validacion(s)/verificacion(s) sobre el escenario ejecutado, diseñadas con base a los comportamientos esperados
     * y que se aplicaran sobre las consecuencias obtenidas al terminar las acciones realizadas por el actor durante la
     * escena de prueba
     */
    public static final String ENLAZAR_PREGUNTAS = null;

    /**
     * <li/> actor: Nombre/descripcion del actor que protagoniza la escena
     */
    public static final String PARAMETRO_ACTOR = null;

    /**
     * <li/> libreto:   Habilitar parametro, en caso que el enunciado gherkin conlleve una tabla de parametros asociada
     *                  (tabla gherkin)
     */
    public static final String PARAMETRO_LIBRETO = null;
}
