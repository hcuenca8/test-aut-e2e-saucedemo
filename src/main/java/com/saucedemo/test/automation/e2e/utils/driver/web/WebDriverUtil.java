package com.saucedemo.test.automation.e2e.utils.driver.web;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;

public class WebDriverUtil
{
    private WebDriverUtil(){
        throw new UnsupportedOperationException();
    }

    public static WebDriver getDriver(Actor actor)
    {
        return  BrowseTheWeb.as(actor).getDriver();
    }

    public static WebDriver getDriver()
    {
        return  WebDriverUtil.getDriver(OnStage.theActorInTheSpotlight());
    }

    public static WebDriverFacade getDriverFacade(Actor actor)
    {
        return (WebDriverFacade) WebDriverUtil.getDriver(actor);
    }

    public static WebDriverFacade getDriverFacade()
    {
        return (WebDriverFacade) WebDriverUtil.getDriver(OnStage.theActorInTheSpotlight());
    }

    public static WebDriver getDriverProxy(Actor actor)
    {
        return WebDriverUtil.getDriverFacade(actor).getProxiedDriver();
    }

    public static WebDriver getDriverProxy()
    {
        return WebDriverUtil.getDriverFacade(OnStage.theActorInTheSpotlight()).getProxiedDriver();
    }

}
