import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;

public class ForAllureReport extends BaseSteps {

    @Test
    @Title("Страхование")
    public void testInsurance(){
        MainSteps mainSteps = new MainSteps();
        TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();
        FirstStepInsSteps firstStepInsSteps = new FirstStepInsSteps();
        SecondStepInsSteps secondStepInsSteps = new SecondStepInsSteps();

        HashMap<String, String> testData = new HashMap<>();
        testData.put("Застрахованные: Фамилия", "Ivanov");
        testData.put("Застрахованные: Имя", "Ivan");
        testData.put("Застрахованные: Дата рождения", "19.05.1985");
        testData.put("Фамилия", "Петров");
        testData.put("Имя", "Петр");
        testData.put("Отчество", "Петрович");
        testData.put("Дата рождения", "18.06.1985");
        testData.put("Серия паспорта", "1825");
        testData.put("Номер паспорта", "260118");
        testData.put("Дата выдачи", "09.06.2005");
        testData.put("Место выдачи", "olala!");

    }
}
