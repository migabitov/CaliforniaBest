package com.digital.nomads.asserts;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class UiAsserts {
    private final SelenideElement element;
    private final ElementsCollection elements;

    private UiAsserts(SelenideElement element, ElementsCollection elements) {
        this.element = element;
        this.elements = elements;
    }

    public UiAsserts(SelenideElement element) {
        this(element, null);
    }

    public UiAsserts(ElementsCollection elements) {
        this(null, elements);
    }

    public static UiAsserts assertThat(SelenideElement element) {
        element.describe();
        return new UiAsserts(element);
    }

    public static UiAsserts assertThat(ElementsCollection elements) {
        return new UiAsserts(elements);
    }

    public UiAsserts isTextCorrect(String expectedText) {
        log.info("🔍 Checking that element has exact text: '{}'", expectedText);
        element.shouldHave(Condition.exactText(expectedText)
                .because("Expected text to be '%s', but was '%s'"
                        .formatted(expectedText, element.getText())));
        return this;
    }

    public UiAsserts isValueCorrect(String expectedValue) {
        log.info("🔍 Checking that element has value: '{}'", expectedValue);
        element.shouldHave(Condition.value(expectedValue)
                .because("Expected value to be '%s', but was '%s'"
                        .formatted(expectedValue, element.getValue())));
        return this;
    }

    public UiAsserts isSizeCorrect(int expectedSize) {
        log.info("🔍 Checking that collection has size: {}", expectedSize);
        elements.shouldHave(CollectionCondition.size(expectedSize)
                .because("Expected collection size: %d, but was: %d"
                        .formatted(expectedSize, elements.size())));
        return this;
    }

    public UiAsserts isTextContains(String expectedText) {
        log.info("🔍 Checking that element contains text: '{}'", expectedText);
        element.shouldHave(Condition.text(expectedText)
                .because("Expected element to contain text '%s', but was '%s'"
                        .formatted(expectedText, element.getText())));
        return this;
    }

    public UiAsserts isTextContains(List<String> expectedTexts) {
        log.info("🔍 Checking that collection contains texts: {}", expectedTexts);
        elements.shouldHave(CollectionCondition.containExactTextsCaseSensitive(expectedTexts)
                .because(" Expected collection to contain exact texts: %s".formatted(expectedTexts)));
        return this;
    }

}
