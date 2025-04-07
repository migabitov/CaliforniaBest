package com.digital.nomads.layers.web.pages.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.digital.nomads.layers.web.pages.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PracticeForm extends BasePage<PracticeForm> {

    SelenideElement firstName = $(By.id("firstName"));
    SelenideElement lastName = $(By.id("lastName"));
    SelenideElement userNumber = $(By.id("userNumber"));

    public PracticeForm fillUpThePracticeForm(){
        elementManager.input(firstName, faker.name().femaleFirstName())
                .input(lastName, faker.name().femaleFirstName())
                .input(userNumber, faker.number().digits(10));
        return this;
    }



    @Override
    public PracticeForm waitForPageLoaded() {
        $(By.tagName("h1")).shouldHave(Condition.exactText("Practice Form"));
        return this;
    }



}
