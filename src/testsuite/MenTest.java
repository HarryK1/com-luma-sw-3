package testsuite;
/*
 * 5. Write down the following test into ‘MenTest’
 * class
 * 1. userShouldAddProductSuccessFullyTo
 * ShoppinCart()
 * * Mouse Hover on Men Menu
 * * Mouse Hover on Bottoms
 * * Click on Pants
 * * Mouse Hover on product name
 * ‘Cronus Yoga Pant’ and click on size
 * 32.
 * * Mouse Hover on product name
 * ‘Cronus Yoga Pant’ and click on colour
 * Black.
 * * Mouse Hover on product name
 * ‘Cronus Yoga Pant’ and click on
 * ‘Add To Cart’ Button.
 * * Verify the text
 * ‘You added Cronus Yoga Pant to your shopping cart.’
 * * Click on ‘shopping cart’ Link into
 * message
 * * Verify the text ‘Shopping Cart.’
 * * Verify the product name ‘Cronus Yoga Pant’
 * * Verify the product size ‘32’
 * * Verify the product colour ‘Black’
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {
        //Mouse Hover on Men Menu
        mouseHoverToElement(By.id("ui-id-5"));//or //a[@id='ui-id-18']
        //Mouse Hover on Bottoms
        mouseHoverToElement(By.id("ui-id-18"));//or //a[@id='ui-id-18']    }
        //Click on Pants
        clickOnElement(By.id("ui-id-23"));// or //a[@id='ui-id-23']
        //Mouse Hover on product name 'Cronus Yoga Pant’ and click on size 32.
        mouseHoverToElement(By.xpath("(//a[normalize-space()='Cronus Yoga Pant'])[1]"));
        mouseHoverToElementAndClick(By.xpath("(//div[@id='option-label-size-143-item-175'])[1]"));
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        mouseHoverToElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        mouseHoverToElementAndClick(By.id("option-label-color-93-item-49"));
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseHoverToElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        clickOnElement(By.xpath("(//span[contains(text(),'Add to Cart')])[1]"));
        //Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String expectedTxt = "You added Cronus Yoga Pant to your shopping cart.";
        String actualTxt = getTextFromElement(By.xpath("//div[@class='message-success success message']"));
        Assert.assertEquals(expectedTxt, actualTxt);
        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("(//a[normalize-space()='shopping cart'])[1]"));
        //Verify the text ‘Shopping Cart.’
        String expectedTxt1 = "Shopping Cart";
        String actualTxt1 = getTextFromElement(By.xpath("//h1[@class='page-title']"));
        Assert.assertEquals(expectedTxt1, actualTxt1);
        //Verify the product name ‘Cronus Yoga Pant’
        String expectedName = "Cronus Yoga Pant";
        String actualName = getTextFromElement(By.cssSelector("td[class='col item'] div[class='product-item-details'] a"));
        Assert.assertEquals(expectedName, actualName);
        //Verify the product size ‘32’
        String expectedSize = "32";
        String actualSize = getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        Assert.assertEquals(expectedSize, actualSize);
        //Verify the product colour ‘Black’
        String expectedColour = "Black";
        String actualColour = getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        Assert.assertEquals(expectedColour, actualColour);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
