package mobile.automation.appium.test;

import mobile.automation.appium.core.BaseTest;
import mobile.automation.appium.page.MenuPage;
import mobile.automation.appium.page.TabsPage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TabsTests extends BaseTest {

    private final MenuPage menuPage = new MenuPage();
    private final TabsPage tabsPage = new TabsPage();

    @Before
    public void accessTabs() {
        menuPage.accessOption("Abas");
    }

    @Test
    public void changeTabs() {
        assertTrue(tabsPage.checkTabContent("Este é o conteúdo da Aba 1"));

        tabsPage.clickTabs("ABA 2");

        assertTrue(tabsPage.checkTabContent("Este é o conteúdo da Aba 2"));
    }
}
