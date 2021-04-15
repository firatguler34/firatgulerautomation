import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    public WebDriver driverMethod() {
        String url = "https://www.gittigidiyor.com/";
        String key = "webdriver.chrome.driver";
        String driverPath = "C:/Users/pc/IdeaProjects/firatgulergittigidiyor/chromedriver.exe";
        System.setProperty(key, driverPath);
        ChromeOptions chrome = new ChromeOptions();
        WebDriver webDriver = new ChromeDriver(chrome);
        webDriver.manage().window().maximize();
        webDriver.get(url);
        return webDriver;
    }
}
