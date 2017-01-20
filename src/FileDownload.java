import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FileDownload {

	public static void main(String[] args) throws Exception {
	
		//create a firefox profile
		FirefoxProfile profile = new FirefoxProfile();
		
		//set preferences for the profile
		profile.setPreference("browser.helperApps.neverAsk.openFile;", "application/octet-stream");
		
		//open browser with profile
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Bindhu\\Desktop\\Job\\Selenium\\Softwares\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(profile);
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Maximize Window
		driver.manage().window().maximize();
		
		//Opening download site
		driver.get("http://filehippo.com/download_google_chrome_for_work/32/");
		Thread.sleep(5000);
		
		//Click on download
		driver.findElement(By.xpath("//*[@id='program-header']/div[2]/div/a[1]/span[1]")).click();

	}

}
