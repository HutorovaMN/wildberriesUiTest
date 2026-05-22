import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasketPage;
import pages.ProductPage;

@Owner("Хуторова Марина")
@Epic("Epic-1 Тестовое задание")
@Feature("US-1 Тестовое задание")
public class ProductTest extends BaseTest {
    private final ProductPage productPage = new ProductPage();
    private final BasketPage basketPage = new BasketPage();

    @Test(description = "Добавление товара в корзину")
    public void checkPutProductInBucketTest() {
        String productName = productPage.getProductName();
        String productPrice = productPage.getProductPrice();

        productPage.clickButtonBasket().clickButtonInBasket();

        String basketProductName = basketPage.getBasketProductName();
        String basketProductPrice = basketPage.getBasketProductPrice();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(basketProductName, productName, "Название товара изменилось!");
        softAssert.assertEquals(basketProductPrice, productPrice, "Цена товара изменилась!");
        softAssert.assertAll();
    }
}
