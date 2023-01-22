package mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddressesPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@href='https://mystore-testlab.coderslab.pl/index.php?controller=address']")
    private WebElement createNewAddress;

    @FindBy(className = "alert-success")
    private WebElement alertAboutSuccess;

    @FindBy(name = "confirm-addresses")
    private WebElement continueButton;

    public AddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToNewAddressFormPage() {
        createNewAddress.click();
    }

    public String getAlertText() {
        return alertAboutSuccess.getText();
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}