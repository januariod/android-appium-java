package mobile.automation.appium.test;

import mobile.automation.appium.core.BaseTest;
import mobile.automation.appium.page.AlertPage;
import mobile.automation.appium.page.MenuPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScrollTests extends BaseTest {

    private final MenuPage menuPage = new MenuPage();
    private final AlertPage alertPage = new AlertPage();

    @Test
    public void scrollToOption() {
        menuPage.scroll(0.9, 0.1);

        menuPage.accessOption("Opção bem escondida");

        assertEquals("Você achou essa opção", alertPage.getAlertMessage());

        menuPage.clickByText("OK");
    }
}
