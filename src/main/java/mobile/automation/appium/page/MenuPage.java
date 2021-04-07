package mobile.automation.appium.page;

import mobile.automation.appium.core.BasePage;

public class MenuPage extends BasePage {

    // acessando opcao no menu
    public void accessOption(String option) {
        clickByText(option);
    }
}
