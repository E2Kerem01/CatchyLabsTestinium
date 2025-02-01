package org.example.stepDefinitions;

import com.thoughtworks.gauge.Step;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AddMoneyPage;
import pages.LoginPage;
import utils.BaseTest;

public class AddMoneySteps {
    private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);
    private AddMoneyPage addMoneyPage;

    public AddMoneySteps() {
        this.addMoneyPage = new AddMoneyPage(BaseTest.getDriver());
    }

    @Step("Para Ekleme Kısmından <> tutarında ekleme yapılır.")
    public void addMoneyToAccount(String money) throws InterruptedException {
        addMoneyPage.AddMoneyPageButton();
        addMoneyPage.checkAddMoneyArea();
        addMoneyPage.clickAddMoneyButton();
        addMoneyPage.checkRequiredFieldMessage();

        addMoneyPage.addMoneyToAccount(money);


        Thread.sleep(1000000);
    }


}
