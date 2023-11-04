package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//h1[text()='Welcome to the Simple Travel Agency!']")
    WebElement verifyTitle;

    @FindBy(xpath = "//a[text()='destination of the week! The Beach!']")
    WebElement destinationLink;



    public HomePage(WebDriver rDriver) {
        driver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

    public WebElement GetTileOfBlaze() {
        return verifyTitle;
    }


    public void ClickOnDestination() {
        destinationLink.click();
    }


}
