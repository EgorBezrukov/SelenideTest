package ru.egor.qa.selenidetest.commonsteps;

import io.cucumber.java.bg.И;

public class TreeStepsDefs {

    public TreeStepsDefs(){}

    @И("^h(\\d+)\s(.+)$")
    public void treeRow(int nodeLevel, String nodeName){
        System.out.println(String.format("Шаг %d - %s", nodeLevel, nodeName));
    }
}
