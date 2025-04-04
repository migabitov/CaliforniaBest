package com.digital.nomads.layers.web.components;

import com.codeborne.selenide.SelenideElement;
import com.digital.nomads.layers.web.manager.ElementManager;

import javax.annotation.Nonnull;

public class BaseComponent<T extends BaseComponent> {

    protected final SelenideElement self;
    protected final ElementManager elementManager = new ElementManager();

    public BaseComponent(@Nonnull SelenideElement self) {
        this.self = self;
    }

    @Nonnull
    public SelenideElement getSelf() {
        return self;
    }
}
