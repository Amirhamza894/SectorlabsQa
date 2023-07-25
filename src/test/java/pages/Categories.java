package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class Categories {

    public WebDriver driver;

    @FindBy(xpath = "//a[.='Vehicles']")
    public WebElement categoryCarForSale;

    @FindBy(xpath = "//div[@class='_8f799b34 b5f96152'][.='Cars for Sale']")
    public WebElement carForSaleSubCategory;

    @FindBy(css = "h1[class$='_888f7099']")
    public WebElement searchText;

    @FindAll(
            @FindBy(css = "div[class$='_1adcd900']")
    )
    public List<WebElement> allCategories;

    public static WebElement actualCategorySearch(WebDriver driver, String searchCategoryText ) {
        String categoryText = "//span[@class='_7597a67d dd224544'][contains(text(),\"" + searchCategoryText + "\")]";
        return driver.findElement(By.xpath(categoryText));
    }

    public Categories(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
