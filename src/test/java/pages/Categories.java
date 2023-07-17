package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Categories {

    public WebDriver driver;

    @FindBy(xpath = "//a[.='Vehicles']")
    public WebElement categoryCarForSale;

    @FindBy(xpath = "//div[@class='_8f799b34 b5f96152'][.='Cars for Sale']")
    public WebElement carForSaleSubCategory;

    @FindBy(css = "h1[class$='_888f7099']")
    public WebElement searchText;

    public Categories(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
