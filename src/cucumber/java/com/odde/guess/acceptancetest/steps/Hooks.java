package com.odde.guess.acceptancetest.steps;

import com.odde.guess.GuessApplication;
import com.odde.guess.acceptancetest.driver.UiDriver;
import cucumber.api.java.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@SpringBootTest(webEnvironment = DEFINED_PORT)
@ContextConfiguration(classes = {GuessApplication.class})
public class Hooks {

    @Autowired
    UiDriver uiDriver;

    @After
    public void closeUiDriver() {
        uiDriver.close();
    }

}
