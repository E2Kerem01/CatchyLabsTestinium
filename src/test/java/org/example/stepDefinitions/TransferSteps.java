package org.example.stepDefinitions;

import com.thoughtworks.gauge.Step;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import pages.TransferPage;
import utils.BaseTest;

public class TransferSteps {

    private TransferPage transferPage;

    public TransferSteps() {
        this.transferPage = new TransferPage(BaseTest.getDriver());
    }

    @Test
    @Description
    @Severity(SeverityLevel.CRITICAL)
    @Step("Kullanıcı Hesap sayfasının açıldığı görülür.")
    public void isMyTransferPanelOk() throws InterruptedException {

        transferPage.clickTransfer();
        transferPage.isTransferMoneyPanelVisibleAndEnabled();

    }


    @Description
    @Severity(SeverityLevel.CRITICAL)
    @Step("<> Tl tutarı girilerek para transferi yapılır.")
    public void correctTransferMoneyOK(String money) throws InterruptedException {
        transferPage.correctTransferMoney(money);
    }

    @Test
    @Description
    @Severity(SeverityLevel.CRITICAL)
    @Step("Kullanıcı Hesap sayfasında başka bir kullanıcı seçilir.")
    public void changeReceiver() throws InterruptedException {
        transferPage.chooseNewReceiver();


    }

}
