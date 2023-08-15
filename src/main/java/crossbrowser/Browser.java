package crossbrowser;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

class CrossBrowser {
static WebDriver driver;
@Test
@Parameters("browser")
    public static void main (String args[]) throws InterruptedException {
    String crossBrowser= "Firefox";
        if(crossBrowser.equalsIgnoreCase("firefox")){
System.setProperty("Webdriver.geko.driver","C:\\gekodriver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if(crossBrowser.equalsIgnoreCase("chrome")){
            System.setProperty("Webdriver.chrome.driver","C:\\chrome driver\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else{
            System.out.println("Incorrect Browser");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void testParameterWithXML() throws InterruptedException{

        driver.get("https://www.browserstack.com/");
        WebElement Login = driver.findElement(By.linkText("Sign in"));

        Login.click();
        Thread.sleep(4000);
        WebElement userName = driver.findElement(By.id("user_email_login"));

        userName.sendKeys("your email id");
        Thread.sleep(4000);

        WebElement password = driver.findElement(By.id("user_password"));

        password.sendKeys("your password");
        Thread.sleep(6000);
        WebElement Signin= driver.findElement(By.id("user_submit"));

        Signin.click();
        Thread.sleep(4000);
}
    }


