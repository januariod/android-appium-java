package mobile.automation.appium.page;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import mobile.automation.appium.core.BasePage;
import org.openqa.selenium.By;

import static mobile.automation.appium.core.DriverFactory.getDriver;

public class FormPage extends BasePage {

    // preenchendo nome
    public void writeName(String name) {
        fillText(MobileBy.AccessibilityId("nome"), name);
    }

    // verificando nome
    public String getName() {
        return textGet(MobileBy.AccessibilityId("nome"));
    }

    // selecionando opcao do combo
    public void selectCombo(String opcao) {
        selectCombo(MobileBy.AccessibilityId("console"), opcao);
    }

    // verificando opcao selecionada
    public String getConsoleName() {
        return textGet(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    // clicando no checkbox
    public void clickCheckBox() {
        clickOn(By.className("android.widget.CheckBox"));
    }

    // clicando no switch
    public void clickSwitch() {
        clickOn(MobileBy.AccessibilityId("switch"));
    }

    // verificando estado do checkbox
    public boolean isCheckboxChecked() {
        return isChecked(By.className("android.widget.CheckBox"));
    }

    // verificando estado do switch
    public boolean isSwitchChecked() {
        return isChecked(MobileBy.AccessibilityId("switch"));
    }

    // salvar formulario
    public void saveForm() {
        clickByText("SALVAR");
    }

    // verifica o nome cadastrado
    public String getRegisteredName() {
        return textGet(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
    }

    // verifica o console cadastrado
    public String getRegisteredConsole() {
        return textGet(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
    }

    // verifica estado do checkbox
    public String getCheckBoxStatus() {
        return textGet(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
    }

    // verifica estado do switch
    public String getSwitchStatus() {
        return textGet(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
    }

    // verifica se a data esta sendo exibida na tela
    public void isDateVisible(String text) {
        isElementVisible("text");
    }

    // clica na hora e minuto
    public void selectTime(String text) {
        clickOn(MobileBy.AccessibilityId(text));
    }

    // clica no seekbar
    public void clickSeekBar(double position) {
        int delta = 50;
        MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
        int y = seek.getLocation().y + (seek.getSize().height / 2);
        int x = (int) (seek.getLocation().x + delta + ((seek.getSize().width - 2 * delta) * position));

        tapByCoordinate(x, y);
    }

    // verifica estado do seekbar
    public String getSeekbarValue() {
        return textGet(By.xpath("//android.widget.TextView[starts-with(@text, 'Slider: ')]"));
    }
}
