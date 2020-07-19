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
    private WebElement BookingForm;

    @FindBy(css = "div.EmailInput input")
    private WebElement emailInput;

    @FindBy(css = "div.PhoneInput input")
    private WebElement phoneInput;

    @FindBy(css = "div.RussianPassportInput input")
    private WebElement passportInput;

    @FindBy(css = "div.AviaBookingFormPassenger__FormField--lastname div.RussianNameInput input")
    private WebElement lastNameInput;

    @FindBy(css = "div.AviaBookingFormPassenger__FormField--firstname div.RussianNameInput input")
    private WebElement firstNameInput;

    @FindBy(css = "div.AviaBookingFormPassenger__FormField--middlename div.RussianNameInput input")
    private WebElement patronymicInput;

    @FindBy(css = "div.DateInput input")
    private WebElement birthdayInput;

    @FindBy(css = "div[gender = \"M\"]")
    private WebElement genderInput;

    @FindBy(css = "span.Checkbox__Inner")
    private WebElement checkMark;

    @FindBy(css = "button.AviaBookingOrderSubmit__Submit__Button")
    private WebElement bookingButton;

    @FindBy(css = "div.AviaBookingInsurance")
    private WebElement insuranceForm;

    @FindBy(css = "div.AviaBookingProduct")
    private WebElement bookingProductForm;

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



    public BookingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.n-Modal__Header")
    private WebElement modalWindow;

    @Step(value = "Loading")
    public boolean successfulLoading() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(BookingForm));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    @Step(value = "Loading additional elements")
    public boolean additionalElements(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(insuranceForm));
            wait.until(ExpectedConditions.visibilityOf(bookingProductForm));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Step(value = "Email")
    public void setEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(emailInput));

        emailInput.sendKeys(email);
    }

    @Step(value = "Phone")
    public void setPhone(String phone) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(phoneInput));

        phoneInput.sendKeys(phone);
    }

    @Step(value = "Passport")
    public void setPassport(String passport) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(passportInput)).click();

        passportInput.sendKeys(Keys.HOME,passport, Keys.ENTER, Keys.TAB);
    }

    @Step(value = "LastName")
    public void setLastName(String lastName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(lastNameInput)).click();

        lastNameInput.sendKeys(lastName, Keys.ENTER);
    }

    @Step(value = "FirstName")
    public void setFirstName(String firstName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(firstNameInput)).click();

        firstNameInput.sendKeys(firstName);
    }

    @Step(value = "Patronymic")
    public void setPatronymic(String patronymic) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(patronymicInput)).sendKeys(patronymic, Keys.ENTER);
    }

    @Step(value = "Birthday")
    public void setBirthday(String birthday) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(birthdayInput)).click();

        birthdayInput.sendKeys(birthday, Keys.ENTER);
        birthdayInput.click();

    }

    @Step(value = "Gender")
    public void setGender() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(genderInput)).click();
    }
    @Step(value = "Check Mark")
    public void clickCheckMark() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(checkMark)).click();
    }
    @Step(value = "Clicking on the booking")
    public void clickBookingButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(bookingButton)).click();
    }

    @Step(value = "Click on logo")
    public void logoButton(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , logo);
    }


    @Step(value = "message visibility")
    public void message() {
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

    @Step(value = "Passport message")
    public void passportMessage(){
        passportInput.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(hiddenMessages));

    }
    @Step(value = "Passenger data message")
    public void passengerDataMessage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.cssSelector("div.AviaBookingOrderSubmit__Submit")).click();
        wait.until(ExpectedConditions.visibilityOf(hiddenMessages));
    }

}

