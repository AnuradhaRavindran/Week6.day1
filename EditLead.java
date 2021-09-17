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

public class EditLead extends BaseClass{
	@BeforeTest
	public void setFile()
	{
		fileName ="CreateLead";
	}
@Test(dataProvider = "sendData")
	public  void runEditlead(String fname,String compy) {
		/*WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();*/
		driver.findElement(By.linkText("Find Leads")).click();
		//driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[1]")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(fname);
		driver.findElement(By.linkText("Find Leads")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		String actualTitle = "View Lead | opentaps CRM";
		String title2 = driver.getTitle();
		System.out.println(title2);
		if(actualTitle.equals(title2))
		{
			System.out.println("Title Matching");
		}
		else
		{
			System.out.println("Title not  Matching");
		}
		//driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		WebElement compName = driver.findElement(By.id("updateLeadForm_companyName"));
		compName.clear();
		compName.sendKeys(compy);
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		String text = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		System.out.println(text);
		//driver.close();
		

	}
@DataProvider
public String[][] sendData() throws IOException
		  
{
	  return ReadExcel.readcreateleadData("createLead");
}

	}


