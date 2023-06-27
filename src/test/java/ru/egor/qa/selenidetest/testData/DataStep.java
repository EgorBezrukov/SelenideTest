package ru.egor.qa.selenidetest.testData;

import io.cucumber.java.ru.Пусть;

import static com.codeborne.selenide.Selenide.open;

public class DataStep {

    private TestDataClass testData;

    public DataStep(TestDataClass testData) {
        this.testData = testData;
    }

    @Пусть("^(?:пользователь|он)? открывает сайт")
    public void getUrl(){
        String BaseUrl = testData.getBaseUrl();
        open(BaseUrl);
    }
}
