package framework;

import org.openqa.selenium.WebDriver;

import java.io.File;

public class Assertions {
    private WebDriver driver;
    private File file;
    private String testScreenshotDir;
    public Assertions(WebDriver driver) {
        file = new File("");
        testScreenshotDir = file.getAbsoluteFile()
                + "//src//test//java//outputFiles//";
        this.driver = driver;

    }

}
