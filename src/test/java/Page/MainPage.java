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
    private WebElement cityInput1;

    @FindBy(css = "input[data-id=\"avia.search_form.arrival\"]")
    private WebElement cityInput2;

    @FindBy(css = "button.n-Button")
    private WebElement searchButton;

    @FindBy(css = "input[data-id=\"avia.search_form.date\"]")
    private WebElement dataInput1;

    @FindBy(css = "input[data-id=\"avia.search_form.return_date\"]")
    private WebElement dataInput2;

    @FindBy(css = "div.fl-rich-text h1")
    private WebElement ticketsText;

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
        wait.until(ExpectedConditions.elementToBeClickable(cityInput1)).sendKeys(city1);

        cityInput1.click();
        cityInput1.sendKeys(Keys.ENTER);
    }
    @Step(value = "City arrival")
    public void setCity2(String city2) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cityInput2)).sendKeys(city2);

        cityInput2.click();
        cityInput2.sendKeys(Keys.ENTER);
    }

    @Step(value = "Date")
    public void setData1(String data1){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(dataInput1)).sendKeys(data1);
    }
    @Step(value = "Date return")
    public void setData2(String data2){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(dataInput2)).click();

        dataInput2.sendKeys(data2);
    }
    @Step(value = "Button search")
    public void search(){
        ticketsText.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    @Step(value = "Not Found")
    public boolean notFound() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(notFound));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Step(value = "Click on logo")
    public void logoButton()
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , logo);
    }

    @Step(value = "Loading")
    public void successfulLoading() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("https://airlines.aero/"));

    }

    @Step(value = "Click on contact")
    public void contactButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(contact)).click();

        wait.until(ExpectedConditions.urlContains("https://airlines.aero/contact/"));
    }

    @Step(value = "List departure cities")
    public void listDepartureCities(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(listDepartureCities));
    }

    @Step(value = "Calendar")
    public void calendar(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(calendar));
    }



}
