package Page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Menu {
    public WebDriver driver;

    @FindBy(css = "div.wpbf-menu-toggle-container button")
    private WebElement menu;
    @FindBy(css = "a[href = \"https://airlines.aero/aeroporty/\"]")
    private WebElement aeroporty;
    @FindBy(css = "a[href = \"https://airlines.aero/aircompany/\"]")
    private WebElement aircompany;
    @FindBy(css = "a[href =\"https://airlines.aero/category/bagaz/\"]")
    private WebElement bagaz;
    @FindBy(css = "a[href =\"https://airlines.aero/category/news/\"]")
    private WebElement news;
    @FindBy(css = "a[href=\"https://go.airlines.aero/O\"]")
    private WebElement transfer;
    @FindBy(css = "a[href=\"https://go.airlines.aero/2\"]")
    private WebElement tours;
    @FindBy(css = "a[href=\"https://airlines.aero/reviews/\"]")
    private WebElement reviews;
    @FindBy(css = "a[href=\"https://go.airlines.aero/1\"]")
    private WebElement hotel;



    public Menu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step(value = "Click on menu")
    public void menuButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(menu)).click();
    }

    @Step(value = "Click on aeroporty")
    public void aeroportyButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(aeroporty)).click();
        wait.until(ExpectedConditions.urlContains("https://airlines.aero/aeroporty/"));
    }

    @Step(value = "Click on aircompany")
    public void aircompanyButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(aircompany)).click();
        wait.until(ExpectedConditions.urlContains("https://airlines.aero/aircompany/"));
    }
    @Step(value = "Click on bagaz")
    public void bagazButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(bagaz)).click();
        wait.until(ExpectedConditions.urlContains("https://airlines.aero/category/bagaz/"));
    }
    @Step(value = "Click on news")
    public void newsButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(news)).click();
        wait.until(ExpectedConditions.urlContains("https://airlines.aero/category/news/"));
    }
    @Step(value = "Click on transfer")
    public void transferButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(transfer)).click();

        ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        wait.until(ExpectedConditions.urlContains("https://kiwitaxi.ru/"));

    }
    @Step(value = "Click on tours")
    public void toursButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(tours)).click();

        ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        wait.until(ExpectedConditions.urlContains("https://airlines.travelata.ru/"));
    }
    @Step(value = "Click on reviews")
    public void reviewsButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(reviews)).click();
        wait.until(ExpectedConditions.urlContains("https://airlines.aero/reviews/"));
    }
    @Step(value = "Click on hotel")
    public void hotelButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(hotel)).click();

        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        wait.until(ExpectedConditions.urlContains("https://ostrovok.ru/hotel/russia/krasnodar_krai_black_sea_coast_multi/"));
    }


}
