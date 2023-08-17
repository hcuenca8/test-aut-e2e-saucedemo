package com.saucedemo.test.automation.e2e.utils.serenity.conf;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

public class SerenityConfUtil
{
    private static EnvironmentVariables propiedades = Injectors.getInjector().getInstance(EnvironmentVariables.class);

    private static EnvironmentSpecificConfiguration configuracion = EnvironmentSpecificConfiguration.from(SerenityConfUtil.propiedades);

    private SerenityConfUtil(){
        throw new UnsupportedOperationException();
    }

    public static EnvironmentSpecificConfiguration getConfiguracion(){
        return SerenityConfUtil.configuracion;
    }

    public interface ISerenityConf {

        String getPropiedad();

        default String getValor()
        {
            return EnvironmentSpecificConfiguration.from(SerenityConfUtil.propiedades).getProperty(getPropiedad());
        }

    }

}
