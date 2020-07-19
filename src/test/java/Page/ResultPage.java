package Page;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ResultPage {
    public WebDriver driver;

    @FindBy(css = "div.AviaResult")
    private WebElement ResultForm;

    @FindBy(css = "button.Button")
    private List<WebElement> priceButton;

    @FindBy(css = "div.wpbf-mobile-logo-container a img")
    private WebElement logo;

    @FindBy(css = "div[data-id=\"avia_result.result_list.groups\"]")
    private WebElement resultList;
    @FindBy(css = "button[label =\"Пересадки\"]")
    private WebElement transfer;
    @FindBy(css = "span.Checkbox__Inner")
    private List<WebElement> filterOption;


    public ResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @Step(value = "Clicking on the price")
    public void clickFirstPrice() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(ResultForm));
        if(!priceButton.isEmpty()) {
            priceButton.get(0).click();
        }else {
            System.out.print("Отсутвуют подходящие результаты.");
        }
    }

    @Step(value = "Loading")
    public boolean successfulLoading() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(ResultForm));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Step(value = "Click on logo")
    public void logoButton(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , logo);
    }

    @Step(value = "Filter")
    public void filter(){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(transfer)).click();
        wait.until(ExpectedConditions.elementToBeClickable(filterOption.get(0))).click();

        wait.until(ExpectedConditions.visibilityOf(resultList));
    }

}
