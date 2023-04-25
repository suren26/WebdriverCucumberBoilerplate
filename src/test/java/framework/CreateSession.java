package framework;

import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import logger.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


public class  CreateSession {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
    @Before
    public static void createDriver() {
        String browserName = System.getProperty("browser");
        String headless =System.getProperty("headless");
        DesiredCapabilities capability = new DesiredCapabilities();
        if (browserName == null)
            browserName = "chrome";
        if( headless != null && headless.equalsIgnoreCase("yes")){
//            ChromeOptions options=new ChromeOptions();
//            options.addArguments(headless);
//            webDriver.set( new ChromeDriver(options));
        }
        // if browser name passed as firefox
        else if(browserName.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            capability.setBrowserName("Firefox");
            webDriver.set(new FirefoxDriver());

        }
        // if browser name passed as chrome
        else if(browserName.equalsIgnoreCase("chrome")){
            String OS = System.getProperty("os.name");
            if(OS.contains("Windows"))
            {
                WebDriverManager.chromedriver().setup();
                capability.setBrowserName("Chrome");
                capability.setPlatform(Platform.WIN8_1);
                webDriver.set(new ChromeDriver());
            }
            else if(OS.contains("Linux"))
            {
                WebDriverManager.chromedriver().setup();
                capability.setBrowserName("Chrome");
                capability.setPlatform(Platform.LINUX);
                webDriver.set(new ChromeDriver());
            }
            else if(OS.contains("Mac"))
            {
                WebDriverManager.chromedriver().setup();
                capability.setBrowserName("Chrome");
                capability.setPlatform(Platform.MAC);
                webDriver.set(new ChromeDriver());
            }
        }
        getWebDriver().manage().window().maximize();
    }
    public static WebDriver getWebDriver() {
        System.out.println("WebDriver: " + webDriver.get());
        return webDriver.get();
    }
    @After
    public void teardown(Scenario scenario){

        // Here will compare if test is failing then only it will enter into if condition

        if(scenario.isFailed())
        {
            try
            {
                // Create reference of TakesScreenshot
                TakesScreenshot ts=(TakesScreenshot) getWebDriver();

                // Call method to capture screenshot
                File source=ts.getScreenshotAs(OutputType.FILE);

                FileUtils.copyFile(source, new File(".//src//test//java//outputFiles//"+ "FailScreenshot" +
                        new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss")
                                .format(new GregorianCalendar().getTime())
                        + ".png"));
                System.out.println("Scenario failed and screenshot saved in outputFiles folder");
            }
            catch (Exception e)
            {

                System.out.println("Exception while taking screenshot "+e.getMessage());

            }
        }



        System.out.println("Shutting down driver" + "\n" + "----------------------------------------------");
        System.out.println("\n");
        // quitting the webdriver
        getWebDriver().quit();
    }
}
