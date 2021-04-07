package mobile.automation.appium.core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    @AfterClass
    public static void killDriverAfterClass() {
        DriverFactory.killDriver();
    }

    @After
    public void resetApp() {
        takeScreenshot();
        DriverFactory.getDriver().resetApp();
    }

    public void takeScreenshot() {
        try {
            File image = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(image, new File("target/screenshots/" + testName.getMethodName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void waitTime(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}