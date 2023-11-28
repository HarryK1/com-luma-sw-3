package testsuite;
/*
 * 4. Write down the following test into WomenTestclass
 * 1. verifyTheSortByProductNameFilter
 * * Mouse Hover on Women Menu
 * * Mouse Hover on Tops
 * * Click on Jackets
 * * Select Sort By filter “Product Name”
 * * Verify the products name display in
 * alphabetical order
 * 2. verifyTheSortByPriceFilter
 * * Mouse Hover on Women Menu
 * * Mouse Hover on Tops
 * * Click on Jackets
 * * Select Sort By filter “Price”
 * * Verify the products price display in
 * Low to High
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {
        //Mouse Hover on Women Menu
        mouseHoverToElement(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));
        //Mouse Hover on Tops
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']//span[text()='Tops']"));
        //Click on Jackets
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        //Select Sort By filter “Product Name”
        selectByVisibleTextFromDropDown(By.xpath("(//select[@id='sorter'])[1]"), "Product Name");
        //Verify the products name display in alphabetical order
        List<WebElement> productsName = driver.findElements(By.xpath("//strong[@class='product name product-item-name']"));
        System.out.println("Product List in ascending order : ");
        for (WebElement products: productsName)
        {
            System.out.println(products.getText());
        }

    }

    @Test
    public void verifyTheSortByPriceFilter() {
        //Mouse Hover on Women Menu
        mouseHoverToElement(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));
        //Mouse Hover on Tops
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']//span[text()='Tops']"));
        //Click on Jackets
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        //Select Sort By filter “Price”
        selectByVisibleTextFromDropDown(By.id("sorter"), "Price");
        //Verify the products price display in Low to High
        List<WebElement> productsPrice = driver.findElements(By.xpath("//div[@class = 'price-box price-final_price']"));
        System.out.println("Products price is display in Low to High : ");
        for (WebElement products: productsPrice)
        {
            System.out.println(products.getText());
        }
        }
        @After
        public void tearDown(){
            closeBrowser();
        }
    }


