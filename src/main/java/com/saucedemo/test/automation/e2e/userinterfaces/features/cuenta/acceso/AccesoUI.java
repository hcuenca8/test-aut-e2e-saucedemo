package com.saucedemo.test.automation.e2e.userinterfaces.features.cuenta.acceso;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AccesoUI
{
    private AccesoUI()
    {
        throw new UnsupportedOperationException();
    }

    public static final Target TXT_USUARIO=
        Target.the("Username")
            .located(By.id("user-name")); //id best strategy
    //.locatedBy("//input[@id='user-name']"); //xpath strategy
    //.locatedBy("#user-name"); //css strategy


    public static final Target TXT_CLAVE=
        Target.the("Password")
            .located(By.id("password")); //id best strategy
    //.locatedBy("//input[@id='password']"); //xpath strategy
    //.locatedBy("#password"); //css strategy


    public static final Target BTN_ACCEDER=
        Target.the("Login")
            .located(By.id("login-button")); //id best strategy
    //.locatedBy("//input[@id='login-button']"); //xpath strategy
    //.locatedBy("#login-button"); //css strategy

}
