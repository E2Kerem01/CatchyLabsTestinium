package org.example.stepDefinitions;

import com.thoughtworks.gauge.Step;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.EditAccountPage;
import pages.LoginPage;
import utils.BaseTest;

public class EditAccountSteps {
    private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);

    private EditAccountPage editAccountPage;
    public EditAccountSteps() {
        this.editAccountPage = new EditAccountPage(BaseTest.getDriver());
    }


    @Test
    @Description("Kullanici giris ekranina gidip, username alaninin erisilebilir olup olmadıgını kontrol eder.")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Kullanici giris ekranina gider ve Hesap sayfasının açıldığını görür.")
    public void isMyAccountVisibleAndEnable() throws InterruptedException {

        Allure.step("Kullanici giris ekranina gider ve Hesap sayfasının açıldığını görür.");
        boolean isFieldAvailable = editAccountPage.isMyAccountVisibleAndEnable();
        Assertions.assertFalse(isFieldAvailable, "Login Sonrası Hesap Sayfası Açılmıyor!");


    }
}
