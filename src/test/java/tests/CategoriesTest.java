package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import config.Utilities;
import eyesOnTest.Eyes;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import pages.Categories;

import static pages.Categories.actualCategorySearch;
//import static presentation.CasePresentation.step;
import presentation.CasePresentation;
import java.time.Duration;
import java.util.List;
import java.util.Random;

@Listeners(Eyes.class)
public class CategoriesTest {
    private WebDriver driver;
    private Categories category;
    private Actions act;
    protected ExtentReports extentReports;
    CasePresentation present = new CasePresentation();

    @BeforeTest
    public void testsInitialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        category =new Categories(driver);
        act = new Actions(driver);
        extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/extent-report.html");
        extentReports.attachReporter(sparkReporter);

    }

    @Test(description = "Verify Hero Category and it's redirection")
    public void HeroCategoryAndItsDirection() {
        ExtentTest extentTest = extentReports.createTest("HeroCategoryAndItsDirection");
        present.executeStep(extentTest, "Visit dubizzle URL", () -> {
            driver.get(Utilities.URL);
        });

        present.executeStep(extentTest, "hover on vehicle category", () -> {
            act.moveToElement(category.categoryCarForSale).build().perform();
        });

//            step("visit dubizzle url");
//            driver.get(Utilities.URL);
//            step("hover on vehicle category");
//            act.moveToElement(category.categoryCarForSale).build().perform();
//            step("Select Car for Sale sub-category");
//            act.moveToElement(category.carForSaleSubCategory).click().build().perform();
//            String actualSearchText = category.searchText.getText();
//            String expectedSearchText = "Cars for Sale";
//            step("match that the search category on search page is the selected one");
//            assert actualSearchText.equals(expectedSearchText);
    }

//    @Test(description = "Verify parent category and it's redirection to the correct search page")
//    public void CatrgorySearchAndCategoryOnSearchPage() {
//        step("Visit dubizzle url");
//        driver.get(Utilities.URL);
//        step("Get the list of all parent categories");
//        List<WebElement> allCategories = (List<WebElement>) category.allCategories;
//        Random random = new Random();
//        step("Select a random category");
//        WebElement selectedCategory = allCategories.get((random.nextInt(allCategories.size())));
//        step("Get the text of the random select category");
//        String searchCategoryText = selectedCategory.getText();
//        step("Click on the selected random category");
//        selectedCategory.click();
//        step("Trim the text and get the useful text");
//        searchCategoryText = searchCategoryText.replace("All in", "");
//        searchCategoryText = searchCategoryText.replaceFirst(" ", "");
//        String actualCategoryText = actualCategorySearch(driver, searchCategoryText).getText();
//        step("Match the category name on search page");
//        assert searchCategoryText.equals(actualCategoryText);
//    }

    @AfterTest
    public void tearDown() { driver.quit(); extentReports.flush();}
}
