package org.example.stepDefinitions;

import com.thoughtworks.gauge.Step;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import utils.BaseTest;

public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps() {
        this.loginPage = new LoginPage(BaseTest.getDriver());
    }

    @Test
    @Description("Kullanici giris ekranina gidip, username alaninin erisilebilir olup olmadıgını kontrol eder.")
    @Step("Kullanici giris ekranina gider ve Login sayfasinin açıldıgı görülür")
    public void navigateToLoginAndCheckField()  {

        boolean isFieldAvailable = loginPage.isUserNameFieldVisibleAndEnabled();
        Assertions.assertTrue(isFieldAvailable, "Kullanıcı adı alanı görünmüyor veya devre dışı!");


    }

    @Step("Kullanıcı e-posta olarak <email> ve şifre olarak <password> girer")
    public void enterCredentials(String email, String password) throws InterruptedException {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);

    }

    @Step("Kullanıcı giriş butonuna tıklar")
    public void clickLoginButton() {
        loginPage.clickLogin();
    }
}
