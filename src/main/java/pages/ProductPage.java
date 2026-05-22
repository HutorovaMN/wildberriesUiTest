package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

import static utils.Driver.driver;

public class ProductPage {

    public ProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[contains(@class, 'productHeaderBadges')]/following-sibling::h2")
    private WebElement productName;

    @FindBy(xpath = "//span[contains(@class, 'priceBlockPrice')]//ins")
    private WebElement productPrice;

    @FindBy(xpath = "//*[text()='Добавить в корзину']")
    private WebElement buttonBasket;

    @FindBy(xpath = "(//*[text()='В корзине'])[2]")
    private WebElement buttonInBasket;

    @Step("Получение названия товара")
    public String getProductName() {
        return productName.getText();
    }

    @Step("Получение цены товара")
    public String getProductPrice() {
        return productPrice.getText();
    }

    @Step("Кликнуть В корзину")
    public ProductPage clickButtonBasket() {
        buttonBasket.click();
        return this;
    }

    @Step("Кликнуть В корзине")
    public ProductPage clickButtonInBasket() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(buttonInBasket))
                .click();
        return this;
    }
}
