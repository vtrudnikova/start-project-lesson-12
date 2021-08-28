package config.tests;

import config.tests.ru.paragon.pages.ParagonMainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParagonTests {
    ParagonMainPage startPage = new ParagonMainPage();

    @Test()
    @DisplayName("Невозможность логина незарегистрированным пользователем")
    void impossibilityOfRegistrationUnregisteredUsers() {
        startPage.openPage();
        startPage.enterEmail("test@test.com");
        startPage.enterPassword("Qwerty127");
        startPage.pressSubmit();
        startPage.checkTitleForUnregisteredUser();
    }

    @Test()
    @DisplayName("Невозможность логина c некорректным email")
    void impossibilityOfLoginWithIncorrectEmail() {
        startPage.openPage();
        startPage.enterEmail("test@test9re.com");
        startPage.enterPassword("Qwerty111");
        startPage.pressSubmit();
        startPage.checkTitleForLoginWithIncorrectEmail();
    }

    @Test()
    @DisplayName("Невозможность логина c некорректным email")
    void checkLocalizationСhange() {
        startPage.openPage();
        startPage.changesLocalization();
        startPage.checkTitleAuthorizations();
    }

    @Test()
    @DisplayName("Можно вернуться к форме авторизации со страницы восстановления пароля")
    void returnToAuthorizationPageFromTheResetPasswordPage() {
        startPage.openPage();
        startPage.pressGoToResetPassword();
        startPage.pressEnterReturnToSignIn();
        startPage.checkMessage();
    }

    @Test()
    @DisplayName("На странице логина есть ссылка Войти")
    void theLoginPageContainsTheLoginLink() {
        startPage.openPage();
        String link = startPage.checkLinkLogin();
        assertThat(link).isEqualTo("#/login");

    }
}