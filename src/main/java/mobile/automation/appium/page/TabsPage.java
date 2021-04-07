package mobile.automation.appium.page;

import mobile.automation.appium.core.BasePage;

public class TabsPage extends BasePage {

    public void clickTabs(String text) {
        clickByText(text);
    }

    public boolean checkTabContent(String text) {
        return isElementVisible(text);
    }
}
