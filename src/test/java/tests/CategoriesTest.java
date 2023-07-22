package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import pages.Categories;
import config.Utilities;
import static casePresentation.Presentation.step;
public class CategoriesTest {
    private WebDriver driver;
    private Categories category;
    private Actions act;

    @BeforeTest
    public void testsInitialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        category =new Categories(driver);
        act = new Actions(driver);
    }

    @Test
    public void verifyHeroCategoryAndItsDirection() {

        step("visit dubizzle url");
        driver.get(Utilities.URL);
        step("hover on vehicle category");
        act.moveToElement(category.categoryCarForSale).build().perform();
        step("Select Car for Sale sub-category");
        act.moveToElement(category.carForSaleSubCategory).click().build().perform();
        String actualSearchText = category.searchText.getText();
        String expectedSearchText = "Cars for Sale";
        step("match that the search category on search page is the selected one");
        assert actualSearchText.equals(expectedSearchText);

    }

    @Test
    public void verifyCatrgorySearchAndCategoryOnSearchPage() {
        step("Visit dubizzle url");
        driver.get(Utilities.URL);
        step("Get the list of all parent categories");
        List<WebElement> allCategories = driver.findElements(By.cssSelector("div[class$='_1adcd900']"));
        Random random = new Random();
        step("Select a random category");
        WebElement selectedCategory = allCategories.get((random.nextInt(allCategories.size())));
        step("Get the text of the random select category");
        String searchCategoryText = selectedCategory.getText();
        step("Click on the selected random category");
        selectedCategory.click();
        step("Trim the text and get the useful text");
        searchCategoryText = searchCategoryText.replace("All in", "");
        searchCategoryText = searchCategoryText.replaceFirst(" ", "");
        String actualCategorySearch = driver.findElement(By.xpath("//span[@class='_7597a67d dd224544'][contains(text(),\"" + searchCategoryText + "\")]")).getText();
        step("Match the category name on search page");
        assert searchCategoryText.equals(actualCategorySearch);
    }

    @AfterTest
    public void distroyBrowser() { driver.quit(); }
}
