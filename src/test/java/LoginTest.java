import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
  //  @Test
    void successfulLoginTest() {
        Configuration.holdBrowserOpen = true; //Это для не закрытия браузера после теста
     //   Configuration.browser = "firefox";
     //   Configuration.browserSize = "1000x300"; // установка разрешения браузера

        //      Открыть форму авторизации https://qa.guru/cms/system/login
        //      Ввести адрес электронной почты
        //      Ввести пароль
        //      Нажать кнопку "Войти"
        //      Нажать кнопку "личный кабинет"
        //      Проверить успешную авторизацию
 //     Открыть форму авторизации https://qa.guru/cms/system/login
        open("https://qa.guru/cms/system/login");
 //     Ввести адрес электронной почты
        $("[name=email]").setValue("fobozzz@yandex.ru");
 //     Ввести пароль
        $("[name=password]").setValue("33p4AC&A");
 //     Нажать кнопку "Войти"
        $("[class='xdget-block xdget-button btn btn-success']").click();
 //     $(".btn-success").click();   //- второй вариант поиска локатора
 //     Нажать кнопку "личный кабинет"
        $("[class='main-header__login']").click();
 //     $(".main-header__login").click();  //- второй вариант поиска локатора
 //     Проверить успешную авторизацию
 //     $("[class='xdget-block xdget-fixedContainer logined-form state-form xdget-common-container active-state div']").shouldHave(text("Здравствуйте, Artur"));
        $(".logined-form").shouldHave(text("Здравствуйте, Artur"));
    }

 //   @Test
    void negativeLoginTest() {
        Configuration.holdBrowserOpen = true; //Это для не закрытия браузера после теста
     //   Configuration.browser = "firefox";
     //   Configuration.browserSize = "1000x300";

        open("https://qa.guru/cms/system/login");
        $("[name=email]").setValue("fobozzz@yandex.ru");
        $("[name=password]").setValue("33p4AC&A4343434");
        $("[class='xdget-block xdget-button btn btn-success']").click();
        //     $(".btn-success").click();   //- второй вариант поиска локатора
        //$("[class='main-header__login']").click();
        //     $(".main-header__login").click();  //- второй вариант поиска локатора
        //     $("[class='xdget-block xdget-fixedContainer logined-form state-form xdget-common-container active-state div']").shouldHave(text("Здравствуйте, Artur"));
        $(".btn-success").shouldHave(text("Неверный пароль"));
    }

    @Test //такое исполнение делает последовательность тестов
    public void test()    {
        negativeLoginTest();
        successfulLoginTest();
    }

}

