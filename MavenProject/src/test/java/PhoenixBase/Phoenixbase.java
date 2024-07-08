package PhoenixBase;



import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.AfterTest;


import org.testng.annotations.BeforeTest;



import PageObjects.TagsPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;




public class Phoenixbase {
public static WebDriver driver;
public TagsPageObjects tmpo;




@BeforeTest
public void instatiateDrivers() throws InterruptedException {
	
	WebDriverManager.chromedriver().clearDriverCache().setup();
    driver = new ChromeDriver();
	//log.info("Browser intiated");
	driver.manage().window().maximize();
	//log.info("Window maximized");
	//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	//log.info("ready to launch browser");

	driver.get("https://qaphxapp.amzur.com");
	//log.info("Browser Launched");
	Thread.sleep(15000);
	
	}
	
@AfterTest
public static  void closeDriver() throws InterruptedException {
    /*if (driver != null) {    
    	driver.quit();    
    	driver = null;    }*/
	Thread.sleep(50000);
	driver.close();
    }
}
