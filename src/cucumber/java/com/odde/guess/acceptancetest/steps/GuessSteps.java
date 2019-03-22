package com.odde.guess.acceptancetest.steps;

import com.odde.guess.acceptancetest.driver.UiDriver;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class GuessSteps {
    @Autowired
    private UiDriver driver;

    @When("^I create a room with secret \"([^\"]*)\"$")
    public void i_create_a_room_with_secret(String arg1) {
        driver.navigateTo("/rooms/create");
        driver.inputTextByName(arg1, "secret");
        driver.clickByText("START");
    }

    @Then("^guess button will be enabled$")
    public void guess_button_will_be_enabled() {
        driver.waitForTextPresent("GUESS");
    }

    @When("^guess \"([^\"]*)\"$")
    public void guess(String arg0) throws Throwable {
        driver.inputTextByName(arg0, "guess");
        driver.clickByText("Go");
    }

    @Then("^win the game$")
    public void winTheGame() throws Throwable {
        driver.waitForTextPresent("You Win!");
    }

    @Then("^show message \"([^\"]*)\"$")
    public void showMessage(String message) throws Throwable {

    }

    @Then("^show message \"([^\"]*)\" and \"([^\"]*)\"$")
    public void showMessageAnd(String guess, String result) throws Throwable {
        driver.waitForTextPresent(guess);
        driver.waitForTextPresent(result);
    }

    @When("^I create a room with a random secret$")
    public void iCreateARoomWithARandomSecret() throws Throwable {
        driver.navigateTo("/rooms/create");
        driver.clickByText("RANDOM");
    }

}
