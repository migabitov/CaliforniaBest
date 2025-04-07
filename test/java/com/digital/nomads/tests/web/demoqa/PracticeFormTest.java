package com.digital.nomads.tests.web.demoqa;

import com.digital.nomads.asserts.UiAsserts;
import com.digital.nomads.layers.web.pages.demoqa.PracticeForm;
import com.digital.nomads.layers.web.pages.demoqa.TextBoxPage;
import com.digital.nomads.tests.web.BaseWebTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class PracticeFormTest extends BaseWebTest {

    @Test
    @Tag("Smoke")
    public void test(){

        var practiceForm = open("automation-practice-form", PracticeForm.class).waitForPageLoaded().fillUpThePracticeForm();

    }
    @Test
    @Tag("Smoke")
    public void test1(){

        var practiceForm = open("automation-practice-form", PracticeForm.class).waitForPageLoaded().fillUpThePracticeForm();

    }
}
