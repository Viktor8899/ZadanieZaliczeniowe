package mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    @FindBy(xpath = "//div/a[@href='https://mystore-testlab.coderslab.pl/index.php?controller=my-account']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[normalize-space()='Hummingbird printed sweater']")
    private WebElement hummingbirdPrintedSweaterItem;

    @FindBy(xpath = "//img[@alt='PrestaShop']")
    private WebElement prestaShopImage;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void goToLoginPage() {
        signInButton.click();
    }

    public void goToMainPage() {
        prestaShopImage.click();
    }

    public void clickHummingbirdPrintedSweaterItem() {
        hummingbirdPrintedSweaterItem.click();
    }

}
