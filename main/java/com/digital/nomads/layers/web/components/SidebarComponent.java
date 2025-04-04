package com.digital.nomads.layers.web.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.digital.nomads.enums.sidebar.MainMenu;
import com.digital.nomads.enums.sidebar.MainSidebarMenu;
import com.digital.nomads.enums.sidebar.ReportsSubMenu;
import com.digital.nomads.enums.sidebar.SubMenu;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SidebarComponent extends BaseComponent<SidebarComponent>{

    public SidebarComponent() {
        super($(".left-pannel"));
    }

    @Step("Click to '{menu}' → '{subMenu}' on sidebar")
    public SidebarComponent clickToMenuAndSubmenu(MainSidebarMenu menu, SubMenu subMenu) {
        // 1. Находим пункт главного меню
        SelenideElement selectedMenu = getSelf()
                .findAll(By.xpath(".//div[contains(@class, 'header-text')]"))
                .filterBy(Condition.text(menu.getName()))
                .first()
                .closest("div[contains(@class, 'element-group')]");

        // 2. Кликаем, если элемент не раскрыт
        if (!selectedMenu.find(By.xpath(".//div[contains(@class, 'element-list')]")).isDisplayed()) {
            elementManager.click(selectedMenu);
        }

        // 3. Ожидаем появление подменю
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
