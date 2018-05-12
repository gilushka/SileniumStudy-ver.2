package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();
    FirstStepInsSteps firstStepInsSteps = new FirstStepInsSteps();
    SecondStepInsSteps secondStepInsSteps = new SecondStepInsSteps();

    @When("^выбран пункт меню \"(.+)\"$")
    public void stepSelectMainMenu(String menuItem){
        mainSteps.stepSelectMainMenu(menuItem);
    }

    @When("^и в пункте меню \"(.+)\" выбран вид страхования \"(.+)\"$")
    public void stepSelectSubMenu(String point, String menuItem){
        mainSteps.stepSelectSubMenu(point, menuItem);
    }

    @When("^открыта страница \"(.+)\"$")
    public void checkPageTitle(String expectedTitle){
        travelInsuranceSteps.checkPageTitle(expectedTitle);
    }

    @Then("^переход в раздел оформления страховки$")
    public void stepSendAppButton(){
        travelInsuranceSteps.stepSendAppButton();
    }

    @When("^открыто новое окно браузера$")
    public void changeWindow(){
        for (String handle : BaseSteps.getDriver().getWindowHandles()){ //Переключение экрана
            BaseSteps.getDriver().switchTo().window(handle);
        }
    }

    @When("^выбрана сумма страхового вознаграждения$")
    public void selectValueIns(){
        firstStepInsSteps.selectValueIns();
    }

    @Then("^переход по кнопке Далее$")
    public void stepFirstSendAppButton(){
        firstStepInsSteps.stepSendAppButton();
    }

    @When("^заполняются поля:$")
    public void stepFillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> secondStepInsSteps.fillField(field, value));
    }

    @Then("^значения полей равны:$")
    public void stepCheckFillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> secondStepInsSteps.checkFillField(field, value));
    }

    @When("^переход на следующий шаг$")
    public void stepSecondSendAppButton(){
        secondStepInsSteps.stepSendAppButton();
    }

    @Then("^на экране присутствует сообщение об ошибке Заполнены не все обязательные поля$")
    public void checkErrorMessage() {
        secondStepInsSteps.stepCheckFieldErrorMessage();
    }
}
