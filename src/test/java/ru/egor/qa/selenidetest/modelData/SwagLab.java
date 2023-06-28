package ru.egor.qa.selenidetest.modelData;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class SwagLab {
    public SwagLab() {
    }

    @JsonProperty("BaseUrl")
    private String baseUrl;

    @JsonProperty("Login")
    private String login;

    @JsonProperty("Password")
    private String password;

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public SwagLab(String baseUrl, String login, String password) {
        this.baseUrl = baseUrl;
        this.login = login;
        this.password = password;
    }
}
