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
import pages.LoginPage;
import utils.BaseTest;

public class LoginSteps {

    private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);
    private LoginPage loginPage;

    public LoginSteps() {
        this.loginPage = new LoginPage(BaseTest.getDriver());
    }


    @Test
    @Description("Kullanici giris ekranina gidip, username alaninin erisilebilir olup olmadıgını kontrol eder.")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Kullanici giris ekranina gider ve Login sayfasinin açıldıgı görülür")
    public void navigateToLoginAndCheckField()  {
        Allure.step("Kullanici giris ekranina gider ve Login sayfasinin açıldıgı görülür");
        boolean isFieldAvailable = loginPage.isUserNameFieldVisibleAndEnabled();
        Assertions.assertTrue(isFieldAvailable, "Kullanıcı adı alanı görünmüyor veya devre dışı!");


    }

    @Description("Username ve şifre alanlarının girilebilir olduğu kontrolü.")
    @Step("Kullanıcı e-posta olarak <email> ve şifre olarak <password> girer.")
    @Severity(SeverityLevel.CRITICAL)
    public void enterCredentials(String email, String password) throws InterruptedException {
        Allure.step("Kullanıcı username ve şifre alanlarını doldurur.");
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);

    }
    @Test
    @Description("Kullanıcı login butonuna tıklanması kontrolü yapılır.")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Kullanıcı giriş butonuna tıklar")
    public void clickLoginButton() {
        Allure.step("Kullanıcı login butonuna tıklar.");
        loginPage.clickLogin();
    }

    @Test
    @Description("Başarılı login olunması kontrolü yapılır.")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Başarılı login sonrası Open Money butonun geldiği görülür.")
    public void controlLoginButtonWithOpenMoney() throws InterruptedException {
        Allure.step("Başarılı login sonrası Open Money butonun geldiği görülür.");
        loginPage.isOpenMoneyButtonVisibleAndEnabled();

    }

    @Test
    @Description("Yanlış username ve şifre ile giriş yapılarak login kontrol yapılır.")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Başarısız login sonrası hata mesajının geldiği görülür.")
    public void failLoginControl(){
        Allure.step("Başarısız login sonrası hata mesajının geldiği görülür.");
        Assertions.assertFalse(loginPage.isFailLoginExceptionVisibleAndEnabled(),
                "Başarısız login sonrası hata mesajının gelmesi bekleniyordu.");

    }

    @Test
    @Step("Open Money butonuna tıklanır.")
    public void clickOpenMoneyButton() throws InterruptedException {
        loginPage.isOpenMoneyButtonVisibleAndEnabled();
        loginPage.clickOpenMoney();

    }


}
