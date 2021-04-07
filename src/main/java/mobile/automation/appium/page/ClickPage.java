package mobile.automation.appium.page;

import io.appium.java_client.MobileElement;
import mobile.automation.appium.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static mobile.automation.appium.core.DriverFactory.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class ClickPage extends BasePage {

    public void longClick() {
        getDriver().findElement(By.xpath("//*[@text='Clique Longo']")).click();
        MobileElement longPress = (MobileElement) new WebDriverWait(getDriver(), 30).
                until(elementToBeClickable(getDriver().findElement(By.xpath("//*[@text='Clique Longo']"))));
        new Actions(getDriver()).clickAndHold(longPress).perform();
    }

    public String getTextFromClick() {
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }
}
