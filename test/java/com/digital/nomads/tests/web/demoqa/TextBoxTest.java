package com.digital.nomads.tests.web.demoqa;

import com.digital.nomads.asserts.UiAsserts;
import com.digital.nomads.layers.web.pages.demoqa.TextBoxPage;
import com.digital.nomads.tests.web.BaseWebTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TextBoxTest extends BaseWebTest {

    @Test
    @Tag("Smoke")
    public void test(){

        var textBoxPage = open("text-box", TextBoxPage.class).waitForPageLoaded().fillUpTheForm();

        UiAsserts.assertThat(textBoxPage.getName()).isTextContains("Name");

    }

    @Test
    @Tag("Smoke")
    public void test1(){

        var textBoxPage = open("text-box", TextBoxPage.class).waitForPageLoaded().fillUpTheForm();

        UiAsserts.assertThat(textBoxPage.getName()).isTextContains("Name");


    }
}
