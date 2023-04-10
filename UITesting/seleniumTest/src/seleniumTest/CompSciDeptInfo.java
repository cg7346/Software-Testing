package seleniumTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

//part 3.2: CompSciDeptInfo - Kai Frazier
class CompSciDeptInfo {
	
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
    public void testSwenDeptInfo() throws Exception {
    	driver.get(baseUrl+"www.rit.edu");
        try{
            //navigate to page
            WebElement academicsMenu = driver.findElement(By.xpath("//*[@id=\"main-nav--link--academics\"]"));
            academicsMenu.click();
            WebElement collegesDropdownItem = driver.findElement(By.xpath("//*[@id=\"block-rit-bootstrap-subtheme-rit-main-menu\"]/ul/li[2]/div/div/ul[2]/li[1]/a"));
            collegesDropdownItem.click();
            WebElement golisanoButton = driver.findElement(By.xpath("//*[@id=\"block-rit-bootstrap-subtheme-content\"]/div[3]/div[3]/div/div/div/div/div/div/div/div/ul/li[3]/a"));
            golisanoButton.click();
            WebElement contactsButton = driver.findElement(By.xpath("//*[@id=\"block-rit-bootstrap-subtheme-rit-main-menu\"]/ul/li[7]/a"));
            contactsButton.click();
            WebElement compSciDeptInfo = driver.findElement(By.xpath("//*[@id=\"card-header-4303\"]/p/a/span[1]"));
            compSciDeptInfo.click();
            //make sure page is loaded
            Thread.sleep(1000);
            //find desired elements
            String contactName = driver.findElement(By.xpath("//*[@id=\"card-collapse-4303\"]/div/div[1]/article/div/div[2]/div[1]/a")).getText();
            String contactEmail = driver.findElement(By.xpath("//*[@id=\"card-collapse-4303\"]/div/div[1]/article/div/div[3]/div[1]/a")).getText();
            String contactTitle = driver.findElement(By.xpath("//*[@id=\"card-collapse-4303\"]/div/div[1]/article/div/div[2]/div[2]")).getText();
            String contactDepartment = driver.findElement(By.xpath("//*[@id=\"card-collapse-4303\"]/div/div[1]/article/div/div[2]/div[3]")).getText();
            String contactCollege = driver.findElement(By.xpath("//*[@id=\"card-collapse-4303\"]/div/div[1]/article/div/div[2]/div[4]")).getText();
            String address = driver.findElement(By.xpath("//*[@id=\"footer--site--top-middle\"]/div/div[1]/p[2]")).getText();
            //print results
            System.out.println("--------------");
            System.out.println(contactName);
            System.out.println(contactEmail);
            System.out.println(contactTitle);
            System.out.println(contactDepartment);
            System.out.println(contactCollege);
            System.out.println("--------------");
            System.out.println(address);
            System.out.println("--------------");
        }catch(NoSuchElementException e){
            System.out.println("Contact information not found");
        }
    	Thread.sleep(3000);
    }
}