package com.digital.nomads.tests.web;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.digital.nomads.layers.web.pages.demoqa.MainPage;
import com.digital.nomads.layers.web.pages.talentLMS.LoginPage;
import com.digital.nomads.tests.BaseTest;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import static com.codeborne.selenide.Configuration.*;
import static com.digital.nomads.config.ConfigurationManager.getBaseConfig;
import static com.digital.nomads.config.ConfigurationManager.getCredentialConfig;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseWebTest extends BaseTest {

    public final String BASE_DemoQA_URL = getBaseConfig().baseDemoQAUrl();
    public final String BASE_LMS_URL = getBaseConfig().baseLmsUrl();


    static {
        browser = "chrome";
        browserSize = "1920x1080";
        headless = getBaseConfig().headless();
        holdBrowserOpen = false;
        if (getBaseConfig().remote())
            remote = getBaseConfig().dockerUrl();
    }

    @Step("Open the {1}")
    public <T> T openTalentLMSLoginPage(String endPoint, Class<T> clazz) {
        LoginPage loginPage = Selenide.open(BASE_LMS_URL + endPoint, LoginPage.class); // сразу открой нужную страницу
        loginPage.doLogin(getCredentialConfig().username(), getCredentialConfig().password());
        return Selenide.page(clazz);
    }


    @Step("Open the {1}")
    public <T> T open(String endPoint, Class<T> clazz) {

        try {
            // Логинимся
            Selenide.open(BASE_DemoQA_URL, MainPage.class)
                    .waitForPageLoaded();
            // Формируем полный URL
            String fullUrl = BASE_DemoQA_URL.endsWith("/") || endPoint.startsWith("/")
                    ? BASE_DemoQA_URL + endPoint.replaceFirst("^/", "")
                    : BASE_DemoQA_URL + "/" + endPoint;
            // Открываем нужную страницу и возвращаем объект нужного PageObject
            return Selenide.open(fullUrl, clazz);

        } catch (Exception e) {
            throw new RuntimeException("Page opening failed: " + endPoint, e);
        }
    }


    @BeforeAll
    void beforeAll() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true)
                        .savePageSource(true)
        );
    }

    @AfterEach
    void afterEach() {
        Selenide.clearBrowserLocalStorage();
    }

    @AfterAll
    void afterAll() {
        Selenide.closeWebDriver();
        SelenideLogger.removeListener("AllureSelenide");
    }
}
