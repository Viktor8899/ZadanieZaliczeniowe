package mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    private WebDriver driver;

    @FindBy(css = "input[id='payment-option-1']")
    private WebElement payByCheckOption;

    @FindBy(name = "conditions_to_approve[terms-and-conditions]")
    private WebElement termsOfServiceCheckbox;

    @FindBy(css = "button[class='btn btn-primary center-block']")
    private WebElement placeOrderButton;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void chosePayByCheckOption() {
        payByCheckOption.click();
    }

    public void clickCheckboxTermsOfService() {
        termsOfServiceCheckbox.click();
    }

    public void clickPlaceOrderButton(){
        placeOrderButton.click();
    }
}
