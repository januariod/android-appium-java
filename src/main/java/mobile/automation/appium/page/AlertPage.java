package mobile.automation.appium.page;

import mobile.automation.appium.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertPage extends BasePage {

    public void clickAlertAct(String text) {
        clickByText(text);
    }

    public String getAlertTitle() {
        return textGet(By.id("android:id/alertTitle"));
    }

    public String getAlertMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/message")));
        return textGet(By.id("android:id/message"));
    }

    public void clickOutsideAlert() {
        pressByCoordinate(140, 175);
    }
}
