package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static utils.CommonActions.selectDropDownValue;

public class FlightFindPage {

    WebDriver driver;

    @FindBy(xpath = "//select[@name='fromPort']")
    WebElement DepartmentDropdown;

    @FindBy(xpath = "//select[@name='toPort']")
    WebElement destinationDropdown;

    @FindBy(xpath = "//input[@value='Find Flights']")
    WebElement ClickFlight;



    public FlightFindPage(WebDriver rDriver) {
        driver = rDriver;
        PageFactory.initElements(rDriver, this);
    }


    public void HandleDepartDropdown() {
        selectDropDownValue(DepartmentDropdown, "value", "Mexico City");
    }

    public void HandleDestiDropdown() {
        selectDropDownValue(destinationDropdown, "value", "London");
    }

    public void ClickOnFlight() {
        ClickFlight.click();
    }

}
