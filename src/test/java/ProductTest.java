import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BucketPage;
import pages.ProductPage;

@Owner("Хуторова Марина")
@Epic("Epic-1 Тестовое задание")
@Feature("US-1 Тестовое задание")
public class ProductTest extends BaseTest {
    private final ProductPage productPage = new ProductPage();
    private final BucketPage bucketPage = new BucketPage();

    @Test(description = "Добавление товара в корзину")
    public void checkPutProductInBucketTest() {
        String productName = productPage.getProductName();
        String productPrice = productPage.getProductPrice();

        productPage.clickButtonBucket().clickButtonInBucket();

        String bucketProductName = bucketPage.getBucketProductName();
        String bucketProductPrice = bucketPage.getBucketProductPrice();

        new SoftAssert() {{
            assertEquals(bucketProductName, productName, "Название товара изменилось!");
            assertEquals(bucketProductPrice, productPrice, "Цена товара изменилась!");
        }}.assertAll();
    }
}
