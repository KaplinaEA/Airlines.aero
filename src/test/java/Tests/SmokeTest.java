package Tests;
import Page.BookingPage;
import Page.MainPage;
import Page.PaymentPage;
import Page.ResultPage;
import org.testng.Assert;
import org.testng.annotations.*;


public class SmokeTest extends WebDriverSettings {

    MainPage mainPage;
    ResultPage resultPage;
    BookingPage bookingPage;
    PaymentPage paymentPage;
    GeneralPart generalPart;



    @BeforeMethod
    public void openFBPage() {
        driver.get("https://airlines.aero/");
        mainPage = new MainPage(driver);
        resultPage = new ResultPage(driver);
        bookingPage = new BookingPage(driver);
        paymentPage = new PaymentPage(driver);
        generalPart = new GeneralPart();
    }



    @Test(dataProvider = "Data-Main-Page")
    public void s1(String c1, String c2, String d1, String d2){
        generalPart.step1(c1,c2,d1,d2);

        if(!mainPage.notFound())
            Assert.assertTrue(resultPage.successfulLoading());
    }
    @DataProvider(name = "Data-Main-Page")
    public  static Object[][] dataForMainPage (){
        return new Object[][]{
                new String[]{"Самара", "Москва", "12122020", "14122020"},
                new String[]{"Терней","Мерзифон","30082020","30092020"}
        };
    }



    @Test(dataProvider = "Data-Result-Page")
    public void s2(String c1, String c2, String d1, String d2){
        generalPart.step1(c1,c2,d1,d2);
        generalPart.step2();
        Assert.assertTrue(bookingPage.successfulLoading());
    }
    @DataProvider(name = "Data-Result-Page")
    public  static Object[][] dataForREsultPage (){
        return new Object[][]{
                new String[]{"Самара", "Москва", "12122020", "14122020"}
        };
    }



    @Test(dataProvider = "Data-Booking-Page")
    public void s3(String c1,String c2, String d1, String d2,
                   String email, String phone,
                   String passport, String lastName, String firstName, String patronymic, String birthday) {
        generalPart.step1(c1,c2,d1,d2);
        generalPart.step2();
        generalPart.step3(email,phone,passport,lastName,firstName,patronymic,birthday);

        Assert.assertTrue(paymentPage.successfulLoading());
    }
    @DataProvider(name = "Data-Booking-Page")
    public  static Object[][] dataForBookingPage (){
        return new Object[][]{
                new String[]{
                        "Самара", "Москва", "12122020", "14122020",
                        "user@mail.ru","9999999999",
                        "6313585969","Ivanov", "Ivan", "IVANOVICH", "12121987"}
        };
    }
}





