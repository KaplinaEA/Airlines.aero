package Tests;

import Page.BookingPage;
import Page.MainPage;
import Page.ResultPage;
import org.testng.Assert;

public class GeneralPart extends WebDriverSettings {
     MainPage mainPage = new MainPage(driver);
     ResultPage resultPage =  new ResultPage(driver);
     BookingPage bookingPage = new BookingPage(driver);

    public  void step1(String c1, String c2, String d1, String d2){
        mainPage.setCity1(c1);
        mainPage.setCity2(c2);
        mainPage.setData1(d1);
        mainPage.setData2(d2);
        mainPage.search();
    }
    public  void step2(){
        resultPage.clickFirstPrice();
    }
    public  void step3(String email, String phone, String passport,
                             String lastName, String firstName, String patronymic, String birthday){
        bookingPage.setEmail(email);
        bookingPage.setPhone(phone);
        bookingPage.setPassport(passport);
        bookingPage.setLastName(lastName);
        bookingPage.setFirstName(firstName);
        bookingPage.setPatronymic(patronymic);
        bookingPage.setBirthday(birthday);
        bookingPage.setGender();
        bookingPage.clickCheckMark();

        Assert.assertTrue(bookingPage.loadingAdditionalElements());
        bookingPage.clickBookingButton();
    }
}
