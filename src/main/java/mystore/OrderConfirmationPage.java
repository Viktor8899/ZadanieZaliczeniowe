package mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
    private WebDriver driver;

    @FindBy(css = "h3[class='h1 card-title']")
    private WebElement orderIsConfirmedText;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getOrderIsConfirmedText(){
        orderIsConfirmedText.getText();
    }
}
