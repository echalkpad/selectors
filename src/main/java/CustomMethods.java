import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by juliay on 23-Dec-15
 */
public class CustomMethods {
    static WebDriver driver;

    public static WebDriver getDriver()
    {
        if(driver == null)
        {
            return new FirefoxDriver();
        }
        else
        {
            return driver;
        }
    }



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

    public String getPropValue(String key)
    {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("config.properties");
            // load a properties file
            prop.load(input);
        } catch (IOException ex) {
            ex.getMessage();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.getMessage();
                }
            }
        }
        return prop.getProperty(key);
    }


}



