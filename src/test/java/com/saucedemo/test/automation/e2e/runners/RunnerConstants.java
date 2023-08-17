package com.saucedemo.test.automation.e2e.runners;

public class RunnerConstants {

    private RunnerConstants(){
        throw new UnsupportedOperationException();
    }

    private final static String BASE = "com.saucedemo.test.automation.e2e";
    private final static String URL = "src/test/resources/com/saucedemo/test/automation/e2e";

    public final static String PACKAGE_STEP_DEFINITIONS = BASE+".stepdefinitions";
    public final static String PACKAGE_DATA_DEFINITIONS = BASE+".datadefinitions";
    public final static String PACKAGE_SETUPS = BASE+".setups";
    public final static String PACKAGE_FEATURES = URL+"/features";

}
