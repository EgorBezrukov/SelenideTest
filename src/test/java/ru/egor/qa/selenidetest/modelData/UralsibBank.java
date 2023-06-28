package ru.egor.qa.selenidetest.modelData;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class UralsibBank {

    @JsonProperty("BaseUrl")
    private String baseUrl;

    public UralsibBank(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public UralsibBank() {
    }
}
