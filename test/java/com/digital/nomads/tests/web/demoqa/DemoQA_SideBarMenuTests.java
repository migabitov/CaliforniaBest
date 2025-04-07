package com.digital.nomads.tests.web.demoqa;

import com.digital.nomads.enums.sidebar.MainSidebarMenu;
import com.digital.nomads.enums.sidebar.SubMenu;
import com.digital.nomads.layers.web.components.SidebarComponent;
import com.digital.nomads.layers.web.pages.demoqa.MainPage;
import com.digital.nomads.tests.web.BaseWebTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DemoQA_SideBarMenuTests extends BaseWebTest {

    @Test
    @Tag("Smoke")
    void testMainDemoQA() {

        open("elements", MainPage.class).waitForPageLoaded();
        new SidebarComponent()
                .clickToMenuAndSubmenu(MainSidebarMenu.FORMS, SubMenu.PRACTICE_FORM);
    }
}
