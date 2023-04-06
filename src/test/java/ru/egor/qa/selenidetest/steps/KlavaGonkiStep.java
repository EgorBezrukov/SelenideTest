package ru.egor.qa.selenidetest.steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class KlavaGonkiStep {
    private final SelenideElement closeWindowButton = $x("//input[@value'Закрыть'");
    private final SelenideElement startGameButton = $x("//a[@id='host_start']");
    private final SelenideElement highlightWord = $x(" //span[@id='typefocus']");
    private final SelenideElement inputField = $x(" //input[@id='inputtext']");
    private final SelenideElement afterFocusWord = $x(" //span[@id='afterfocus']");
    private final SelenideElement resultText = $x(" //span[@id='afterfocus']");

    private String getCurrentWord(){
        return highlightWord.getText().replaceAll("с", "c").replaceAll("о", "o");
    }
    @Когда("начинаем игру")
    public void startGame() {
        closeWindowButton.click();
        if (startGameButton.isDisplayed()) {
            startGameButton.click();
        }
    }

    @И("ждем начала игры")
    public void waiForStartGame() {
        highlightWord.click();
    }

    @И("вводим подсвеченное слово в цикле")
    public void playGame() {
        while (true){
            String currentWord = getCurrentWord();
            String afterFocusSymbol = afterFocusWord.getText();
            inputField.sendKeys(currentWord);
            if (afterFocusSymbol.equals(".")){
                inputField.sendKeys(".");
                break;
            }
            inputField.sendKeys(Keys.SPACE);
        }
    }

    @Тогда("фиксируем что игра завершена и символов в минуту больше чем {int}")
    public void endGame(int minValue) {
        String result = resultText.getText();
        int resulNumber = Integer.parseInt(result);
        System.out.println("Колличесво знаков в минуту " + resulNumber);
        Assertions.assertTrue(resulNumber>minValue, "Актуальный результат = " + resulNumber);
    }
}
