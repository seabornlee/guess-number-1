package com.odde.guess.acceptancetest.steps;

import com.odde.guess.GuessApplication;
import com.odde.guess.acceptancetest.data.ApplicationConfigurations;
import com.odde.guess.acceptancetest.driver.UiDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@SpringBootTest(webEnvironment = DEFINED_PORT)
@ContextConfiguration(classes = {GuessApplication.class})
public class Hooks {

    @Autowired
    UiDriver uiDriver;

    @Autowired
    ApplicationConfigurations applicationConfigurations;

    @After
    public void closeUiDriver() {
        uiDriver.close();
    }

    @After("@restoreApplicationConfiguration")
    public void restoreApplicationConfiguration() {
        applicationConfigurations.restore();
    }

}
