package com.rpm.test.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.di.SerenityInfrastructure;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;

import com.rpm.test.utils.db.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Hooks {
    private static Logger logger = Logger.getLogger(Hooks.class.getName());

    @Managed
    private WebDriver userBrowser;

    @Managed
    private EnvironmentVariables environmentVariables;

    private Actor Clinician;

    public Connection connection;


    @Before(order = 1)
    public void setup() {
        OnStage.setTheStage(new OnlineCast());
        Clinician = OnStage.theActorCalled("Clinician");
        Clinician.whoCan(BrowseTheWeb.with(userBrowser));
    }

    @After(order = 1)
    public void tearDown() {
        userBrowser.close();
        userBrowser.quit();
    }

}
