import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class MultipleBrowsers {
	public static void main(String[] args) throws Exception
	{
	//System.setProperty("webdriver.chrome.driver","C:\\Users\\QAP6\\Downloads\\chromedriver.exe");
	System.setProperty("webdriver.gecko.driver","C:\\Users\\QAP6\\Downloads\\geckodriver.exe");
	//System.setProperty("webdriver.ie.driver", "C:\\Users\\QAP6\\Downloads\\IEDriverServer.exe");
	
	
	//ChromeDriver Driver=new ChromeDriver();
	
	FirefoxDriver Driver=new FirefoxDriver();
	
	//InternetExplorerDriver Driver=new InternetExplorerDriver();
	
	WebDriverWait wait=new WebDriverWait(Driver,60);
	
	// To maximize Browser
	//Driver.manage().window().maximize();
	
	//Open VTiger Homepage
	Driver.get("http://classroom:8888");
	
	if(wait.until(ExpectedConditions.titleIs("vtiger CRM 5 - Commercial Open Source CRM")))
	{
		System.out.println("VTiger Homepage is Displayed");
	}
	else
	{
		System.out.println("Homepage is failed to Display");
	}
	
	//Verify all Elements present in Homepage
	WebElement UN=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("user_name")));
	WebElement PWD=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("user_password")));
	WebElement Login=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submitButton")));
	
	if(UN.isDisplayed() && PWD.isDisplayed() && Login.isDisplayed())
	{
		System.out.println("\nUserName,Password And Login is Displayed ");
	}
	//Clicking on Twitter Icon
	
	WebElement Twitter=Driver.findElement(By.cssSelector(".communityLinks>a:nth-child(3)>img"));
	Actions Act=new Actions(Driver);
	Act.click(Twitter).perform();
	
	//HAndling Multiple Browsers
	
	Set<String> IDS=Driver.getWindowHandles();
	
	for(String ID:IDS)
	{
		System.out.println(ID);
	}
	System.out.println("These are the Browser IDS Generated");
	
	Iterator<String> ITR=IDS.iterator();
	String First_ID=ITR.next();
	String Second_ID=ITR.next();
	
	}
}
