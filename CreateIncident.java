
package serviceNow;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testcase.ReadExcel;
public class CreateIncident extends BaseClassServiceNow{
	/*public String fileName;
	@BeforeTest
	public void setFile()
	{
		fileName ="service";
	}*/
	//@Test
	@Test(dataProvider = "senddataservise")
	public  void runcreateIncident (String description) throws InterruptedException {
	/*WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://dev80921.service-now.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//driver.switchTo().frame(0);
	//driver.findElement(By.linkText("Sign up and Start Building")).click();
	driver.switchTo().frame("gsft_main");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("ZLJfxEMwp81w");
	driver.findElement(By.xpath("//button[@name='not_important']")).click();
	driver.findElement(By.id("filter")).sendKeys("Incident" ,Keys.ENTER);*/
	driver.findElement(By.xpath("//div[text()='Create New']")).click();
	driver.switchTo().frame("gsft_main");
	String number = driver.findElement(By.xpath("//input[@id='sys_original.incident.number']")).getAttribute("value");
	System.out.println("incident number is : " +number);
	driver.findElement(By.xpath("(//span[@class='icon icon-search'])[1]")).click();
	Set<String> windowHandles = driver.getWindowHandles();
	List<String> windowhandleList = new ArrayList<String>(windowHandles);
	driver.switchTo().window(windowhandleList.get(1));
	WebElement caller = driver.findElement(By.linkText("Abel Tuter"));
	String text = caller.getText();
	System.out.println(text);
	caller.click();
	driver.switchTo().window(windowhandleList.get(0));
	driver.switchTo().frame("gsft_main");
	driver.findElement(By.id("incident.short_description")).sendKeys(description);
	driver.findElement(By.name("not_important")).click();
	driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(number,Keys.ENTER);
	String verifyNumber = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
	System.out.println(verifyNumber);
	if(number.endsWith(verifyNumber)) {
		System.out.println("Instance Created");
		
	}
	else
		System.out.println("Instance not created");
	driver.close();
	
}
	
	
	/*@DataProvider
	public String[][] senddataservise() throws IOException
	{
		return ReadExcelService.readExcelservicenow(fileName);
	}*/
}
