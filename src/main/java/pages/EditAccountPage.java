package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditAccountPage extends BasePage {

    private By myAccountPage = By.xpath("//div[normalize-space()='My account']");
    private By openMoneyButton = By.xpath("//div[@class='css-146c3p1 r-jwli3a r-1b43r93']");

    public EditAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMyAccountVisibleAndEnable(){
        return isElementVisibleAndEnabled(myAccountPage);
    }
}
