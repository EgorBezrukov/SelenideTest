package ru.egor.qa.selenidetest.modelData;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class TestData {
    public TestData() {
    }

    @JsonProperty("SwagLab")
    private SwagLab swagLab;

    @JsonProperty("UralsibBank")
    private UralsibBank uralsibBank;

    public SwagLab getSwagLab() {
        return swagLab;
    }

    public UralsibBank getUralsibBank() {
        return uralsibBank;
    }

    public TestData(SwagLab swagLab, UralsibBank uralsibBank) {
        this.swagLab = swagLab;
        this.uralsibBank = uralsibBank;
    }
}
