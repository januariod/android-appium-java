package mobile.automation.appium.page;

import mobile.automation.appium.core.BasePage;
import org.openqa.selenium.By;

public class AccordionPage extends BasePage {

    public void clickOption(String opt) {
        clickByText(opt);
    }

    public String optionText() {
        return textGet(By.xpath("//android.widget.TextView[starts-with(@text, 'Esta é a descrição')]"));
    }
}
