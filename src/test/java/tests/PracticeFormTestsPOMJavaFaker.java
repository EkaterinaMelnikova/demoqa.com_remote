package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import java.util.Locale;

public class PracticeFormTestsPOMJavaFaker extends TestBase {




    @Test
    void fillPracticeFormTest() {

        practiceFormPage.openPage()
                .setFirstName(testData.userName)
                .setLastName(testData.userlastName)
                .setEmail(testData.userEmail1)
                .setGender(testData.userGender)
                .setPhone(testData.userPhone)
                .setBirthDate(testData.birthDay,testData.birthMonth,testData.birthYear)
                .setSubject(testData.userSubject)
                .setHobbie(testData.userHobbie)
                .setPicture(testData.img)
                .setAddress(testData.userAddress)
                .setState(testData.userState)
                .setCity(testData.userCity)
                .submit();


        practiceFormPage.verifyResultsModalAppear()
                .verifyResult("Student Name", testData.userName + " " + testData.userlastName)
                .verifyResult("Student Email", testData.userEmail1)
                .verifyResult("Gender", testData.userGender)
                .verifyResult("Mobile", testData.userPhone)
                .verifyResult("Date of Birth", testData.birthDate);


    }
}
