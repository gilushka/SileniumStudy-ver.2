import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.FirstStepInsPage;
import pages.MainPage;
import pages.SecondStepInsPage;
import pages.TravelInsurancePage;
import steps.BaseSteps;

import static junit.framework.TestCase.assertTrue;

public class Task01Test extends BaseSteps {

    @Test
    public void testMethod() throws Exception{
        driver.get(baseUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMenuItem("Раздел Застраховать себя  и имущество");
        mainPage.selectInsuranceItem("Страхование путешественников");

        TravelInsurancePage TIForm = new TravelInsurancePage(driver);
        TIForm.waitAppearence(TIForm.title);
        Assert.assertEquals("Страхование путешественников", TIForm.title.getText());
        TIForm.waitAppearence(TIForm.sendAppBtn);
        TIForm.sendAppBtn.click();

        for (String handle : driver.getWindowHandles()){ //Переключение экрана
            driver.switchTo().window(handle);
        }

        FirstStepInsPage FSIForm = new FirstStepInsPage(driver);
        FSIForm.waitAppearence(FSIForm.select);
        FSIForm.selectItem("35");
        FSIForm.sendAppBtn.click();

        SecondStepInsPage sSIForm = new SecondStepInsPage(driver);
        String actualTitle = sSIForm.title.getText();
        String expectedTitle = "Страхователь";
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualTitle, expectedTitle), actualTitle.contains(expectedTitle));

        sSIForm.fillField("Застрахованные: Фамилия", "Ivanov");
        sSIForm.fillField("Застрахованные: Имя", "Ivan");
        sSIForm.fillField("Застрахованные: Дата рождения", "19.05.1985");

        sSIForm.fillField("Фамилия", "Петров");
        sSIForm.fillField("Имя", "Петр");
        sSIForm.fillField("Отчество", "Петрович");
        sSIForm.fillField("Дата рождения", "18.06.1985");

        sSIForm.sex.click();

        sSIForm.fillField("Серия паспорта", "1825");
        sSIForm.fillField("Номер паспорта", "260118");
        sSIForm.fillField("Дата выдачи", "09.06.2005");
        sSIForm.fillField("Место выдачи", "olala!");

        sSIForm.checkFieldData("Застрахованные: Фамилия","Ivanov");
        sSIForm.checkFieldData("Застрахованные: Имя", "Ivan");
        sSIForm.checkFieldData("Застрахованные: Дата рождения","19.05.1985");

        sSIForm.checkFieldData("Фамилия","Петров");
        sSIForm.checkFieldData("Имя","Петр");
        sSIForm.checkFieldData("Отчество", "Петрович");
        sSIForm.checkFieldData("Дата рождения","18.06.1985");

        sSIForm.checkFieldData("Серия паспорта","1825");
        sSIForm.checkFieldData("Номер паспорта","260118");
        sSIForm.checkFieldData("Дата выдачи", "09.06.2005");
        sSIForm.checkFieldData("Место выдачи","olala!");

        sSIForm.sendButton.click();

        By by = By.xpath("//div[contains(@class,'b-form-center-pos')]/div[contains(text(),'Заполнены не все обязательные поля')]");
        Assert.assertEquals(true, isElementPresent(by));


    }

}
