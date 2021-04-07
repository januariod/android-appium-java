package mobile.automation.appium.page;

import mobile.automation.appium.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SplashPage extends BasePage {

    // verificando splash
    public boolean isSplashVisible() {
        return isElementVisible("Splash!");
    }

    // espera o splash desaparecer
    public void isSplashInvisible() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Splash!']")));
    }
}
