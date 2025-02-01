package stepDefinitions;

import com.thoughtworks.gauge.Step;
import pages.LoginPage;
import utils.BaseTest;

public class LoginSteps {

    private LoginPage loginPage = new LoginPage(BaseTest.driver);

    @Step("Kullanıcı giriş ekranına gider")
    public void navigateToLogin() {
        BaseTest.setUp();
    }

    @Step("Kullanıcı e-posta olarak <email> ve şifre olarak <password> girer")
    public void enterCredentials(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @Step("Kullanıcı giriş butonuna tıklar")
    public void clickLoginButton() {
        loginPage.clickLogin();
    }
}
