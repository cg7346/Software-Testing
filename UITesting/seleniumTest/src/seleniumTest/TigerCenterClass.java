package seleniumTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

class TigerCenterClass {
	
	private WebDriver driver;
	private String baseUrl;

    @BeforeEach
    void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver"); // can be replaced with Firefox driver
		driver = new ChromeDriver(); // can be replaced with Firefox
		baseUrl = "https://"; // TARGET URL
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @AfterEach
    void tearDown() {
    	driver.quit();
    }
    
    @Test
    public void testClassSearchButton() throws Exception {
    	driver.get(baseUrl+"tigercenter.rit.edu/tigerCenterApp/landing");
    	WebElement classButton = driver.findElement(By.xpath("//*[@id=\"angularApp\"]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/landing-page/div/div/div/div/div[4]/a[1]"));
    	assertEquals("Class Search", classButton.getText());
    	classButton.click();
    } 

}

