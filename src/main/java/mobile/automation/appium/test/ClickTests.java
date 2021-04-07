package mobile.automation.appium.test;

import mobile.automation.appium.core.BaseTest;
import mobile.automation.appium.page.ClickPage;
import mobile.automation.appium.page.MenuPage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClickTests extends BaseTest {

    private final MenuPage menuPage = new MenuPage();
    private final ClickPage clickPage = new ClickPage();

    @Before
    public void accessAccordion() {
        menuPage.accessOption("Cliques");
    }

    @Test
    public void longClick() {
        clickPage.longClick();
        assertEquals("Clique Longo", clickPage.getTextFromClick());

    }

    @Test
    public void doubleClick() {
        clickPage.clickByText("Clique duplo");
        clickPage.clickByText("Clique duplo");
        assertEquals("Duplo Clique", clickPage.getTextFromClick());

    }
}
