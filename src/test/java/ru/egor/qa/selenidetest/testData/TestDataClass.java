package ru.egor.qa.selenidetest.testData;

public class TestDataClass {

    private String BaseUrl;
    private String Login;
    private String Password;

    public TestDataClass() {
    }

    public TestDataClass(String baseUrl, String login, String password) {
        BaseUrl = baseUrl;
        Login = login;
        Password = password;
    }

    public String getBaseUrl() {
        return BaseUrl;
    }

    public String getLogin() {
        return Login;
    }

    public String getPassword() {
        return Password;
    }

    @Override
    public String toString() {
        return "TestDataClass{" +
                "BaseUrl='" + BaseUrl + '\'' +
                ", Login='" + Login + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
