package Page;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    public WebDriver driver;

    @FindBy(css = "input[data-id=\"avia.search_form.from\"]")
    private WebElement inputCity1;

    @FindBy(css = "input[data-id=\"avia.search_form.arrival\"]")
    private WebElement inputCity2;

    @FindBy(css = "button.n-Button")
    private WebElement buttonSearch;

    @FindBy(css = "input[data-id=\"avia.search_form.date\"]")
    private WebElement inputData1;

    @FindBy(css = "input[data-id=\"avia.search_form.return_date\"]")
    private WebElement inputData2;

    @FindBy(css = "div.fl-rich-text h1")
    private WebElement textTickets;

    @FindBy(css = "span[data-id=\"avia.search_form.alert\"]")
    private WebElement notFound;

    @FindBy(css = "div.wpbf-mobile-logo-container a img")
    private WebElement logo;

    @FindBy(css = "a[href=\"https://airlines.aero/contact/\"]")
    private WebElement contact;

    @FindBy(css = "div.DropdownSelect__Item")
    private WebElement listDepartureCities;

    @FindBy(css = "div.Calendar")
    private WebElement calendar;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @Step(value = "City from")
    public void setCity1(String city1) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(inputCity1)).sendKeys(city1);

        inputCity1.click();
        inputCity1.sendKeys(Keys.ENTER);
    }
    @Step(value = "City arrival")
    public void setCity2(String city2) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(inputCity2)).sendKeys(city2);

        inputCity2.click();
        inputCity2.sendKeys(Keys.ENTER);
    }

    @Step(value = "Date")
    public void setData1(String data1){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(inputData1)).sendKeys(data1);
    }
    @Step(value = "Date return")
    public void setData2(String data2){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(inputData2)).click();

        inputData2.sendKeys(data2);
    }
    @Step(value = "Button search")
    public void search(){
        textTickets.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(buttonSearch)).click();
    }

    @Step(value = "Not found results")
    public boolean notFoundResults() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(notFound));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Step(value = "Click on logo")
    public void clickLogoButton()
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , logo);
    }

    @Step(value = "Loading")
    public void loadingPageSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("https://airlines.aero/"));

    }

    @Step(value = "Click on contact")
    public void clickContactButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(contact)).click();

        wait.until(ExpectedConditions.urlContains("https://airlines.aero/contact/"));
    }

    @Step(value = "Visible list departure cities")
    public void visibleListDepartureCities(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(listDepartureCities));
    }

    @Step(value = "Calendar")
    public void visibleCalendar(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(calendar));
    }



}
