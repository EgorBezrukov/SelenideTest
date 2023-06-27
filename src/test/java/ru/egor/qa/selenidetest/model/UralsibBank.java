package ru.egor.qa.selenidetest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UralsibBank {

    @JsonProperty("BaseUrl")
    private String baseUrl;
}
