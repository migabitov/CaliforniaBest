package com.digital.nomads.layers.web.pages.talentLMS;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.digital.nomads.layers.web.components.LeftMenuComponent;
import com.digital.nomads.layers.web.pages.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class AdminDashboardPage extends BasePage<AdminDashboardPage> {

    public SelenideElement homeTxt = $x("//div[text() = 'Home']");

    @Override
    public AdminDashboardPage waitForPageLoaded() {
        $x("//div[@class='title' and contains(text(), 'Home')]")
                .shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }

    public LeftMenuComponent getLeftMenu() {
        return new LeftMenuComponent();
    }
}
