package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class BasketPage {
    public BasketPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='good-info__good-name']")
    private WebElement basketProductName;

    @FindBy(xpath = "//*[@class='list-item__price-new red-price']")
    private WebElement basketProductPrice;

    @Step("Получение названия товара")
    public String getBasketProductName() {
        return basketProductName.getText();
    }

    @Step("Получение цены товара")
    public String getBasketProductPrice() {
        return basketProductPrice.getText();
    }
}
