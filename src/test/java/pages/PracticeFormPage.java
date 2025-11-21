package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal  = new RegistrationResultsModal();


    private final String titleText ="Practice Form";

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            dateOfBirthInput = $("#dateOfBirthInput");

    public PracticeFormPage openPage(){
        open("/automation-practice-form");
        $(".text-center").shouldHave(text(titleText));
//        executeJavaScript("$('#fixedban').remove()");
//        executeJavaScript("$('footer').remove()");

        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage setEmail(String value){
        $("#userEmail").setValue(value); // доработать

        return this;
    }

    public PracticeFormPage setGender(String value){
        $("#genterWrapper").$(byText(value)).click(); // доработать

        return this;
    }

    public PracticeFormPage setPhone(String value){
        $("#userNumber").setValue(value);// доработать

        return this;
    }

    public PracticeFormPage setBirthDate(String day, String month, String year){
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }


    public PracticeFormPage setSubject(String value){
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage setHobbie(String value){
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }


    public PracticeFormPage setPicture(String value){
        $("#uploadPicture").uploadFromClasspath(value);

        return this;
    }

    public PracticeFormPage setAddress(String value){
        $("#currentAddress").setValue(value);

        return this;
    }

    public PracticeFormPage setState(String value){
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;
    }

    public PracticeFormPage setCity(String value){
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;
    }

    public PracticeFormPage submit(){
        $("#submit").click();

        return this;
    }



    public PracticeFormPage verifyResultsModalAppear(){
        RegistrationResultsModal.verifyModalAppears();// доработать

        return this;
    }


    public PracticeFormPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }


}
