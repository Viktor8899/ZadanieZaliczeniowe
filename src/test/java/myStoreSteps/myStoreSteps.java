package myStoreSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mystore.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class myStoreSteps {
    private WebDriver driver;

    @Given("an open browser with {string}")
    public void openBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @And("user logged into account with {} and {}")
    public void logIntoMyStore(String email, String password) {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
    }

    @And("user has returned to the home page")
    public void userHasReturnedToTheHomePage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToMainPage();
    }

    @And("user clicked a button called ADDRESSES")
    public void userClickedButtonAddresses() {
        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        yourAccountPage.clickAddressesButton();
    }

    @And("choose hummingbird printed sweater from popular products section")
    public void chooseHummingbirdPrintedSweaterFromPopularProducts() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickHummingbirdPrintedSweaterItem();
    }

    @And("user chose size {} of the sweater")
    public void userChoseSizeMOfTheSweater(String size) {
        ProductPage productPage = new ProductPage(driver);
        productPage.choseSizeOfSweater(size);
    }

    @And("user chose quantity of sweater equal to {}")
    public void userChoseQuantityOfSweaterEqualToAmount(String quantity) {
        ProductPage productPage = new ProductPage(driver);
        productPage.choseQuantityOfSweater(quantity);
    }

    @And("user added sweater to cart")
    public void userAddedSweaterToCart() {
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCartButton();
    }

    @And("user clicked button proceed to checkout on popup")
    public void userClickedButtonProceedToCheckoutOnPopUp() {
        ProductPage productPage = new ProductPage(driver);
        productPage.clickProceedToCheckoutButton();
    }

    @And("user clicked second button proceed to checkout on shopping cart page")
    public void userClickedSecondButtonProceedToCheckoutOnShoppingCartPage() {
        ShopingCartPage shopingCartPage = new ShopingCartPage(driver);
        shopingCartPage.clickProceedToCheckoutButton();
    }

    @And("user clicked continue button on addresses page")
    public void userClickedContinueButtonOnAddressesPage() {
        AddressesPage addressesPage = new AddressesPage(driver);
        addressesPage.clickContinueButton();
    }

    @And("user chose 'pick up in store' option")
    public void userChosePickUpInStoreOption() {
        ShippingMethodPage shippingMethodPage = new ShippingMethodPage(driver);
        shippingMethodPage.pickUpInStoreOptionClick();
    }

    @And("user clicked 'continue' button on shipping method")
    public void userClickedContinueButtonOnShippingMethod() {
        ShippingMethodPage shippingMethodPage = new ShippingMethodPage(driver);
        shippingMethodPage.clickContinueButton();
    }

    @And("user picked payment option 'Pay by Check'")
    public void userPickedPaymentOptionPayByCheck() {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.chosePayByCheckOption();
    }

    @And("user clicked checkbox with 'terms of service'")
    public void userClickedCheckboxWithTermsOfService() {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.clickCheckboxTermsOfService();
    }

    @When("user clicked 'place order' button")
    public void userClickedPlaceOrderButton() {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.clickPlaceOrderButton();
    }

    @When("user added new address: {}, {}, {}, {}, {}")
    public void userAddedNewAddress(String alias, String address, String city, String zipCode, String phone) {
        AddressesPage addressesPage = new AddressesPage(driver);
        addressesPage.goToNewAddressFormPage();
        NewAddressesPage newAddressPage = new NewAddressesPage(driver);
        newAddressPage.fillAndSaveNewAddressForm(alias, address, city, zipCode, phone);
    }

    @Then("message about successful add address")
    public void messageAboutSuccessfulAddAddress() {
        AddressesPage addressesPage = new AddressesPage(driver);
        assertEquals("Address successfully added!", addressesPage.getAlertText());
    }

    @Then("order is confirmed")
    public void assertOrderIsConfirmed() {
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        orderConfirmationPage.getOrderIsConfirmedText();
    }

    @And("screenshot has been taken")
    public void screenshotHasBeenTaken() throws IOException {
        DateFormat DF = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
        String fileName = DF.format(new Date()) + ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/test/resources/screenshots/" + fileName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @And("close the browser")
    public void closeTheBrowser() {
        driver.close();
    }

    @When("user added new address")
    public void userAddedNewAddress() {
    }
}
