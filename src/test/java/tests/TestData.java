package tests;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class TestData {

    Faker faker = new Faker();
    //Faker faker = new Faker(new Locale("ru"));

    String userName = faker.name().firstName(); // Emory
    String userlastName = faker.name().lastName(); // Barton
    String userEmail1 = faker.internet().emailAddress();
    String userGender = faker.options().option("Male", "Female", "Other");
    String userPhone = faker.phoneNumber().subscriberNumber(10);
    String birthYear = faker.number().numberBetween(1940,2005) + "";
    String birthMonth = faker.options().option("January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December");
    String birthDay = setRandomDay(birthMonth, birthYear);
    String birthDate = birthDay + " " + birthMonth + "," + birthYear;
    String userSubject = faker.options().option("History", "Arts", "Biology", "Maths", "Commerce", "Social Studies", "Civics", "Hindi");
    String userHobbie = faker.options().option("Sports", "Reading", "Music");
    String img = "img/1.png";
    String userAddress = faker.address().streetAddress();
    String userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    String userCity = setRandomCity(userState);




    public String setRandomDay(String birthMonth, String birthYear){
        int day;
        int year = Integer.parseInt(birthYear);
        if (birthMonth.equals("January") || birthMonth.equals("March") || birthMonth.equals("May") || birthMonth.equals("July")
                || birthMonth.equals("August") || birthMonth.equals("October") || birthMonth.equals("December")) {
            day = faker.number().numberBetween(1,31);
        } else if (birthMonth.equals("April") || birthMonth.equals("June") || birthMonth.equals("September")
                || birthMonth.equals("November")) {
            day = faker.number().numberBetween(1,30);
        } else if ((year % 100 == 0 && year % 400 == 0) || (year % 4 == 0 && year % 100 > 0) ){
            day = faker.number().numberBetween(1,29);
        } else {
            day = faker.number().numberBetween(1,28);
        }

        if (day < 10) {
            return "0" + day;
        }
        else {
            return day + "";
        }
    }

    public String setRandomCity (String state){
        String city;
        ArrayList<String> values = new ArrayList<>();
        switch (state) {
            case "NCR":
                Collections.addAll(values,"Delhi", "Gurgaon", "Noida");
                city = values.get(faker.random().nextInt(0,values.size()-1));
                break;
            case "Uttar Pradesh":
                Collections.addAll(values,"Agra", "Lucknow", "Merrut");
                city = values.get(faker.random().nextInt(0,values.size()-1));
                break;
            case "Haryana":
                Collections.addAll(values,"Karnal", "Panipat");
                city = values.get(faker.random().nextInt(0,values.size()-1));
                break;
            case "Rajasthan":
                Collections.addAll(values,"Jaipur", "Jaiselmer");
                city = values.get(faker.random().nextInt(0,values.size()-1));
                break;
            default:
                city = null;
                break;
        }
        return city;
    }
}






