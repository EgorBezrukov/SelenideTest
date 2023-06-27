package ru.egor.qa.selenidetest.utils;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AllureUtils {

    private static final Logger log = LogManager.getLogger();

    public static void addScreenShot(String massage){
        try {
            Allure.getLifecycle().addAttachment(massage,"image/png", "png", new FileInputStream(Screenshots.takeScreenShotAsFile()));
        } catch (FileNotFoundException e) {
            String logMessage = String.format("Ошибка при добавление скриншота. Исключение: %s", e.getMessage());
            log.error(logMessage);
            addLog(logMessage);
        }
    }

    public static void addLog(String massage){
        Allure.step(massage);
    }
}
