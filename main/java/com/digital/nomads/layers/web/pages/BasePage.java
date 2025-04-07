package com.digital.nomads.layers.web.pages;


import com.digital.nomads.layers.web.components.SidebarComponent;
import com.digital.nomads.layers.web.manager.ElementManager;
import net.datafaker.Faker;

public abstract class BasePage<T extends BasePage> {
    public Faker faker = new Faker();

    protected final ElementManager elementManager = new ElementManager();

    public abstract T waitForPageLoaded();

    public final SidebarComponent sidebar = new SidebarComponent();
}