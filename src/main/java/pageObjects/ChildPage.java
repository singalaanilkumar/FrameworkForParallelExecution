package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChildPage {
    WebDriver driver;

    @FindBy(linkText = "Travel The World")
    WebElement navigate;


    public ChildPage(WebDriver rDriver) {
        driver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

    public void NavigateBack() {
        navigate.click();
    }
}
