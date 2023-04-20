package ru.egor.qa.selenidetest.steps;

import io.cucumber.java.bg.И;

public class TreeStepsDef {

    public TreeStepsDef(){}

    @И("^h(\\d+)\s((.+))$")
    public void treeRow(int nodeLevel, String nodeName){
        System.out.println(String.format("Шаг %d - %s", nodeLevel, nodeName));
    }
}
