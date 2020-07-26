package Tests;


import Page.BookingPage;
import Page.MainPage;
import Page.Menu;
import Page.ResultPage;
import org.openqa.selenium.By;
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
    public void clickLogoOnMainPage(){
        mainPage.clickLogoButton();
        mainPage.loadingPageSuccessful();
    }
    @Test(dataProvider = "Data-Main-Page")
    public void clickLogoOnResultPage(String c1, String c2, String d1, String d2){
        generalPart.step1(c1,c2,d1,d2);

        resultPage.clickLogoButton();
        mainPage.loadingPageSuccessful();
    }
    @Test(dataProvider = "Data-Main-Page")
    public void clickLogoOnBookingPage(String c1, String c2, String d1, String d2){
        generalPart.step1(c1,c2,d1,d2);
        generalPart.step2();

        bookingPage.clickLogoButton();
        mainPage.loadingPageSuccessful();
    }
    @DataProvider(name = "Data-Main-Page")
    public  static Object[][] dataForMainPage (){
        return new Object[][]{
                new String[]{"Самара", "Москва", "12122020", "14122020"}
        };
    }



    @Test
    public void openMenuAndSelectAircompany(){
        menu.clickMenuButton();
        menu.clickAircompanyButton();
    }
    @Test
    public void openMenuAndSelectAeroporty(){
        menu.clickMenuButton();
        menu.clickAeroportyButton();
    }
    @Test
    public void openMenuAndSelectBagaz(){
        menu.clickMenuButton();
        menu.clickBagazButton();
    }
    @Test
    public void openMenuAndSelectNews(){
        menu.clickMenuButton();
        menu.clickNewsButton();
    }
    @Test
    public void openMenuAndSelectTransfer(){
        menu.clickMenuButton();
        menu.clickTransferButton();
    }
    @Test
    public void openMenuAndSelectTours(){
        menu.clickMenuButton();
        menu.clickToursButton();
    }
    @Test
    public void openMenuAndSelectReviews(){
        menu.clickMenuButton();
        menu.clickReviewsButton();
    }
    @Test
    public void openMenuAndSelectHotel(){
        menu.clickMenuButton();
        menu.clickHotelButton();
    }


    @Test(dataProvider = "Data-Main-Page")
    public void checkMarkWithoutFillFieldsOnBookingPage(String c1, String c2, String d1, String d2){
        generalPart.step1(c1,c2,d1,d2);
        generalPart.step2();

        bookingPage.clickCheckMark();
        bookingPage.visibleMessage();

    }
    @Test(dataProvider = "Data-Main-Page")
    public void clickLinkTariffRulesOnBookingPage(String c1, String c2, String d1, String d2){
        generalPart.step1(c1,c2,d1,d2);
        generalPart.step2();

        Assert.assertEquals(bookingPage.fareRules(), "Правила тарифа");
    }
    @Test(dataProvider = "Data-Main-Page")
    public void clickLinkRulesUseWebsiteOnBookingPage(String c1, String c2, String d1, String d2){
        generalPart.step1(c1,c2,d1,d2);
        generalPart.step2();

      Assert.assertEquals(bookingPage.websiteTermsUse(), "Правила пользования сайтом");

    }
    @Test
    public  void findTelephoneNumberOnContactsPage(){
        mainPage.clickContactButton();
        driver.findElement(By.xpath("//p[contains(text(), '+7(495) 970-17-17')]"));
    }
    @Test
    public  void findEmailOnContactsPage(){
        mainPage.clickContactButton();
        driver.findElement(By.xpath("//p[contains(text(), 'info@airlines.aero')]"));
    }

    @Test
    public void enterOneLetterInSenderCity(){
        mainPage.setCity1("А");
        mainPage.visibleListDepartureCities();
    }
    @Test
    public void enterOneLetterInArrivalCity(){
        mainPage.setCity2("А");
        mainPage.visibleListDepartureCities();
    }
        @Test
    public void standOnFieldDateThither(){
        mainPage.setData1("");
        mainPage.visibleCalendar();
    }
    @Test
    public void standOnFieldDateBackward(){
        mainPage.setData2("");
        mainPage.visibleCalendar();
    }

    @Test(dataProvider = "Data-Main-Page")
    public void EnterFieldDocumentNumberOnBookingPage(String c1, String c2, String d1, String d2){
        generalPart.step1(c1,c2,d1,d2);
        generalPart.step2();
        bookingPage.loadingPageSuccessful();

        bookingPage.receivePassportMessage();
    }

    @Test(dataProvider = "Data-Main-Page")
    public void goToPaymentWithoutFillingInFieldsOnBookingPage(String c1, String c2, String d1, String d2){
        generalPart.step1(c1,c2,d1,d2);
        generalPart.step2();
        bookingPage.loadingPageSuccessful();

        bookingPage.receivePassengerDataMessage();
    }

    @Test(dataProvider = "Data-Main-Page")
    public void changeFilterOnResultsPage(String c1, String c2, String d1, String d2){
        generalPart.step1(c1,c2,d1,d2);
        resultPage.changeFilter();
    }
}

