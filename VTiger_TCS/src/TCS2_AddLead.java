import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class TCS2_AddLead {
	public static void main(String[] args) throws Exception
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\QAP6\\Downloads\\chromedriver.exe");
	//System.setProperty("webdriver.gecko.driver","C:\\Users\\QAP6\\Downloads\\geckodriver.exe");
	//System.setProperty("webdriver.ie.driver", "C:\\Users\\QAP6\\Downloads\\IEDriverServer.exe");
	
	
	ChromeDriver Driver=new ChromeDriver();
	
	//FirefoxDriver Driver=new FirefoxDriver();
	
	//InternetExplorerDriver Driver=new InternetExplorerDriver();
	
	WebDriverWait wait=new WebDriverWait(Driver,60);
	
	// To maximize Browser
	Driver.manage().window().maximize();
	
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
	
	Act.click(Leads).perform();
	Thread.sleep(500);
	WebElement Add=Driver.findElement(By.xpath("//table[@class='small'][2]/descendant::table[3]/descendant::img"));
	Act.click(Add).perform();
	
	//Now Click on Save
	WebElement Save=Driver.findElement(By.cssSelector(".crmButton.small.save"));
	Act.click(Save).perform();
	
	//Alert Handling
	Alert Alrt;
	Alrt=wait.until(ExpectedConditions.alertIsPresent());
	
	if(Alrt.getText().equals("Last Name cannot be empty"))
	{
		System.out.println("Last Name cannot be empty \nAlert Message is Displayed\n");
	}
	Thread.sleep(1000);
	Alrt.accept();
	
	Select FN=new Select(Driver.findElement(By.name("salutationtype")));
	FN.selectByVisibleText("Ms.");
	//Create WebElement for First Name
	
	WebElement Fname=Driver.findElement(By.cssSelector(".detailedViewTextBox"));
	String FirstN="Pandloori";
	
	Fname.sendKeys(FirstN);
	WebElement LN=Driver.findElement(By.name("lastname"));
	WebElement Company=Driver.findElement(By.name("company"));
	String LastN="Jasmine";
	String CompName="Wipro Techologies";
	
	Thread.sleep(1000);
	LN.sendKeys(LastN);
	Thread.sleep(500);
	Act.click(Save).perform();
	
//Alert Handling
	Alrt=wait.until(ExpectedConditions.alertIsPresent());
	if(Alrt.getText().equals("Company cannot be empty"))
	{
		System.out.println("Company cannot be empty\nAlert Message is Displayed");
	}
	
	Alrt.accept();
	Company.sendKeys(CompName);
	
	Act.click(Save).perform();
	String Code=Driver.findElement(By.xpath("//td[@class='dvtCellInfo'][2]")).getText();
	System.out.println("Emp Code: "+Code);
	
	Act.click(Driver.findElement(By.cssSelector(".tabSelected>a"))).perform();
	
	int RowC=Driver.findElements(By.cssSelector(".lvt.small>tbody>tr")).size();
	System.out.println("Row Count is "+RowC);
	int ColC=Driver.findElements(By.cssSelector(".lvt.small>tbody>tr:nth-child(1)>td")).size();
	System.out.println("Column Count is :"+ColC);
	int CellC=Driver.findElements(By.cssSelector(".lvt.small>tbody>tr>td")).size();
	System.out.println("CellCount Is :"+CellC);
	
	//Get Cell Data using for loop
	
	
	/*WebElement SignImg=Driver.findElement(By.xpath("//td[@class='genHeaderSmall']/following-sibling::td/img"));
	
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
	}*/

}
}
