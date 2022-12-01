package utilites;

import browserfactroy.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    public void clickOnElement(By by){
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }
    public void switchToAlert(){
        driver.switchTo().alert();
    }
    public void sendTextToElement(By by,String text){
        driver.findElement(by).sendKeys(text);
    }
    public void selectVisibleTextFromDropDown(By by,String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    public void DragAndDrop(){
        Actions actions = new Actions(driver);
        WebElement draggable= driver.findElement(By.id("draggable"));
        WebElement droppable= driver.findElement(By.id("droppable"));
        actions.dragAndDrop(draggable,droppable).build().perform();
    }
    public String getTextFromElement(By by){
        WebElement actualTextMeassageElement=driver.findElement(by);
        return actualTextMeassageElement.getText();

    }
}
