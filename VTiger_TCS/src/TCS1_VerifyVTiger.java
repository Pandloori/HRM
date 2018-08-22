import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class TCS1_VerifyVTiger {
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
	
	//Entering UserName and PWD then login
	UN.sendKeys("qaplanet1");
	Thread.sleep(500);
	PWD.sendKeys("lab1");
	Thread.sleep(500);
	Login.click();
	
	//Verifying the New VTiger Page
	if(wait.until(ExpectedConditions.titleContains("user1 - Home - vtiger CRM 5 - Commercial Open Source CRM")))
	{
		System.out.println("\nVTiger CRM Homepage is Displayed");
	}
	else
	{
		System.out.println(" Failed to Login");
		return;
	}
	
	//Creating WebElements for all Elements in VTiger Page
	
	WebElement Calendar=Driver.findElement(By.linkText("Calendar"));
	WebElement Leads=Driver.findElement(By.linkText("Leads"));
	WebElement Organizations=Driver.findElement(By.linkText("Organizations"));
	WebElement Contacts=Driver.findElement(By.linkText("Contacts"));
	WebElement Opportunities=Driver.findElement(By.linkText("Opportunities"));
	WebElement Products=Driver.findElement(By.linkText("Products"));
	WebElement Documents=Driver.findElement(By.linkText("Documents"));
	WebElement Email=Driver.findElement(By.linkText("Email"));
	WebElement Trouble=Driver.findElement(By.linkText("Trouble Tickets"));
	WebElement Dashboard=Driver.findElement(By.linkText("Dashboard"));
	
	//Verifying All Elements 
	
	if(Calendar.isDisplayed() && Leads.isDisplayed() && Organizations.isDisplayed() && Contacts.isDisplayed() && Opportunities.isDisplayed())
	{
		System.out.println("\nCalendar,Leads,Oranizations,Contacts and Opportunities are Displayed\n");
	}
	else
	{
		System.out.println("Elements are Not Displayed");
	}
	if(Products.isDisplayed() && Documents.isDisplayed() && Email.isDisplayed() && Trouble.isDisplayed() && Dashboard.isDisplayed())
	{
		System.out.println("Products, Documents, Email, Trouble_Tickets and Dashboard are Displayed\n\n");
	}
	//Signing off the Account and Going back to Home page
	Actions Act=new Actions(Driver);
	
	WebElement SignImg=Driver.findElement(By.xpath("//td[@class='genHeaderSmall']/following-sibling::td/img"));
	
	Act.moveToElement(SignImg).perform();
	
	Thread.sleep(2000);
	
	WebElement Logout=Driver.findElement(By.linkText("Sign Out"));
	Act.click(Logout).perform();
	
	//Verifying VTiger home page
	
	if(wait.until(ExpectedConditions.titleIs("vtiger CRM 5 - Commercial Open Source CRM")))
	{
		System.out.println("VTiger Homepage is Displayed So SignOff Successfully");
	}
	else
	{
		System.out.println("Failed to SignOff");
	}
	
	}

}
