package com.digital.nomads.tests.web.talentlms;

import com.digital.nomads.layers.web.pages.talentLMS.AdminDashboardPage;
import com.digital.nomads.tests.web.BaseWebTest;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseWebTest {

    @Test
    public void loginWithValidCredsTest(){

        openTalentLMSLoginPage("", AdminDashboardPage.class).waitForPageLoaded();


    }
}
