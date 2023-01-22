package mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingMethodPage {
    private WebDriver driver;

    @FindBy(css = "input[id='delivery_option_1']")
    private WebElement pickUpInStoreOption;

    @FindBy(name = "confirmDeliveryOption")
    private WebElement continueButton;

    public ShippingMethodPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void pickUpInStoreOptionClick() {
        if (!(pickUpInStoreOption.getAttribute("value").contains("1"))) {
            pickUpInStoreOption.click();
        }
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
