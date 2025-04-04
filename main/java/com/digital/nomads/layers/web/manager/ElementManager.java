package com.digital.nomads.layers.web.manager;

import com.codeborne.selenide.*;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static org.openqa.selenium.Keys.ENTER;

@Slf4j
public class ElementManager {

    private final int DELAY = 30;

    public SelenideElement shouldHaveText(SelenideElement element, String text) {
        element.shouldHave(text(text), Duration.ofSeconds(DELAY));
        return element;
    }

    public ElementManager clickWithScrolling(SelenideElement element) {
        element.shouldBe(visible, Duration.ofSeconds(10));
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(element)
                .click()
                .perform();
        return this;
    }

    public ElementManager click(SelenideElement element) {
        element
                .shouldBe(interactable, Duration.ofSeconds(DELAY))
                .shouldBe(Condition.visible);
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            log.error("Первый клик не удался, пробуем через JavaScript");
            Selenide.executeJavaScript("arguments[0].click();", element);
        }
        return this;
    }

    public boolean isElementVisible(SelenideElement element, int timeoutInSeconds) {
        return isElementMatchCondition(element, timeoutInSeconds);
    }

    private boolean isElementMatchCondition(SelenideElement element, int timeoutInSeconds) {
        try {
            element.shouldBe(disappear, Duration.ofSeconds(timeoutInSeconds));
            return true;
        } catch (AssertionError e) {
            return false;
        }
    }

    public ElementManager click(SelenideElement element, int timeoutInSeconds) {
        element.shouldBe(interactable, Duration.ofSeconds(timeoutInSeconds)).click();
        return this;
    }

    public ElementManager shouldVisible(SelenideElement element) {
        element
                .should(appear)
                .hover()
                .should(visible);
        return this;
    }

    public ElementManager shouldBe(SelenideElement element, WebElementCondition condition) {
        element.shouldBe(condition, Duration.ofSeconds(DELAY));
        return this;
    }

    public ElementManager uploadFile(SelenideElement element, File file) {
        element
                .uploadFile(file);
        return this;
    }

    public ElementManager shouldHave(SelenideElement element, WebElementCondition condition) {
        element.shouldHave(condition, Duration.ofSeconds(DELAY));
        return this;
    }

    public void visible(SelenideElement element) {
        try {
            element.should(appear).hover().should(visible, Duration.ofSeconds(DELAY));
        } catch (Exception e) {
            throw new RuntimeException("Element is not appeared in HTML or on the page " + element + "\n" + " " + e.getMessage());
        }
    }

    public ElementManager click(SelenideElement element, ClickOptions options) {
        visible(element);
        element.click(options);
        return this;
    }

    public ElementManager clickJS(SelenideElement element) {
        Selenide.executeJavaScript("arguments[0].click();", element.shouldBe(interactable));
        return this;
    }

    public ElementManager hover(SelenideElement element) {
        visible(element);
        element.hover();
        return this;
    }

    public ElementManager input(SelenideElement element, String text) {
        element
                .shouldBe(interactable, Duration.ofSeconds(DELAY))
                .scrollTo()
                .sendKeys(text);
        return this;
    }

    public ElementManager inputWithClearToNotVisibleElement(SelenideElement element, String text) {
        visible(element);
        element.clear();
        element.sendKeys(text);
        return this;
    }

    public ElementManager inputWithEnter(SelenideElement element, String text) {
        element.sendKeys(text, ENTER);
        return this;
    }

    public ElementManager enter(SelenideElement element) {
        visible(element);
        element.sendKeys(ENTER);
        return this;
    }

    public String getText(SelenideElement element) {
        element
                .shouldBe(visible, Duration.ofSeconds(15))
                .shouldNotBe(empty, Duration.ofSeconds(15));
        return element.getText();
    }

    public List<String> getTexts(SelenideElement element, String path) {
        element
                .shouldBe(visible, Duration.ofSeconds(5))
                .shouldNotBe(empty, Duration.ofSeconds(5));
        return element.findAll(path).texts();
    }

    public String getValue(SelenideElement element) {
        element
                .shouldBe(visible, Duration.ofSeconds(5))
                .shouldNotBe(empty, Duration.ofSeconds(5));
        return element.getValue();
    }

    public String getAttribute(SelenideElement element, String attribute) {
        element
                .shouldBe(visible, Duration.ofSeconds(5))
                .shouldNotBe(empty, Duration.ofSeconds(5));
        return element.getAttribute(attribute);
    }

    public String getInnerText(SelenideElement element) {
        return element.shouldBe(visible).innerText();
    }

    public ElementManager selectOption(SelenideElement element, String text) {
        element
                .shouldBe(interactable, Duration.ofSeconds(DELAY))
                .shouldHave(Condition.not(empty), Duration.ofSeconds(DELAY))
                .scrollTo()
                .shouldBe(Condition.visible)
                .selectOption(text);
        return this;
    }

    public ElementManager selectOptionContainingText(SelenideElement element, String text) {
        element.shouldBe(visible).scrollTo().selectOptionContainingText(text);
        return this;
    }

    public ElementManager selectOptions(SelenideElement element, List<String> texts) {
        element.shouldBe(visible).scrollTo().selectOption(texts.toString());
        return this;
    }

    public ElementManager selectOption(SelenideElement element, int i) {
        element.shouldBe(visible).scrollTo().selectOption(i);
        return this;
    }

    public SelenideElement getSelectedOption(SelenideElement element) {
        return element.shouldBe(visible).scrollTo().getSelectedOption();
    }

    public ElementsCollection getSelectedOptions(SelenideElement element) {
        return element.shouldBe(visible).scrollTo().getSelectedOptions();
    }

    public ElementManager pressTab(SelenideElement element) {
        element.shouldBe(visible).pressTab();
        return this;
    }
    public ElementManager scrollToElement(SelenideElement element) {
        element.scrollIntoView(true).shouldBe(visible);
        return this;
    }

    public ElementManager selectByValue(SelenideElement element, String value) {
        element.scrollTo().selectOptionByValue(value);
        return this;
    }

    public ElementManager selectByVisibleText(SelenideElement element, String txt) {
        element.selectOptionContainingText(txt);
        return this;
    }

    public ElementManager clear(SelenideElement element) {
        visible(element);
        element.clear();
        return this;
    }

    public boolean isElementShouldBeVisible(SelenideElement element) {
        try {
            element.shouldBe(visible, Duration.ofSeconds(DELAY));
            return element.isDisplayed();
        } catch (AssertionError e) {
            log.error("Element {} should be visible in {} sec", element, DELAY);
            return false;
        }
    }

    public boolean isElementShouldBeVisible(SelenideElement element, int delay) {
        try {
            element.shouldBe(visible, Duration.ofSeconds(delay));
            return element.isDisplayed();
        } catch (AssertionError e) {
            log.error("Element {} should be visible in {} sec", element, delay);
            return false;
        }
    }


    public ElementManager highlightElement(SelenideElement element) {
        visible(element);
        String originalStyle = element.getAttribute("style");

        // Apply a temporary style to highlight the element
        String highlightStyle = "border: 2px solid red; background-color: yellow;";
        String script = "arguments[0].setAttribute('style', arguments[1]);";
        Selenide.executeJavaScript(script, element, highlightStyle);
        Selenide.sleep(1000);
        // Restore the original style after clicking
        Selenide.executeJavaScript(script, element, originalStyle);
        return this;
    }

    public String getPropertyValue(SelenideElement element, String propertyValue) {
        element.hover().shouldBe(visible);
        return element.getDomProperty(propertyValue);
    }
}
