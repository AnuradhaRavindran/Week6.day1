package serviceNow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignIncident extends BaseClassServiceNow{ 
	@Test(dataProvider = "senddataservise")
	
	public void runAssignIncident(String nameid,String assigngroup,String worknote) throws InterruptedException{
		
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
		driver.findElement(By.id("filter")).sendKeys("Incident" ,Keys.ENTER);*/
		driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();
		driver.switchTo().frame("gsft_main");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(nameid,Keys.ENTER);
		WebElement incidentnumber = driver.findElement(By.xpath("//a[@class='linked formlink']"));
		String text = incidentnumber.getText();
		System.out.println(text);
		incidentnumber.click();
		driver.findElement(By.id("lookup.incident.assignment_group")).click();
		Set<String> windowHandlesset = driver.getWindowHandles();
		List<String> windowhandleList = new ArrayList<String>(windowHandlesset);
		driver.switchTo().window(windowhandleList.get(1));
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(assigngroup,Keys.ENTER);
		driver.findElement(By.linkText("Software")).click();
		driver.switchTo().window(windowhandleList.get(0));
		Thread.sleep(2000);
		driver.switchTo().window(windowhandleList.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("lookup.incident.assigned_to")).click();
		Set<String> windowHandlesset1 = driver.getWindowHandles();
		List<String> windowhandleList1 = new ArrayList<String>(windowHandlesset1);
		driver.switchTo().window(windowhandleList1.get(1));
		WebElement name = driver.findElement(By.xpath("//a[@class='glide_ref_item_link']"));
		String text3 = name.getText();
		System.out.println(text3);
		name.click();
		driver.switchTo().window(windowhandleList1.get(0));
		driver.switchTo().frame("gsft_main");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-700)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys(worknote);
		driver.findElement(By.xpath("(//button[@class='form_action_button header  action_context btn btn-default'])[1]")).click();
		//driver.switchTo().frame("gsft_main");
		js.executeScript("window.scrollBy(200,0)");
		Thread.sleep(5000);
		String assignmentgroup = driver.findElement(By.xpath("//tbody[@class='list2_body']//tr/td[10]")).getText();
		System.out.println("You have selected Assignment group is " +assignmentgroup+ "");
		String assignmentto = driver.findElement(By.xpath("//tbody[@class='list2_body']//tr/td[11]")).getText();
		System.out.println("You have selected Assignment group is " +assignmentto+ "");
		//driver.close();
	
	}
	
	

}
