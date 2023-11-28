package utilities;
/*
 * 2. Create the package utilities and create the class
 * with the name ‘Utility’ inside the ‘utilities’
 * package. And write the all the utility methods in
 * it’.
 */

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
        //this method will click on method
        public void clickOnElement(By by){
            driver.findElement(by).click();
        }
        //this method will enter the input into text field
        public void sendTextToElements(By by, String text){
            driver.findElement(by).sendKeys(text);
        }
        //this method will get text from Element
        public String getTextFromElement(By by){
            return driver.findElement(by).getText();
        }
        //this method will select the option by visible text
        public void selectByVisibleTextFromDropDown(By by, String text){
            WebElement dropDown = driver.findElement(by);
            Select select = new Select(dropDown);
            select.selectByVisibleText(text);
        }
        //this method will select the option by visible value
        public void selectByValueFromDropDown(By by, String value){
            new Select(driver.findElement(by)).selectByValue(value);
        }
        //selectByIndex (int index)
        public void selectByIndex(By by, int index){
            new Select(driver.findElement(by)).selectByIndex(index);
        }
        //selectOptionByContainsText

        public void mouseHoverToElement(By by){
            Actions actions = new Actions(driver);
            WebElement computer = driver.findElement(by);
            WebElement software = driver.findElement(by);
            //mouse hover to computers
            actions.moveToElement(computer).build().perform();
        }
        //mouseHoverToElementAndClick
        public void mouseHoverToElementAndClick(By by){
            Actions actions = new Actions(driver);
            WebElement computer = driver.findElement(by);
            WebElement software = driver.findElement(by);
            //click on software in computer
            actions.moveToElement(software).click().build().perform();
        }

    }
