package testLeaftestcases;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testcase.ReadExcel;


public class CreateLead extends BaseClass {
		
@Test(dataProvider = "sendData1")
	public  void runCreatelead(String cmpName ,String fName,String lName,String ph) {
		/*WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[contains(text(),\"CRM\")]")).click();
		driver.findElement(By.linkText("Leads")).click();*/
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.xpath("//a[@class='selected']")).click();
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys(cmpName);
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys(fName);
		WebElement firstName = driver.findElement(By.id("createLeadForm_firstName"));
		String attribute = firstName.getAttribute("name");
		System.out.println(attribute);
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys(lName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(ph);
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		WebElement findElement = driver.findElement(By.id("viewLead_companyName_sp"));
		String text = findElement.getText();
		System.out.println(text);
	   // driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
	   
		
	}
/*@DataProvider
public String[][] sendData1() throws IOException

		  
{
	  return ReadExcel.readcreateleadData("createLead");


}*/
}
