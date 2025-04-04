package com.digital.nomads.layers.web.pages.talentLMS;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.digital.nomads.layers.web.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage<LoginPage> {

    public SelenideElement usernameInput = $(By.name("login"));
    public SelenideElement passwordInput = $(By.name("password"));
    public SelenideElement loginBtn = $(By.name("submit"));

    @Step("Login with credentials: username: {0}, password: {1}")
    public AdminDashboardPage doLogin(String login, String password) {
        elementManager.shouldVisible(usernameInput);
        setUsername(login);
        setPassword(password);
        return Selenide.page(submit(new AdminDashboardPage()));
    }

    @Step("Set username: {0}")
    public LoginPage setUsername(String username) {
        elementManager.input(usernameInput, username);
        return this;
    }

    @Step("Set password: {0}")
    public LoginPage setPassword(String password) {
        elementManager.input(passwordInput, password);
        return this;
    }

    @Step("Submit login")
    public <T extends BasePage> T submit(T expectedPage) {
        loginBtn.click();
        return expectedPage;
    }

    @Step("Check that page is loaded")
    @Override
    public LoginPage waitForPageLoaded() {
        usernameInput.shouldBe(Condition.visible);
        passwordInput.shouldBe(Condition.visible);
        return this;
    }
}
