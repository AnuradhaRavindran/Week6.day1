package serviceNow;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassServiceNow {
	public ChromeDriver driver;
	public String fileName;
	
	@BeforeTest
	public void setFile()
	{
		fileName ="service";
	}
	@Parameters({"url" ,"username","password"})
	@BeforeMethod
public void precondition(String url,String uname,String password) throws InterruptedException
{  
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get(url);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//driver.switchTo().frame(0);
	//driver.findElement(By.linkText("Sign up and Start Building")).click();
	driver.switchTo().frame("gsft_main");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(uname);
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
	driver.findElement(By.xpath("//button[@name='not_important']")).click();
	driver.findElement(By.id("filter")).sendKeys("Incident" ,Keys.ENTER);
}
	@DataProvider
	public String[][] senddataservise() throws IOException
	{
		return ReadExcelService.readExcelservicenow(fileName);
	}
	/*@DataProvider
	public String[][] senddata() throws IOException
	{
		return ReadExcelService.readExcelservicenow(fileName);
	}*/
	/*@AfterMethod
	public void postCondition()
	{
		driver.close();
	}*/
}
