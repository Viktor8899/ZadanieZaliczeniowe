package mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;

    private WebElement sizeOfSweaterMedium;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityField;

    @FindBy(xpath = "//button[@class='btn btn-primary add-to-cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[contains(text(), 'Proceed')]")
    private WebElement proceedToCheckoutButton;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void choseSizeOfSweater(String size) {
        sizeOfSweaterMedium = driver.findElement(By.xpath("//option[@title='" + size + "']"));
        sizeOfSweaterMedium.click();
    }

    public void choseQuantityOfSweater(String quantity) {
        new Actions(driver).click(quantityField)
                .pause(100).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .pause(100).sendKeys(Keys.BACK_SPACE)
                .pause(100).sendKeys(quantity).perform();
    }

    public void addToCartButton() {
        addToCartButton.click();
    }

    public void clickProceedToCheckoutButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        proceedToCheckoutButton.click();
    }
}