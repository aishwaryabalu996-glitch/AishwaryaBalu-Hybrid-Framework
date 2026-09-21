import org.*;
import utils.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyLoader;
public class AishwaryaHybridTest extends Hooks {

    @Test
    public void placeOrderTest() {

        // =========================================
        // 1. LOGIN
        // =========================================

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage =
                homePage.clickSignupLogin();

        loginPage.enterEmail(
                PropertyLoader.getProperty("username")
        );

        loginPage.enterPassword(
                PropertyLoader.getProperty("password")
        );

        homePage = loginPage.clickLogin();
        System.out.println("Logged in URL: " + driver.getCurrentUrl());

        Assert.assertTrue(
                homePage.isLoggedIn(),
                "Login failed"
        );

        // =========================================
        // 2. HOME PAGE
        // =========================================

        Assert.assertTrue(
                homePage.isHomePageDisplayed(),
                "Home page is not displayed"
        );

        // =========================================
        // 3. PRODUCTS
        // =========================================

        ProductPage productPage =
                homePage.clickProducts();

        productPage.selectProduct();

        productPage.addProductToCart();

        // =========================================
        // 4. CART
        // =========================================

        CartPage cartPage = new CartPage(driver);

        cartPage.clickViewCart();

        Assert.assertTrue(cartPage.isProductDisplayed(), "Product is not displayed in cart");

        // =========================================
        // 5. CHECKOUT
        // =========================================

        CheckoutPage checkoutPage =
                cartPage.clickProceedToCheckout();

        Assert.assertTrue(
                checkoutPage.isAddressDisplayed(),
                "Delivery address is not displayed"
        );

        checkoutPage.enterOrderComment();

        // =========================================
        // 6. PAYMENT
        // =========================================

        PaymentPage paymentPage =
                checkoutPage.clickPlaceOrder();

        paymentPage.enterCardName(
                PropertyLoader.getProperty("cardName")
        );

        paymentPage.enterCardNumber(
                PropertyLoader.getProperty("cardNumber")
        );

        paymentPage.enterCvc(
                PropertyLoader.getProperty("cvc")
        );

        paymentPage.enterExpiryMonth(
                PropertyLoader.getProperty("expiryMonth")
        );

        paymentPage.enterExpiryYear(
                PropertyLoader.getProperty("expiryYear")
        );

        paymentPage.clickPayAndConfirm();

        // =========================================
        // 7. ORDER CONFIRMATION
        // =========================================

        Assert.assertTrue(paymentPage.isOrderPlaced(), "Order was not placed successfully");
    }
}
