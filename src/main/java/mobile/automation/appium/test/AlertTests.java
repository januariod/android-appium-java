package mobile.automation.appium.test;

import mobile.automation.appium.core.BaseTest;
import mobile.automation.appium.page.AlertPage;
import mobile.automation.appium.page.MenuPage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class AlertTests extends BaseTest {

    private final MenuPage menuPage = new MenuPage();
    private final AlertPage alertPage = new AlertPage();

    @Before
    public void accessAlerts() {
        menuPage.accessOption(("Alertas"));
    }

    @Test
    public void confirmAlert() {
        alertPage.clickAlertAct("ALERTA CONFIRM");

        assertEquals("Info", alertPage.getAlertTitle());
        assertEquals("Confirma a operação?", alertPage.getAlertMessage());

        alertPage.clickAlertAct("CONFIRMAR");
        assertEquals("Confirmado", alertPage.getAlertMessage());

        alertPage.clickAlertAct("SAIR");
    }

    @Test
    public void simpleAlert() {
        alertPage.clickAlertAct("ALERTA SIMPLES");

        waitTime(1000);
        alertPage.clickOutsideAlert();

        assertFalse(alertPage.isElementVisible("Pode clicar no OK ou fora da caixa para sair"));
    }
}
