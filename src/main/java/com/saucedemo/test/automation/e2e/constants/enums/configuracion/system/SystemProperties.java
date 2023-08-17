package com.saucedemo.test.automation.e2e.constants.enums.configuracion.system;

public enum SystemProperties {

    URL_ROOT_PROJECT("user.dir"),
    URL_PACKAGE_BASE("build.gradle.project.package.base.url"),
    PACKAGE_BASE("gradle.props.project.package.base"),
    URL_PACKAGE_JAVA_TEST("gradle.props.project.package.java.test.url"),
    URL_PACKAGE_RESOURCE_TEST("gradle.props.project.package.resource.test.url"),
    CURRENT_TIME_MILLIS_DEPLOY("build.gradle.system.currentTimeMillis"),
    TOMA_NUMERO("escena.toma.numero"),


    ;

    private final String propiedad;

    SystemProperties(String propiedad)
    {
        this.propiedad = propiedad;
    }

    public String getPropiedad() {
        return propiedad;
    }

    public String getValor(){
        return System.getProperty(this.getPropiedad());
    }
}
