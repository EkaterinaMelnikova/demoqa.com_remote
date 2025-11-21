package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTestsPOM extends TestBase {

    PracticeFormPage practiceFormPage= new PracticeFormPage();


    @Test
    void fillPracticeFormTest() {

        String userName="Ekaterina";
        String userlastName = "Melnikova";
        String userEmail1 = "meme@gmail.com";
        String userGender = "Female";
        String userPhone = "1234567890";
        String birthYear = "2011";
        String birthMonth = "July";
        String birthDay = "07";
        String birthDate = birthDay + " " + birthMonth + "," + birthYear;
        String userSubject = "Math";
        String userHobbie = "Reading";
        String img = "img/1.png";
        String userAddress = "Address 123";
        String userState = "NCR";
        String userCity = "Delhi";



        practiceFormPage.openPage()
                .setFirstName(userName)
                .setLastName(userlastName)
                .setEmail(userEmail1)
                .setGender(userGender)
                .setPhone(userPhone)
                .setBirthDate(birthDay,birthMonth,birthYear)
                .setSubject(userSubject)
                .setHobbie(userHobbie)
                .setPicture(img)
                .setAddress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .submit();


        practiceFormPage.verifyResultsModalAppear()
                .verifyResult("Student Name", userName + " " + userlastName)
                .verifyResult("Student Email", userEmail1)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userPhone)
                .verifyResult("Date of Birth", birthDate);


    }
}
