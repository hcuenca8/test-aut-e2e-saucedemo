package com.saucedemo.test.automation.e2e.runners.javadoc;

import com.saucedemo.test.automation.e2e.utils.GeneralUtil;

/**
 * Clase que centraliza la documentacion asociada al concepto de lanzadores (runners)
 */
public class RunnersJavaDoc {

    /**
     * Clase que permite desplegar/lanzar el proceso de automatizacion guiado por las configuraciones de @CucumberOptions
     * <li/> snippets:  Notacion CamelCase, en la generacion de metodos propuestos por Cucumber, al no encontrar StepDefinition
     * <li/> features:  Ruta del(s) archivo(s) .feature donde se encuentran los escenarios y casos de prueba escritos en gherkin
     * <li/> glue:      Rutas donde Cucumber buscara para conectar el gherkin con el StepDefinition que satisface el enunciado
     * <li/> tags:      Tags que identifica/selecciona los escenarios y/o casos que se ejecutaran al lanzar el runner
     * <li/> dryRun:    Destina y enfoca la ejecucion del runner a la comprobacion equivalente entre los enunciados gherkin y
     *                  los StepDefinition, de no encuentrar la relacion, desplegara las propuestas de generacion de metodos
     *                  StepDefinition esperados por Cucumber. Solo se activa para realizar esta comprobacion
     */
    public static final String CLASE = null;

    /**
     * El despliegue del lanzador no amerita la creacion de una instancia, para ello use:
     * <br/>Constructor privado con el soporte para que no permita instanciar
     * @see GeneralUtil#noPermitaInstanciar()
     */
    public static final String CONSTRUCTOR = null;
}
