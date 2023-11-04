package testCases;


import BrowserFactory.DriverFactory;
import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;


public class BlazeDemoAutomation {
    Logger log = Logger.getLogger(BlazeDemoAutomation.class);
    DriverFactory df;



   /* @BeforeTest
    public void lauchBrowserAndNavigateUrl() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://blazedemo.com/index.php");
    }*/



    @Test(priority = 1)
    public void lauchBrowserAndNavigateUrl() throws IOException {
        df = new DriverFactory();
        df.init_driver("chrome");
        DriverFactory.getDriver().get("https://blazedemo.com/index.php");
    }


    @Test(priority = 2)
    public void ValidateTitleHome() {
        HomePage hp = new HomePage(DriverFactory.getDriver());

        // Check if the title is displayed as "Welcome to the Simple Travel Agency!"
        String expectedTitle = "Welcome to the Simple Travel Agency!";
        String actualTitle = hp.GetTileOfBlaze().getText();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification passed.");
        } else {
            System.out.println("Title verification failed.");
        }
        hp.ClickOnDestination();

    }

    @Test(priority = 3)
    public void ClickHyperLinkAndNavigateBack() {
        ChildPage cp = new ChildPage(DriverFactory.getDriver());
        /** Verify if the URL contains "vacation" */
        String currentUrl = DriverFactory.getDriver().getCurrentUrl();
        if (currentUrl.contains("vacation")) {
            System.out.println("URL verification passed.");
        } else {
            System.out.println("URL verification failed.");
        }
        cp.NavigateBack();
    }

    @Test(priority = 4)
    public void SelectDropDownAndFlight() {
        FlightFindPage Fp = new FlightFindPage(DriverFactory.getDriver());
        Fp.HandleDepartDropdown();
        Fp.HandleDestiDropdown();
        Fp.ClickOnFlight();
    }

    @Test(priority = 5)
    public void ClickLowestPriceFlight() {
        LowestFlightPrice Lp = new LowestFlightPrice(DriverFactory.getDriver());
        Lp.FindingLessPriceFlight();
    }

    @Test(priority = 6)
    public void PurchaseFlight() {
        SubmitFormOfFlight Sf = new SubmitFormOfFlight(DriverFactory.getDriver());
        Sf.ValidateTotalCostField();
        Sf.FillFlightForm();
    }

    @Test(priority = 7)
    public void ValidatePurchaseID() {
        PurchaseConfirmationPage pc = new PurchaseConfirmationPage(DriverFactory.getDriver());
        String purchaseId = pc.purchaseId().getText();
        Reporter.log("Purchase ID is: " + purchaseId, true);
    }


    @Test(priority = 8)
    public void Quitbrowser() {
        DriverFactory.getDriver().quit();
    }
}
