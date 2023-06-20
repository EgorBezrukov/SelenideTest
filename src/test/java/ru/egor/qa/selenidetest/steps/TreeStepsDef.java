package ru.egor.qa.selenidetest.steps;

import io.cucumber.java.bg.И;

public class TreeStepsDef {

    public TreeStepsDef() {
    }

    @И("^h(\\d+)(\\(.+\\))$")
    public void treeRow(int nodeLevel, String nodeName) {
        System.out.printf("Шаг %d - %s%n", nodeLevel, nodeName);
    }
}
