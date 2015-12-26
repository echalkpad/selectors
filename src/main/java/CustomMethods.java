import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by juliay on 23-Dec-15
 */
public class CustomMethods {

    public void waitForElementPresent(WebElement element, WebDriver driver, int timeoutInSeconds)
    {
    WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
    wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForJQuery(WebDriver driver) {
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                return (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
            }
        });
    }
}
