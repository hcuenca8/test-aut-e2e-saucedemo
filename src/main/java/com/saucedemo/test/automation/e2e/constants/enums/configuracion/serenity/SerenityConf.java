package com.saucedemo.test.automation.e2e.constants.enums.configuracion.serenity;


import com.saucedemo.test.automation.e2e.utils.serenity.conf.SerenityConfUtil;

public enum SerenityConf implements SerenityConfUtil.ISerenityConf
{

    URL_BASE("webdriver.base.url"),
    ;

    private final String propiedad;

    SerenityConf(String propiedad)
    {
        this.propiedad = propiedad;
    }

    @Override
    public String getPropiedad()
    {
        return this.propiedad;
    }

}
