package ru.egor.qa.selenidetest.steps;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import ru.egor.qa.selenidetest.elements.KlavaGonkiPageElements;

public class KlavaGonkiStep extends KlavaGonkiPageElements {


    private String getCurrentWord() {
        return highlightWord.getText().replaceAll("c", "с").replaceAll("o", "о");
    }

    @Когда("^(?:пользователь|он)? начинает игру$")
    public void startGame() {
        closeWindowButton.click();
        if (startGameButton.isDisplayed()) {
            startGameButton.click();
        }
    }

    @И("^(?:пользователь|он)? ждет начала игры$")
    public void waiForStartGame() {
        highlightWord.click();
    }

    @И("^(?:пользователь|он)? вводит подсвеченное слово в цикле$")
    public void playGame() {
        while (true) {
            String currentWord = getCurrentWord();
            String afterFocusSymbol = afterFocusWord.getText();
            inputField.sendKeys(currentWord);
            if (afterFocusSymbol.equals(".")) {
                inputField.sendKeys(".");
                break;
            }
            inputField.sendKeys(Keys.SPACE);
        }
    }

    @Тогда("^(?:пользователь|он)? фиксирует, что игра завершена и символов в минуту больше чем \"([^\"]*)\"$")
    public void endGame(int minValue) {
        String result = resultText.getText();
        int resulNumber = Integer.parseInt(result);
        System.out.println("Колличесво знаков в минуту " + resulNumber);
        Assertions.assertTrue(resulNumber > minValue, "Актуальный результат = " + resulNumber);
    }


    @Тогда("Запускается быстрая игра")
    public void fastGameStart() {
        fastGameButton.click();
        if (startGameButton.isDisplayed()) {
            startGameButton.click();
        }
    }
}
