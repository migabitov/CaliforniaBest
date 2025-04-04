package com.digital.nomads.tests.web.talentlms;

import com.codeborne.selenide.Condition;
import com.digital.nomads.enums.sidebar.MainMenu;
import com.digital.nomads.enums.sidebar.ReportsSubMenu;
import com.digital.nomads.layers.web.components.LeftMenuComponent;
import com.digital.nomads.layers.web.pages.talentLMS.AdminDashboardPage;
import com.digital.nomads.layers.web.pages.talentLMS.LoginPage;
import com.digital.nomads.tests.web.BaseWebTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class TalentLmsLeftMenu extends BaseWebTest  {


    @Test
    @DisplayName("Переход к 'Reports → Learning activities' через универсальный метод")
    void shouldNavigateToSubMenuByTextNames() {
        AdminDashboardPage dashboard = openTalentLMSLoginPage("/plus/dashboard", AdminDashboardPage.class);
        dashboard.waitForPageLoaded();

        LeftMenuComponent leftMenu = dashboard.getLeftMenu();
        leftMenu.clickToMenuAndSubMenu(MainMenu.REPORTS, ReportsSubMenu.USERS);

        $("h1").shouldHave(Condition.text("Learning activities"));

    }


}
