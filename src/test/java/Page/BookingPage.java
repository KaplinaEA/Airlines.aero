package Page;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingPage {
    public WebDriver driver;

    @FindBy(css = "div.AviaBooking")
    private WebElement formBooking;

    @FindBy(css = "div.EmailInput input")
    private WebElement inputEmail;

    @FindBy(css = "div.PhoneInput input")
    private WebElement inputPhone;

    @FindBy(css = "div.RussianPassportInput input")
    private WebElement inputPassport;

    @FindBy(css = "div.AviaBookingFormPassenger__FormField--lastname div.RussianNameInput input")
    private WebElement inputLastName;

    @FindBy(css = "div.AviaBookingFormPassenger__FormField--firstname div.RussianNameInput input")
    private WebElement inputFirstName;

    @FindBy(css = "div.AviaBookingFormPassenger__FormField--middlename div.RussianNameInput input")
    private WebElement inputPatronymic;

    @FindBy(css = "div.DateInput input")
    private WebElement inputBirthday;

    @FindBy(css = "div[gender = \"M\"]")
    private WebElement inputGender;

    @FindBy(css = "span.Checkbox__Inner")
    private WebElement checkMark;

    @FindBy(css = "button.AviaBookingOrderSubmit__Submit__Button")
    private WebElement ButtonBooking;

    @FindBy(css = "div.AviaBookingInsurance")
    private WebElement formInsurance;

    @FindBy(css = "div.AviaBookingProduct")
    private WebElement formBookingProduct;

    @FindBy(css = "div.wpbf-mobile-logo-container a img")
    private WebElement logo;

    @FindBy(css = "div.Alert")
    private WebElement message;

    @FindBy(css = "a[href=\"https://www.aviakassa.com/rules\"]")
    private WebElement websiteTermsUse;

    @FindBy(css = "span.Checkbox__Label  a:nth-child(1)")
    private WebElement fareRules;

    @FindBy(css = "div.Tooltip.is-show")
    private WebElement hiddenMessages;

    @FindBy(css = "div.n-Modal__Header")
    private WebElement modalWindow;

    public BookingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @Step(value = "Loading")
    public boolean loadingPageSuccessful() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(formBooking));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    @Step(value = "Loading additional elements")
    public boolean loadingAdditionalElements(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(formInsurance));
            wait.until(ExpectedConditions.visibilityOf(formBookingProduct));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Step(value = "Email")
    public void setEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(inputEmail));

        inputEmail.sendKeys(email);
    }

    @Step(value = "Phone")
    public void setPhone(String phone) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(inputPhone));

        inputPhone.sendKeys(phone);
    }

    @Step(value = "Passport")
    public void setPassport(String passport) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(inputPassport)).click();

        inputPassport.sendKeys(Keys.HOME,passport, Keys.ENTER, Keys.TAB);
    }

    @Step(value = "LastName")
    public void setLastName(String lastName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(inputLastName)).click();

        inputLastName.sendKeys(lastName, Keys.ENTER);
    }

    @Step(value = "FirstName")
    public void setFirstName(String firstName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(inputFirstName)).click();

        inputFirstName.sendKeys(firstName);
    }

    @Step(value = "Patronymic")
    public void setPatronymic(String patronymic) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(inputPatronymic)).sendKeys(patronymic, Keys.ENTER);
    }

    @Step(value = "Birthday")
    public void setBirthday(String birthday) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(inputBirthday)).click();

        inputBirthday.sendKeys(birthday, Keys.ENTER);
        inputBirthday.click();
    }

    @Step(value = "Gender")
    public void setGender() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(inputGender)).click();
    }
    @Step(value = "Check Mark")
    public void clickCheckMark() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(checkMark)).click();
    }
    @Step(value = "Clicking on the booking")
    public void clickBookingButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ButtonBooking)).click();
    }

    @Step(value = "Click on logo")
    public void clickLogoButton(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , logo);
    }


    @Step(value = "message visibility")
    public void visibleMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(message));

    }

    @Step(value = "Website terms of use")
    public String websiteTermsUse() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(websiteTermsUse)).click();

        return wait.until(ExpectedConditions.visibilityOf(modalWindow)).getText();
    }
    @Step(value = "Fare rules")
    public String fareRules() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(fareRules)).click();

        return wait.until(ExpectedConditions.visibilityOf(modalWindow)).getText();
    }

    @Step(value = "Receiving a passport message")
    public void  receivePassportMessage(){
        inputPassport.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(hiddenMessages));
    }
    @Step(value = "Receive passenger data message")
    public void receivePassengerDataMessage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.cssSelector("div.AviaBookingOrderSubmit__Submit")).click();
        wait.until(ExpectedConditions.visibilityOf(hiddenMessages));
    }

}

