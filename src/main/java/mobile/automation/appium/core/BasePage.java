package mobile.automation.appium.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static mobile.automation.appium.core.DriverFactory.getDriver;

public class BasePage {

    public WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 5);

    public void fillText(By by, String text) {
        getDriver().findElement(by).sendKeys(text);
    }

    public String textGet(By by) {
        return getDriver().findElement(by).getText();
    }

    public void clickOn(By by) {
        getDriver().findElement(by).click();
    }

    public void clickByText(String text) {
        clickOn(By.xpath("//*[@text='" + text + "']"));
    }

    public void selectCombo(By by, String text) {
        getDriver().findElement(by).click();
        clickByText(text);
    }

    public boolean isChecked(By by) {
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean isElementVisible(String text) {
        List<MobileElement> elements = getDriver().findElements(By.xpath("//*[@text='" + text + "']"));
        return elements.size() > 0;
    }

    public void pressByCoordinate(int x, int y) {
        new TouchAction(getDriver()).press(PointOption.point(x, y)).perform();
    }

    public void tapByCoordinate(int x, int y) {
        new TouchAction(getDriver()).tap(PointOption.point(x, y)).perform();
    }

    public void scroll(double start, double end) {
        Dimension size = getDriver().manage().window().getSize();
        int pointX = size.width / 2;
        int startY = (int) (size.height * start);
        int endY = (int) (size.height * end);

        new TouchAction(getDriver())
                .press(PointOption.point(pointX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(pointX, endY))
                .release()
                .perform();
    }
}
