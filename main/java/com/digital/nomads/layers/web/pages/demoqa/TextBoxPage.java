package com.digital.nomads.layers.web.pages.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.digital.nomads.layers.web.pages.BasePage;
import lombok.Getter;
import net.datafaker.Faker;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TextBoxPage extends BasePage<TextBoxPage> {

    @Getter
    private SelenideElement name = $(By.id("name"));
    @Getter
    private SelenideElement email = $(By.id("email"));


    SelenideElement userName = $(By.id("userName"));
    SelenideElement userEmail = $(By.id("userEmail"));
    SelenideElement currentAddress = $(By.id("currentAddress"));
    SelenideElement permanentAddress = $(By.id("permanentAddress"));
    SelenideElement submit = $(By.id("submit"));


    public TextBoxPage fillUpTheForm (){
        elementManager.input(userName, faker.name().femaleFirstName())
                .input(userEmail, faker.internet().emailAddress())
                .input(currentAddress, faker.address().fullAddress())
                .input(permanentAddress, faker.address().fullAddress()).click(submit);
        return this;
    }



    @Override
    public TextBoxPage waitForPageLoaded() {
         $(By.tagName("h1")).shouldHave(Condition.exactText("Text Box"));
         return this;
    }
}
