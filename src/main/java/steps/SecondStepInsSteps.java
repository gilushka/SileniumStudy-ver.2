package steps;

import pages.SecondStepInsPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static junit.framework.TestCase.assertTrue;

public class SecondStepInsSteps extends BaseSteps {


    @Step("поле {0} заполняется значением {1}")
    public void fillField(String field, String value){
        new SecondStepInsPage().fillField(field, value);
    }

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value){
        String actual = new SecondStepInsPage().getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("в поле {0} присутствует сообщение об ошибке {1}")
    public void checkErrorMessageField(String field, String value){
        new SecondStepInsPage().checkFieldErrorMessage(field, value);
    }

    @Step("заголовок страницы - Отправить заявку равен {0}")
    public void checkPageTitle(String expectedTitle){
        String actualTitle = new SecondStepInsPage().title.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

    @Step("заполняются поля")
    public void fillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> fillField(k,v));
    }

    @Step("поля заполнены верно")
    public void checkFillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> checkFillField(k,v));
    }

    @Step("Нажатие кнопки - Продолжить")
    public void stepSendAppButton(){
        new SecondStepInsPage().sendButton.click();
    }

    @Step("Проверка наличия сообщения об ошибке")
    public void checkFieldErrorMessage(){
        new SecondStepInsPage().checkFieldErrorMessage();
    }


}
