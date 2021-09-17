package serviceNow;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteIncident extends BaseClassServiceNow {
	@Test(dataProvider = "senddataservise")
	public void runDeleteIncident(String nameId)  throws InterruptedException
	{
	/*WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://dev102686.service-now.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//driver.switchTo().frame(0);
	//driver.findElement(By.linkText("Sign up and Start Building")).click();
	driver.switchTo().frame("gsft_main");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("8eah3nLbUMID");
	driver.findElement(By.xpath("//button[@name='not_important']")).click();
	driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident" ,Keys.ENTER);*/
	driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();
	driver.switchTo().frame("gsft_main");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(nameId,Keys.ENTER);
	WebElement incidentnumber = driver.findElement(By.xpath("//a[@class='linked formlink']"));
	String text = incidentnumber.getText();
	System.out.println(text);
	incidentnumber.click();
	driver.findElement(By.xpath("//button[@class='form_action_button header  action_context btn btn-default' and text()='Delete']")).click();
	driver.findElement(By.xpath("//button[@class='btn btn-destructive']")).click();
	//driver.switchTo().frame("gsft_main");
	driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(nameId,Keys.ENTER);
	WebElement checkrecord = driver.findElement(By.xpath("//tbody[@class='list2_body']//tr/td"));
	String text2 = checkrecord.getText();
	System.out.println(text2);
	if(text2.contains("No records to display"))
	{
		System.out.println("records deleted");
	}
	else
	{
		System.out.println("records not deleted");
	}
	/*driver.findElement(By.xpath("//div[text()='Incidents']")).click();
	driver.findElement(By.xpath("(//div[@class='sn-widget-list-title' and text()='Incidents'])[2]")).click();
	driver.switchTo().frame("gsft_main");
	//Thread.sleep(1000);
	driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("exsistingincident",Keys.ENTER);
	WebElement incident = driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]"));
	String text2 = incident.getText();
	System.out.println(text2);
	incident.click();
	WebElement incidentNumber = driver.findElement(By.xpath("//input[@id='sys_original.incident.number']"));
	String value = incidentNumber.getAttribute("value");
	System.out.println(value);
	if(text2.equals(value))
	{
		System.out.println("record found deleted");
	}
	else
	{
		System.out.println("record not deleted");
	}
	driver.findElement(By.xpath("//button[@class='form_action_button header  action_context btn btn-default' and text()='Delete']")).click();
	driver.findElement(By.xpath("//button[@class='btn btn-destructive' and text()='Delete']")).click();
	//driver.switchTo().frame("gsft_main");
	Thread.sleep(5000);
	WebElement search = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
	search.sendKeys(text2,Keys.ENTER);
	WebElement checkrecord = driver.findElement(By.xpath("//td[text()='No records to display']"));
	String text = checkrecord.getText();
	if(text.contains("No records to display"))
	{
		System.out.println("records deleted");
	}
	else
	{
		System.out.println("records not deleted");
	}
	/*Alert alert = driver.switchTo().alert();
	Thread.sleep(1000);
	alert.accept();*/
	
	
	
	

}
}