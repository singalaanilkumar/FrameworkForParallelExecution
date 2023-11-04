package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentHtmlReporter htmlReporter;

    static ExtentReports createInstance(){

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"./Reports/" + "ExtentReport"+".html");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Jeevan Automatio Report");
        htmlReporter.config().setReportName("ExtentReports - UI Automation");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setEncoding("utf-8");

        extent = new ExtentReports();
        extent.setSystemInfo("Organization","AutomationFranmework");
        extent.setSystemInfo("Execution Mode", "Automated");
        extent.attachReporter(htmlReporter);
        return extent;
    }

}
