package ru.egor.qa.selenidetest.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;

public class CommonSteps {

    private final ApplicationManager app = new ApplicationManager();

    @И("^(?:пользователь|он)? вводит в поле \"([^\"]*)\" знчение \"([^\"]*)\"$")
    public void input(String fieldName, String fieldValue) {
        app.enterLoginAndPassword(fieldName, fieldValue);
    }

    @И("^(?:пользователь|он)? нажимает на \"([^\"]*)\"$")
    public void clickButton(String btnName) {
        app.button(btnName);
    }

    @Тогда("^(?:пользователь|он)? проверяет что адрес сайта равен \"([^\"]*)\"$")
    public void checkUrl(String currentUrl) {
        app.getUrlAndCheck(currentUrl);
    }



}