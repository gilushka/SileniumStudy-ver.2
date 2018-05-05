import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;

public class ForAllureReportTest extends BaseSteps {

        MainSteps mainSteps = new MainSteps();
        TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();
        FirstStepInsSteps firstStepInsSteps = new FirstStepInsSteps();
        SecondStepInsSteps secondStepInsSteps = new SecondStepInsSteps();

        HashMap<String, String> testData = new HashMap<>();

        @Title("Заявка на ДМС")
        @Test
        public void Test(){
            testData.put("Застрахованные: Фамилия","Ivanov");
            testData.put("Застрахованные: Имя","Ivan");
            testData.put("Застрахованные: Дата рождения","19.05.1985");
            testData.put("Фамилия","Петров");
            testData.put("Имя","Петр");
            testData.put("Отчество","Петрович");
            testData.put("Дата рождения","18.06.1985");
            testData.put("Серия паспорта","1825");
            testData.put("Номер паспорта","260118");
            testData.put("Дата выдачи","09.06.2005");
            testData.put("Место выдачи","olala!");

            mainSteps.stepSelectMainMenu("Раздел Застраховать себя  и имущество");
            mainSteps.stepSelectSubMenu("Раздел Застраховать себя  и имущество", "Страхование путешественников");
            travelInsuranceSteps.checkPageTitle("Страхование путешественников");
            travelInsuranceSteps.stepSendAppButton();

            for (String handle : BaseSteps.getDriver().getWindowHandles()){ //Переключение экрана
                BaseSteps.getDriver().switchTo().window(handle);
            }

            firstStepInsSteps.selectValueIns();
            firstStepInsSteps.stepSendAppButton();
            secondStepInsSteps.checkPageTitle("Страхователь");

            secondStepInsSteps.fillFields(testData);

//            testData.put("Телефон","+7 (919) 111-11-11");
            secondStepInsSteps.checkFillFields(testData);
//            sendAppSteps.checkErrorMessageField("Эл. почта", "Введите корректный email");

            secondStepInsSteps.stepSendAppButton();

            By by = By.xpath("//div[contains(@class,'b-form-center-pos')]/div[contains(text(),'Заполнены не все обязательные поля')]");
            Assert.assertEquals(true, isElementPresent(by));
        }

}
