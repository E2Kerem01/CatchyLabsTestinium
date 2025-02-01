package org.example.stepDefinitions;

import com.thoughtworks.gauge.Step;
import pages.TransferPage;
import utils.BaseTest;

public class TransferSteps {

    private TransferPage transferPage = new TransferPage(BaseTest.driver);

    @Step("Kullanıcı para transfer ekranına gider")
    public void goToTransferScreen() {
        BaseTest.setUp();
    }

    @Step("Kullanıcı <source> hesabından <destination> hesabına <amount> TL transfer eder")
    public void transferMoney(String source, String destination, String amount) {
        transferPage.selectSourceAccount(source);
        transferPage.selectDestinationAccount(destination);
        transferPage.enterAmount(amount);
        transferPage.clickTransfer();
    }
}
