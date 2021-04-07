package mobile.automation.appium.test;

import mobile.automation.appium.core.BaseTest;
import mobile.automation.appium.page.FormPage;
import mobile.automation.appium.page.MenuPage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FormTests extends BaseTest {
    private final MenuPage menuPage = new MenuPage();
    private final FormPage formPage = new FormPage();

    String nameToWrite = "Daniel";
    String consoleName = "Nintendo Switch";

    @Before
    public void accessFormThroughMenu() {
        menuPage.accessOption("Formulário");
    }

    @Test
    public void fillName() {
        formPage.writeName(nameToWrite);
        assertEquals(nameToWrite, formPage.getName());
    }

    @Test
    public void selectOption() {
        formPage.selectCombo(consoleName);
        assertEquals(consoleName, formPage.getConsoleName());
    }

    @Test
    public void checkBox() {
        assertFalse(formPage.isCheckboxChecked());
        assertTrue(formPage.isSwitchChecked());

        formPage.clickCheckBox();
        formPage.clickSwitch();

        assertTrue(formPage.isCheckboxChecked());
        assertFalse(formPage.isSwitchChecked());
    }

    @Test
    public void saveForm() {
        formPage.writeName(nameToWrite);
        formPage.selectCombo(consoleName);
        formPage.clickCheckBox();
        formPage.clickSwitch();

        formPage.saveForm();

        assertEquals("Nome: " + nameToWrite, formPage.getRegisteredName());
        assertEquals("Console: switch", formPage.getRegisteredConsole());
        assertTrue(formPage.getCheckBoxStatus().endsWith("Off"));
        assertTrue(formPage.getSwitchStatus().endsWith("Marcado"));
    }

    @Test
    public void changeDate() {
        formPage.clickByText("01/01/2000");
        formPage.clickByText("20");
        formPage.clickByText("OK");
        formPage.isDateVisible("20/1/2000");
    }

    @Test
    public void changeTime() {
        formPage.clickByText("06:00");
        formPage.selectTime("10");
        formPage.selectTime("40");
        formPage.clickByText("OK");
        formPage.isDateVisible("10:40");
    }

    @Test
    public void seekBarMove() {
        formPage.clickSeekBar(0.70);
        formPage.saveForm();
        assertTrue(formPage.getSeekbarValue().endsWith("70"));
    }
}
