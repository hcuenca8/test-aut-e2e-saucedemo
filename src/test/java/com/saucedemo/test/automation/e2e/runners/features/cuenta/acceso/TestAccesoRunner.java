package com.saucedemo.test.automation.e2e.runners.features.cuenta.acceso;

import com.saucedemo.test.automation.e2e.runners.javadoc.RunnersJavaDoc;
import com.saucedemo.test.automation.e2e.runners.RunnerConstants;
import com.saucedemo.test.automation.e2e.utils.GeneralUtil;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


/**
 * Para mas informacion:
 * @see RunnersJavaDoc#CLASE
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    features = RunnerConstants.PACKAGE_FEATURES+"/cuenta/acceso/acceso.feature",
    glue = {RunnerConstants.PACKAGE_STEP_DEFINITIONS,RunnerConstants.PACKAGE_SETUPS},
    tags = "@Acceso and @Regresion",
    dryRun = false //Desactive, despues de comprobar la existencia/relacion entre enunciado gherkin y StepDefinition
)
public class TestAccesoRunner
{
    /**
     * Para mas informacion:
     * @see RunnersJavaDoc#CONSTRUCTOR
     */
    private TestAccesoRunner()
    {
        GeneralUtil.noPermitaInstanciar();
    }
}
