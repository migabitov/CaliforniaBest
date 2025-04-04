package com.digital.nomads.layers.web.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.digital.nomads.enums.sidebar.MainMenu;
import com.digital.nomads.enums.sidebar.ReportsSubMenu;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import javax.annotation.Nonnull;

import static com.codeborne.selenide.Selenide.$;

public class LeftMenuComponent  extends BaseComponent<LeftMenuComponent>{

    public LeftMenuComponent() {
        super($(".main-menu"));
    }

    @Step("Click to '{menu}' → '{subMenu}' on sidebar")
    public LeftMenuComponent clickToMenuAndSubMenu(MainMenu menu, ReportsSubMenu subMenu) {
        // 1. Находим пункт главного меню
        SelenideElement selectedMenu = getSelf()
                .findAll(By.xpath(".//li[contains(@class, 'nav-item')]"))
                .filterBy(Condition.text(menu.getName()))
                .first();

        // 2. Кликаем по нему, если подменю ещё не видно
        if (!selectedMenu.find(By.xpath(".//div[contains(@class, 'element-list')]")).isDisplayed()) {
            elementManager.click(selectedMenu);
        }

        // 3. Ждём, пока появится подменю
        selectedMenu.find(By.xpath(".//div[contains(@class, 'element-list')]"))
                .shouldBe(Condition.visible);

        // 4. Находим и кликаем по подменю
        SelenideElement subMenuItem = selectedMenu
                .findAll(By.xpath(".//span[contains(@class, 'text')]"))
                .filterBy(Condition.exactText(subMenu.getName()))
                .first();

        elementManager.click(subMenuItem);

        return this;
    }

}
