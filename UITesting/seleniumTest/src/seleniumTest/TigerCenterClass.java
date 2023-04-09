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
		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe"); // can be replaced with Firefox driver
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
    
    @Test
    public void testClickTerm() throws Exception {
    	driver.get(baseUrl+"tigercenter.rit.edu/tigerCenterApp/landing");
    	WebElement classButton = driver.findElement(By.xpath("//*[@id=\"angularApp\"]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/landing-page/div/div/div/div/div[4]/a[1]"));
    	classButton.click();
    	WebElement termSelect = driver.findElement(By.xpath("//*[@id=\"angularApp\"]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/class-search/div/div[2]/form/div/div/div/select"));
    	termSelect.click();
    	WebElement termSelect2 = driver.findElement(By.xpath("//*[@id=\"angularApp\"]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/class-search/div/div[2]/form/div/div/div/select/option[4]"));
    	assertEquals("2023-24 Fall (2231)", termSelect2.getText());
    }
    
    @Test
    public void testSearchClass() throws Exception {
    	driver.get(baseUrl+"tigercenter.rit.edu/tigerCenterApp/landing");
    	WebElement classButton = driver.findElement(By.xpath("//*[@id=\"angularApp\"]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/landing-page/div/div/div/div/div[4]/a[1]"));
    	classButton.click();
    	WebElement termSelect = driver.findElement(By.xpath("//*[@id=\"angularApp\"]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/class-search/div/div[2]/form/div/div/div/select"));
    	termSelect.click();
    	WebElement termSelect2 = driver.findElement(By.xpath("//*[@id=\"angularApp\"]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/class-search/div/div[2]/form/div/div/div/select/option[4]"));
    	termSelect2.click();
    	WebElement classInput = driver.findElement(By.xpath("//*[@id=\"angularApp\"]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/class-search/div/div[2]/form/div/ng2-completer/div/input"));
    	classInput.sendKeys("SWEN-352");
    	WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"angularApp\"]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/class-search/div/div[2]/form/div/button"));
    	searchButton.click();
    	//part 2a
    	WebElement classContainer = driver.findElement(By.xpath("//*[@id=\"angularApp\"]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/class-search/div/div[2]/div[4]/div[5]"));
    	//app-class-search-row tag is the classes
    	System.out.println(classContainer);
    	
    	WebElement classText = driver.findElement(By.xpath("//*[@id=\"angularApp\"]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/class-search/div/div[2]/div[4]/div[5]/app-class-search-row/div/div/div/div/p/span"));
    	assertEquals("Software Testing", classText.getText());
    }

}

