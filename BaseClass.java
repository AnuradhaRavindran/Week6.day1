package testLeaftestcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import testcase.ReadExcel;

public class BaseClass {
	public ChromeDriver driver;
	public String fileName;
	@BeforeTest
	public void setFile()
	{
		fileName ="createLead";
	}
	
	@Parameters({"url","username","password"})
	@BeforeMethod
	
	public void precondition(String url,String uName,String password)
	{   
		//String expTitle = "TestLeaf Automation Platform";
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.get(url);
		//boolean displayed = driver.findElement(By.xpath("//a[contains(text()='CRM')]")).isDisplayed();
		//String title = driver.getTitle();
		//SoftAssert softassert = new SoftAssert();
		//softassert.assertEquals(displayed, expTitle);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uName);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
	}
	@DataProvider
	  public String[][] sendData1() throws IOException
			  
	  {
		  return ReadExcel.readcreateleadData(fileName);
		  //return readData;
		 /*String[][] data = new String[2][4];
		 data[0][0] ="Hari";
		 data[0][1] ="R";
		 data[0][2] ="TestLeaf";
		 data[0][3] ="99";
		 
		 data[1][0] ="Ram";
		 data[1][1] ="G";
		 data[1][2] ="TestLeaf";
		 data[1][3] ="90";
		 return data;*/
	  }
	/*AfterMethod
	public void postCondition()
	{
		driver.close();
	}*/

}
