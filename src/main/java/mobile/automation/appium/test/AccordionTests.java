package mobile.automation.appium.test;

import mobile.automation.appium.core.BaseTest;
import mobile.automation.appium.page.AccordionPage;
import mobile.automation.appium.page.MenuPage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccordionTests extends BaseTest {

    private final MenuPage menuPage = new MenuPage();
    private final AccordionPage accordionPage = new AccordionPage();

    @Before
    public void accessAccordion() {
        menuPage.accessOption("Accordion");
    }

    @Test
    public void AccordionOptionText() {
        accordionPage.clickOption("Opção 1");

        assertEquals("Esta é a descrição da opção 1", accordionPage.optionText());
    }
}
