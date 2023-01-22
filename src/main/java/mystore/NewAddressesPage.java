package mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddressesPage {
    private WebDriver driver;

    @FindBy(id = "field-alias")
    private WebElement aliasInput;

    @FindBy(id = "field-address1")
    private WebElement addressInput;

    @FindBy(id = "field-city")
    private WebElement cityInput;

    @FindBy(id = "field-postcode")
    private WebElement zipCodeInput;

    @FindBy(id = "field-phone")
    private WebElement phoneInput;

    @FindBy(xpath = "//button[contains(@class, 'form-control-submit')]")
    private WebElement saveButton;

    public NewAddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillAndSaveNewAddressForm(String alias, String address, String city, String zipCode, String phone) {
        aliasInput.sendKeys(alias);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        zipCodeInput.sendKeys(zipCode);
        phoneInput.sendKeys(phone);
        saveButton.click();
    }
}
