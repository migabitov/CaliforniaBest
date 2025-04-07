package com.digital.nomads.layers.web.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.digital.nomads.enums.sidebar.MainMenu;
import com.digital.nomads.enums.sidebar.ReportsSubMenu;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import javax.annotation.Nonnull;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LeftMenuComponent  extends BaseComponent<LeftMenuComponent>{

    public LeftMenuComponent() {
        super($(".main-menu"));
    }

    @Step("Click to '{menu}' → '{subMenu}' on sidebar")
    public LeftMenuComponent clickToMenuAndSubMenu(MainMenu menu, ReportsSubMenu subMenu) {
        // 1. Находим пункт главного меню (li.nav-item) по тексту
        SelenideElement selectedMenu = getSelf()
                .findAll(By.xpath(".//li[contains(@class, 'nav-item')]"))
                .filterBy(Condition.text(menu.getName()))
                .first();

        // 2. Наводим курсор мыши, чтобы появилось подменю
        selectedMenu.hover();

        // 3. Ждём появления сабменю-контейнера (div.sub-menu)
        SelenideElement subMenuContainer = $x("//div[@class='sub-menu']").shouldBe(Condition.visible, Duration.ofSeconds(5));

        // 4. Ищем и кликаем по сабменю по точному тексту
        SelenideElement subMenuItem = subMenuContainer
                .findAll(By.xpath(".//div[contains(@class, 'text')]"))
                .filterBy(Condition.exactText(subMenu.getName()))
                .first()
                .shouldBe(Condition.visible, Duration.ofSeconds(5));

        elementManager.click(subMenuItem);

        return this;
    }

}
