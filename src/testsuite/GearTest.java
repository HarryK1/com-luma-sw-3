package testsuite;
/*
 * 6.Write down the following test into ‘GearTest’ class
 * 1. userShouldAddProductSuccessFullyTo
 * ShoppinCart()
 * * Mouse Hover on Gear Menu
 * * Click on Bags
 * * Click on Product Name ‘Overnight Duffle’
 * * Verify the text ‘Overnight Duffle’
 * * Change Qty 3
 * * Click on ‘Add to Cart’ Button.
 * * Verify the text
 *
 * ‘You added Overnight Duffle to your shopping cart.’
 * * Click on ‘shopping cart’ Link into
 * message
 * * Verify the product name ‘Cronus Yoga Pant’
 * * Verify the Qty is ‘3’
 * * Verify the product price ‘$135.00’
 * * Change Qty to ‘5’
 * * Click on ‘Update Shopping Cart’ button
 * * Verify the product price ‘$225.00’
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class GearTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        //Mouse Hover on Gear Menu
        mouseHoverToElement(By.id("ui-id-6"));
        //Click on Bags
        clickOnElement(By.cssSelector("#ui-id-25"));
        //Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("(//a[normalize-space()='Overnight Duffle'])[1]"));
        //Verify the text ‘Overnight Duffle’
        String expectedText = "Overnight Duffle";
        String actualText = getTextFromElement(By.cssSelector(".base"));
        Assert.assertEquals(expectedText, actualText);
        //Change Qty 3
        driver.findElement(By.id("qty")).clear();
        sendTextToElements(By.id("qty"), "3");
        //Click on ‘Add to Cart’ Button.
        clickOnElement(By.id("product-addtocart-button"));
        //Verify the text ‘You added Overnight Duffle to your shopping cart.’
        String expectedText1 = "You added Overnight Duffle to your shopping cart.";
        String actualText1 = getTextFromElement(By.xpath("//div[@class='message-success success message']"));
        Assert.assertEquals(expectedText1, actualText1);
        Thread.sleep(2000);
        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[text() = 'shopping cart']"));
        //Verify the product name ‘Overnight Duffle’
        String expectedName = "Overnight Duffle";
        String actualName = getTextFromElement(By.xpath("//td[@class ='col item']/descendant::a[2]"));
        Assert.assertEquals(expectedName, actualName);
        //Verify quantity is 3
        String expectedMessage = "3";
        WebElement actualElement = driver.findElement(By.xpath("//input[@value = '3']"));
        String actualMessage = actualElement.getAttribute("value");
        Assert.assertEquals(expectedMessage,actualMessage);
        //Verify the product price ‘$135.00’
        String expectedPrice = "$135.00";
        String actualPrice = getTextFromElement(By.xpath("//td[@class='col subtotal']//descendant::span[contains(text(),'$135.00')]"));
        Assert.assertEquals(expectedPrice, actualPrice);
        //Change Qty to ‘5’
        driver.findElement(By.xpath("//td[@class ='col qty']/child::div[1]/descendant::input")).clear();
        sendTextToElements(By.xpath("//td[@class ='col qty']/child::div[1]/descendant::input"), "5");
        //Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//button[@title ='Update Shopping Cart']"));
        //Verify the product price ‘$225.00’
        String expectedDisplay = "$225.00";
        String actualDisplay = getTextFromElement(By.xpath("//span[contains(text(),'$225.00')]"));
        Assert.assertEquals(expectedDisplay, actualDisplay);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
