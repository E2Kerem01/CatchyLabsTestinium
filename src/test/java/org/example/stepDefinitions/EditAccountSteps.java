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

import utils.BaseTest;

public class EditAccountSteps {
    private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);

    private EditAccountPage editAccountPage;
    public EditAccountSteps() {
        this.editAccountPage = new EditAccountPage(BaseTest.getDriver()); // **Her testte güncel driver**
    }


    @Test
    @Description("Kullanici giris ekranina gidip, username alaninin erisilebilir olup olmadıgını kontrol eder.")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Kullanici giris ekranina gider ve Hesap sayfasının açıldığını görür.")
    public void isMyAccountVisibleAndEnable() throws InterruptedException {

        Allure.step("Kullanici giris ekranina gider ve Hesap sayfasının açıldığını görülür.");
        boolean isFieldAvailable = editAccountPage.isMyAccountVisibleAndEnable();
        Assertions.assertTrue(isFieldAvailable);

    }


    @Description("Doğru Karakterlele hesap ismi değişikliği yapılır.")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Kullanıcı hesap ismi olarak <username> girer.")
    public void changeAccountNameCorrectly(String username) throws InterruptedException {

        boolean isFieldAvailable = editAccountPage.isVisiblaAndEnableEditAccountButton();
        Assertions.assertTrue(isFieldAvailable);
        editAccountPage.getOldUsername();
        editAccountPage.clickEditMyAccountButton();
        boolean isFieldAvailable2 = editAccountPage.isVisiblaAndEnableEditAccountInputField();
        Assertions.assertTrue(isFieldAvailable2);
        editAccountPage.clickEditAccountNameField();
        editAccountPage.enterNewAccountName(username);
        editAccountPage.clickUpdateButton();
        boolean isUpdated = editAccountPage.isUsernameUpdated(username);
        Assertions.assertFalse(isUpdated, "Kullanıcı adı değişmedi!");
        Allure.step("Kullanıcı adı başarıyla değiştirildi: " + username);


    }

    @Description("Sayısal Karakterlele hesap ismi değişikliği yapılmaya çalışılır.")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Geçersiz Kullanıcı hesap ismi olarak <username> girer.")
    public void changeAccountNameNumber(String username) throws InterruptedException {

        boolean isFieldAvailable = editAccountPage.isVisiblaAndEnableEditAccountButton();
        Assertions.assertTrue(isFieldAvailable);
        editAccountPage.clickEditMyAccountButton();
        boolean isFieldAvailable2 = editAccountPage.isVisiblaAndEnableEditAccountInputField();
        Assertions.assertTrue(isFieldAvailable2);
        editAccountPage.clickEditAccountNameField();
        editAccountPage.enterNewAccountName(username);
        editAccountPage.clickUpdateButton();
        boolean isAccountPageStillOpen = editAccountPage.isMyAccountVisibleAndEnable();
        Assertions.assertFalse(isAccountPageStillOpen);


    }

    @Description("Yanlış Karakterlele hesap ismi değişikliği yapılmaya çalışılır.")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Geçersiz karaterlerle Kullanıcı hesap ismi olarak <username> girer.")
    public void changeAccountNameCharacter(String username) throws InterruptedException {

        boolean isFieldAvailable = editAccountPage.isVisiblaAndEnableEditAccountButton();
        Assertions.assertTrue(isFieldAvailable);
        editAccountPage.clickEditMyAccountButton();
        boolean isFieldAvailable2 = editAccountPage.isVisiblaAndEnableEditAccountInputField();
        Assertions.assertTrue(isFieldAvailable2);
        editAccountPage.clickEditAccountNameField();
        editAccountPage.enterNewAccountName(username);
        editAccountPage.clickUpdateButton();
        boolean isAccountPageStillOpen = editAccountPage.isMyAccountVisibleAndEnable();
        Assertions.assertFalse(isAccountPageStillOpen);


    }
}
