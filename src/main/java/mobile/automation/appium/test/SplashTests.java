package mobile.automation.appium.test;

import mobile.automation.appium.core.BaseTest;
import mobile.automation.appium.page.MenuPage;
import mobile.automation.appium.page.SplashPage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SplashTests extends BaseTest {

    private final MenuPage menuPage = new MenuPage();
    private final SplashPage splashPage = new SplashPage();

    @Before
    public void accessSplashThroughMenu() {
        menuPage.accessOption("Splash");
    }

    @Test
    public void waitSplashDisappear() {
        splashPage.isSplashVisible();
        splashPage.isSplashInvisible();

        assertTrue(splashPage.isElementVisible("Formulário"));
    }
}
