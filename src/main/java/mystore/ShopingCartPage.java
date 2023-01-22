package mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopingCartPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[contains(text(), 'Proceed')]")
    private WebElement proceedToCheckoutButton;

    public ShopingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }
}
