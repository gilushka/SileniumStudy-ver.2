import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class Task01Test extends BaseTest {

    @Test
    public void testMethod() throws Exception{
        driver.get(baseUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMenuItem();
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        driver.findElement(By.xpath("//*[@class=\"alt-menu-mid\"]/ul/li[5]/a")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'header_more_nav')]//*[contains(text(), 'Страхование путешественников')]")))).click(); //Явное ожидание видимости элемента


        WebElement title = driver.findElement(By.xpath("//div[contains(@class,'sbrf-rich-outer')]/h1"));
        wait.until(ExpectedConditions.visibilityOf(title));
        Assert.assertEquals("Страхование путешественников", title.getText());

        driver.findElement(By.xpath("//a//img[contains(@src,'banner-zashita-traveler')]")).click();

        for (String handle : driver.getWindowHandles()){ //Переключение экрана
            driver.switchTo().window(handle);
        }

        driver.findElement(By.xpath("//div[contains(text(),'35')]")).click();
        driver.findElement(By.xpath("//span[contains(@class,'b-button-block-center')]/span[contains(text(),'Оформить')]")).click();

        fillField(By.name("insured0_surname"), "Ivanov");
        fillField(By.name("insured0_name"), "Ivan");
        driver.findElement(By.name("insured0_birthDate")).click();
        fillField(By.name("insured0_birthDate"), "19.05.1985");

        fillField(By.name("surname"), "Петров");
        fillField(By.name("name"), "Петр");
        fillField(By.name("middlename"), "Петрович");
        driver.findElement(By.name("birthDate")).click();
        fillField(By.name("birthDate"), "18.06.1985");

        driver.findElement(By.name("female")).click();

        Assert.assertEquals("18.06.1985", driver.findElement(By.name("birthDate")).getAttribute("value"));

        fillField(By.name("passport_series"), "1825");
        fillField(By.name("passport_number"), "260118");
        driver.findElement(By.name("issueDate")).click();
        fillField(By.name("issueDate"), "09.06.2005");
        fillField(By.name("issuePlace"), "olala!");

        Assert.assertEquals("Ivanov", driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        Assert.assertEquals("Ivan", driver.findElement(By.name("insured0_name")).getAttribute("value"));
        Assert.assertEquals("19.05.1985", driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));

        Assert.assertEquals("Петров", driver.findElement(By.name("surname")).getAttribute("value"));
        Assert.assertEquals("Петр", driver.findElement(By.name("name")).getAttribute("value"));
        Assert.assertEquals("Петрович", driver.findElement(By.name("middlename")).getAttribute("value"));
        Assert.assertEquals("19.05.1985", driver.findElement(By.name("birthDate")).getAttribute("value"));

        Assert.assertEquals("1825", driver.findElement(By.name("passport_series")).getAttribute("value"));
        Assert.assertEquals("260118", driver.findElement(By.name("passport_number")).getAttribute("value"));
        Assert.assertEquals("09.06.2005", driver.findElement(By.name("issueDate")).getAttribute("value"));
        Assert.assertEquals("olala!", driver.findElement(By.name("issuePlace")).getAttribute("value"));

        driver.findElement(By.xpath("//span[@class=\"b-continue-btn\"]")).click();

        By by = By.xpath("//div[contains(@class,'b-form-center-pos')]/div[contains(text(),'Заполнены не все обязательные поля')]");
        Assert.assertEquals(true, isElementPresent(by));


    }

//    public void fillField(By locator, String value){
//        driver.findElement(locator).clear();
//        driver.findElement(locator).sendKeys(value);
//    }

//    public boolean isElementPresent(By by) {
//        try{
//            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//            return driver.findElement(by).isDisplayed();
//        }catch (Exception e){
//            return false;
//        }finally {
//            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        }
//    }

}
