package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseConfirmationPage {
    WebDriver driver;

    @FindBy(xpath = "//table/tbody/tr[1]/td[2]")
    WebElement purchaseIdElement;


    public PurchaseConfirmationPage(WebDriver rDriver) {
        driver = rDriver;
        PageFactory.initElements(rDriver, this);
    }


    public WebElement purchaseId() {
        return purchaseIdElement;
    }
}
