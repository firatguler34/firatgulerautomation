import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class BasePage extends BaseTest {
    WebDriver driver = driverMethod();
    WebDriverWait wait = new WebDriverWait(driver, 60);

    protected boolean isElementExist(By by, int s) {
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(s, TimeUnit.SECONDS);
        boolean isExist = driver.findElements(by).size() > 0;
        return isExist;
    }

    protected WebElement findElement(By by) {
        WebElement element = null;
        try {
            boolean exist = isElementExist(by, 15);
            int count = 0;
            while (!exist && count < 10) {
                exist = isElementExist(by, 2);
                count++;
            }
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            element = driver.findElement(by);
        } catch (Exception e) {
            Assert.assertTrue("Hata, element bulunamadı, " + e, false);
        }
        return element;
    }

    protected List<WebElement> findElements(By by) {
        List<WebElement> elements = null;
        try {
            boolean visbility = isElementExist(by, 15);
            int count = 0;
            while (!visbility && count < 10) {
                visbility = isElementExist(by, 2);
                count++;
            }
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            elements = driver.findElements(by);
        } catch (Exception e) {
            Assert.assertTrue("Hata, hiç bir element bulunmadı, " + e, false);
        }
        return elements;
    }

    public void log(String text) {
        System.out.println(text);
        ;
    }

    protected void click(By by) {
        try {
            WebElement element = findElement(by);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (Exception e) {
            Assert.assertTrue("Hata, element tıklanmadı " + e, false);
        }
    }

    protected void clickByJs(By by) {
        try {
            WebElement element = findElement(by);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            Assert.assertTrue("Hata, element tıklanmadı " + e, false);
        }
    }

    protected void clickByJs(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            Assert.assertTrue("Hata, element tıklanmadı " + e, false);
        }
    }

    protected void sendKeys(By by, String txt) {
        try {
            findElement(by).sendKeys(txt);
        } catch (Exception e) {
            Assert.assertTrue("Hata, elemente metin girerken hata oluştu, " + e, false);
        }
    }

    protected void moveToElement(By by) {
        try {
            Actions action = new Actions(driver);
            WebElement element = findElement(by);
            action.moveToElement(element).build().perform();
        } catch (Exception e) {
            Assert.assertTrue("Hata, Elemente taşınırken hata oluştu " + e, false);
        }
    }

    public void driverQuit() {
        driver.quit();
    }

    public int getRandomNumber(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }

    public void selectElementByText(By by, String text) {
        WebElement element = findElement(by);
        Select slc = new Select(element);
        slc.selectByVisibleText(text);
    }


    public String getAttributeOfElement(By by, String attributeName) {
        return findElement(by).getAttribute(attributeName);
    }

}
