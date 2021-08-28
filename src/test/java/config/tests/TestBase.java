package config.tests;

import com.codeborne.selenide.Configuration;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static config.Credentials.credentials;
import static java.lang.String.format;

public class TestBase {
    @BeforeAll
    static void setup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        String login = credentials.login();
        String password = credentials.password();
        String browser = System.getProperty("browser");

        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;
        Configuration.remote = format("https://%s:%s@%s", login, password, browser);
        Configuration.baseUrl = "https://www.tinkoff.ru/";
        Configuration.startMaximized = true;
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
