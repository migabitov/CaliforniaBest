package com.digital.nomads.layers.web.pages.demoqa;

import com.codeborne.selenide.SelenideElement;
import com.digital.nomads.layers.web.pages.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends BasePage<MainPage> {

    public SelenideElement elements = $x("//h5[text()='Elements']");

    @Override
    public MainPage waitForPageLoaded() {
        elements.shouldBe(visible);
        return this;
    }
}
