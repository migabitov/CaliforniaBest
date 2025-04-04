package com.digital.nomads.layers.web.components;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Form extends BaseComponent<Form> {

    private SelenideElement form;

    public Form(SelenideElement self) {
        super(self);
    }
}


