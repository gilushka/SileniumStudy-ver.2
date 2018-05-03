package steps;

import pages.SecondStepInsPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class SecondStepInsSteps extends BaseSteps {

    @Step("Поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value){
        new SecondStepInsPage(driver).fillField(field, value);
    }

    @Step("Заполняются поля:")
    public void stepFillFields(HashMap<String, String> fields){
        fields.forEach(this::stepFillField);
    }

    @Step("Нажатие кнопки - Продолжить")
    public void stepSendAppButton(){
        new SecondStepInsPage(driver).sendButton.click();
    }
}
