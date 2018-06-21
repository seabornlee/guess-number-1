package com.odde.guess.acceptancetest.driver;

import com.odde.guess.common.Params;

public interface UiDriver {
    void close();

    void navigateTo(String url);

    void navigateToWithParams(String url, Params params);

    void waitForTextPresent(String text);

    void inputTextByName(String text, String name);

    void clickByText(String text);

    void selectOptionByTextAndElementName(String text, String elementName);

    String getAllTextInPage();
}
