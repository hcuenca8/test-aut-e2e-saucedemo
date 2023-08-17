package com.saucedemo.test.automation.e2e.utils.gherkin.tabla.interfaces;

import com.saucedemo.test.automation.e2e.utils.gherkin.tabla.utils.TablaGherkinUtil;

public interface ITablaGherkin<T> {


    String getColumna();
    T crearScreen(TablaGherkinUtil deLaTablaGherkin);

}
