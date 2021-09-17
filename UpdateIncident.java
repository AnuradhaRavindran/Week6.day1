package serviceNow;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateIncident extends BaseClassServiceNow{
	//@SuppressWarnings("unlikely-arg-type")
	@Test(dataProvider = "senddataservise")
	public void runUpdateIIncident(String nameid) throws InterruptedException
	{
		/*WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
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
		driver.findElement(By.xpath("//button[@name='not_important']")).click();*/
		driver.findElement(By.id("filter")).sendKeys("Incident" ,Keys.ENTER);
		driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();
		//driver.findElement(By.xpath("(//div[@class='sn-widget-list-title' and text()='Incidents'])[1]")).click();
		driver.switchTo().frame("gsft_main");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(nameid,Keys.ENTER);
		WebElement incidentnumber = driver.findElement(By.xpath("//a[@class='linked formlink']"));
		String text = incidentnumber.getText();
		System.out.println(text);
		incidentnumber.click();
		WebElement urgency = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
		Select urgencyelement = new Select(urgency);
		List<WebElement> urgencyopt = urgencyelement.getOptions();
		String text1 = urgencyopt.get(0).getText();
		urgencyopt.get(0).click();
		System.out.println("You clicked Urgency as "+text1+ "");
		WebElement state = driver.findElement(By.xpath("//select[@id='incident.state']"));
		Select stateopt = new Select(state);
		List<WebElement> statelist = stateopt.getOptions();
		String text2 = statelist.get(1).getText();
		statelist.get(1).click();
		System.out.println("You have clicked  state as " +text2+ "");
		//driver.switchTo().frame("gsft_main");
		//Thread.sleep(1000);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,-700)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='sn-stream-textarea-container']/textarea)[3]")).sendKeys("Development");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='not_important']")).click();
		String text3 = driver.findElement(By.xpath("//tbody[@class='list2_body']//tr/td[8]")).getText();
		System.out.println("We have set the state as " +text3+"");
		if(text3.equals("In Progress"))
		{
			System.out.println("state verified");
		}
		
		else
		{
			System.out.println("state not  verified");	
		}
		String text4 = driver.findElement(By.xpath("//tbody[@class='list2_body']//tr/td[7]")).getText();
		System.out.println("We have set the state as " +text4+"");
		if(text4.equals("3 - Moderate"))
		{
			System.out.println("prority verified");
		}
		
		else
		{
			System.out.println("prority not  verified");	
		}
		//driver.close();
	}

}
