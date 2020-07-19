package Tests;


import Page.BookingPage;
import Page.MainPage;
import Page.Menu;
import Page.ResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CriticalTest extends WebDriverSettings {

    MainPage mainPage;
    ResultPage resultPage;
    BookingPage bookingPage;
    GeneralPart generalPart;
    Menu menu;

    @BeforeMethod
    public void openFBPage() {
        driver.get("https://airlines.aero/");
        mainPage = new MainPage(driver);
        resultPage = new ResultPage(driver);
        bookingPage =  new BookingPage(driver);
        menu = new Menu(driver);
        generalPart = new GeneralPart();
    }

   @Test
    public void c1(){
        mainPage.logoButton();
        mainPage.successfulLoading();
    }
    @Test(dataProvider = "Data-Main-Page")
    public void c2(String c1, String c2, String d1, String d2){
        generalPart.step1(c1,c2,d1,d2);

        resultPage.logoButton();
        mainPage.successfulLoading();
    }
    @Test(dataProvider = "Data-Main-Page")
    public void c3(String c1, String c2, String d1, String d2){
        generalPart.step1(c1,c2,d1,d2);
        generalPart.step2();

        bookingPage.logoButton();
        mainPage.successfulLoading();
    }
    @DataProvider(name = "Data-Main-Page")
    public  static Object[][] dataForMainPage (){
        return new Object[][]{
                new String[]{"Самара", "Москва", "12122020", "14122020"}
        };
    }



    @Test
    public void c4(){
        menu.menuButton();
        menu.aircompanyButton();
    }
    @Test
    public void c5(){
        menu.menuButton();
        menu.aeroportyButton();
    }
    @Test
    public void c6(){
        menu.menuButton();
        menu.bagazButton();
    }
    @Test
    public void c7(){
        menu.menuButton();
        menu.newsButton();
    }
    @Test
    public void c8(){
        menu.menuButton();
        menu.transferButton();
    }
    @Test
    public void c9(){
        menu.menuButton();
        menu.toursButton();
    }
    @Test
    public void c10(){
        menu.menuButton();
        menu.reviewsButton();
    }
    @Test
    public void c11(){
        menu.menuButton();
        menu.hotelButton();
    }


    @Test(dataProvider = "Data-Main-Page")
    public void c18(String c1, String c2, String d1, String d2){
        generalPart.step1(c1,c2,d1,d2);
        generalPart.step2();

        bookingPage.clickCheckMark();
        bookingPage.message();

    }
    @Test(dataProvider = "Data-Main-Page")
    public void c20(String c1, String c2, String d1, String d2){
        generalPart.step1(c1,c2,d1,d2);
        generalPart.step2();

        Assert.assertEquals(bookingPage.fareRules(), "Правила тарифа");
    }
    @Test(dataProvider = "Data-Main-Page")
    public void c21(String c1, String c2, String d1, String d2){
        generalPart.step1(c1,c2,d1,d2);
        generalPart.step2();

      Assert.assertEquals(bookingPage.websiteTermsUse(), "Правила пользования сайтом");

    }
    @Test
    public  void c22(){
        mainPage.contactButton();
        driver.findElement(By.xpath("//p[contains(text(), '+7(495) 970-17-17')]"));
    }
    @Test
    public  void c23(){
        mainPage.contactButton();
        driver.findElement(By.xpath("//p[contains(text(), 'info@airlines.aero')]"));
    }

    @Test
    public void c12(){
        mainPage.setCity1("А");
        mainPage.listDepartureCities();
    }
    @Test
    public void c13(){
        mainPage.setCity2("А");
        mainPage.listDepartureCities();
    }
        @Test
    public void c14(){
        mainPage.setData1("");
        mainPage.calendar();
    }
    @Test
    public void c15(){
        mainPage.setData2("");
        mainPage.calendar();
    }

    @Test(dataProvider = "Data-Main-Page")
    public void c19(String c1, String c2, String d1, String d2){
        generalPart.step1(c1,c2,d1,d2);
        generalPart.step2();
        bookingPage.successfulLoading();

        bookingPage.passportMessage();
    }

    @Test(dataProvider = "Data-Main-Page")
    public void c17(String c1, String c2, String d1, String d2){
        generalPart.step1(c1,c2,d1,d2);
        generalPart.step2();
        bookingPage.successfulLoading();

        bookingPage.passengerDataMessage();
    }

    @Test(dataProvider = "Data-Main-Page")
    public void c16(String c1, String c2, String d1, String d2){
        generalPart.step1(c1,c2,d1,d2);
        resultPage.filter();
    }
}

