package DDT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WordPress {

	WebDriver driver;   //Global variable
	
	@Test(dataProvider="wordpressData")
	public void wordpressLogin(String username, String password) throws Exception{
		
		//Opening the Browser and website
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Bindhu\\Desktop\\Job\\Selenium\\Softwares\\geckodriver.exe");
		driver = new FirefoxDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://login.wordpress.org/");
		
		//Using the locators
		
		driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='user_pass']")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='wp-submit']")).click();	
		Thread.sleep(5000);
				
		Assert.assertTrue(driver.getTitle().contains("Dashboard"),"User is not able to login. Invalid Credentials");
		System.out.println("Page title is verified. Valid Credentials");
		
		
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}
	//Data provider that implements the DDT
	
	
	@DataProvider(name="wordpressData")
	public Object[][] passData(){     //Object datatype that returns 2D array
		
		Object[][] data = new Object[3][2];  //data is the array name with 3 rows and 2 columns
		
		
		data[0][0]="admin";
		data[0][1]="admin";
		
		data[1][0]="admin1";
		data[1][1]="admin1";
		
		data[2][0]="adminbin";
		data[2][1]="adminbin";
		
		return data;
		
		
		
	}
}
