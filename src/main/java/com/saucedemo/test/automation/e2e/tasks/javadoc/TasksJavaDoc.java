package com.saucedemo.test.automation.e2e.tasks.javadoc;


/**
 * Clase que centraliza la documentacion asociada al concepto de tareas (Tasks), en el patron
 * Screenplay
 */
public class TasksJavaDoc {

    /**
     * Clase a quien se le delega la responsabilidad de la(s) accion(s) que llevara a cabo el actor sobre la escena de
     * prueba, por lo regular su alcance se limita a describir una actividad funcional y puntual del actor sobre la
     * escena a traves de una secuencia de acciones
     */
    public static final String CLASE = null;

    /**
     * Zona dedicada al objetivo de la tarea, a traves de la implementacion de la secuencia de acciones, otras tareas o
     * interacciones, que describiran el comportamiento del actor sobre la escena de prueba, al llevar a cabo esta tarea
     */
    public static final String PERFORM_AS = null;

    /**
     * Personalize el nombre de este metodo para ofrecer una mejor diciencia al momento de su utilizacion desde el
     * StepDefinition
     * <br/>Facilita la integracion desde el StepDefinition a traves de una estrategia de invocacion estatica
     * <br/>Para mas informacion de los parametros comunmente utilizados:
     * @see TasksJavaDoc#PARAMETRO_SCREEN
     */
    public static final String ENLACE = null;

    /**
     * <li/> datosPantalla: Habilitar parametro, en caso que la tarea requiera de un insumo de parametros para llevar a
     *                      cabo su objetivo, estos parametros normalmente son enrutados desde el StepDefinition a traves
     *                      del libreto, y se encapsulan dentro de un objeto de concepto 'Screen' (Parametros de Pantalla),
     * @see ScreenJavaDoc#CLASE TODO CONCEPTO SCREEN
     * @see ScenaJavaDoc#Libreto TODO CONCEPTO LIBRETO
     */
    public static final String PARAMETRO_SCREEN = null;

    /**
     * Continue con la integracion de la secuencia de acciones, llamado a otras tareas o interacciones, que en conjunto
     * describen lo que el actor realizara sobre la escena de prueba
     */
    public static final String ENLAZAR_ACCIONES = null;

}
