package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void fillTextFormTest() {
        open("/text-box");

        $(".text-center").shouldHave(text("Text Box"));  //<h1 class="text-center">Text Box</h1>

        $("#userName").setValue("Melnikova Ekaterina");
        $("#userEmail").setValue("meme@gmail.com");
        $("#currentAddress").setValue("SPb, Kushelevskaya, 3");
        $("#permanentAddress").setValue("SPb, Kushelevskaya, 3-11");
        $("#submit").click();

        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave(text("Melnikova Ekaterina"));
        //$("#output #name").shouldHave(text("Melnikova Ekaterina")); //вариант 2
        $("#output").$("#email").shouldHave(text("meme@gmail.com"));
        $("#output").$("#currentAddress").shouldHave(text("SPb, Kushelevskaya, 3"));
        $("#output").$("#permanentAddress").shouldHave(text("SPb, Kushelevskaya, 3-11"));




    }
}
