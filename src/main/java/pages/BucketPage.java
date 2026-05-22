package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class BucketPage {
    public BucketPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='good-info__good-name']")
    private WebElement bucketProductName;

    @FindBy(xpath = "//*[@class='list-item__price-new red-price']")
    private WebElement bucketProductPrice;

    @Step("Получение названия товара")
    public String getBucketProductName() {
        return bucketProductName.getText();
    }

    @Step("Получение цены товара")
    public String getBucketProductPrice() {
        return bucketProductPrice.getText();
    }
}
