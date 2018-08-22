import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC7_DeleteLocation {
	public static void main(String[] args) throws Exception
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\QAP6\\Downloads\\chromedriver.exe");
	ChromeDriver Driver=new ChromeDriver();
	WebDriverWait wait=new WebDriverWait(Driver,60);
	
//To maximize browser
	Driver.manage().window().maximize();
//To open HRM application
	Driver.get("http://apps.qaplanet.in/qahrm/login.php");
//Verify Home Page Title
	if(Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
	{
		System.out.println("Home page Displayed");
	}
	else
	{
		System.out.println("Home page failed to Display");
		return;
	}
//Create web elements for User name Password Login and Clear
	
	WebElement UN=Driver.findElement(By.name("txtUserName"));
	WebElement PWD=Driver.findElement(By.name("txtPassword"));
	WebElement Login=Driver.findElement(By.name("Submit"));
	WebElement Clear=Driver.findElement(By.name("clear"));

	
//********************Verifying All Elements**********************
//Verify UN,PWD,Login,Clear are Displayed or not
	if(UN.isDisplayed())
	{
		System.out.println("Username is Displayed");
	}
//Verify Password
	if(PWD.isDisplayed())
	{
		System.out.println("Password is Displayed");
	}
//Verify Login button
	if(Login.isDisplayed())
	{
		System.out.println("Login is Displayed");
	}
//Verify Clear Button
	if(Clear.isDisplayed())
	{
		System.out.println("Clear is Displayed");
	}
//*******************************************************************
	
//Entering Username Password and Click on Login
	
	UN.clear();
	UN.sendKeys("qaplanet1");
	PWD.clear();
	PWD.sendKeys("lab1");
	Login.click();
	
//***************Verifying All elements for New Page ***********************
//verifying Title
	if(Driver.getTitle().equals("OrangeHRM"))
		{
		System.out.println("Orange HRM is Displayed");
		}
	else{
		System.out.println("Failed to Login");
		return;
		}
//Verify Welcome Text
	String Weltext=Driver.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText();
	if(Weltext.equals("Welcome qaplanet1"))
	{
		System.out.println("Welcome text Displayed");
	}
	
//Create Web elements for Change Password and Logout
WebElement CP=Driver.findElement(By.linkText("Change Password"));
WebElement Logout=Driver.findElement(By.linkText("Logout"));

//Verifying Logout and Change Password
	if(CP.isDisplayed() && Logout.isDisplayed()) 
	{
		System.out.println("Change passwrod and Logout is Displayed\n");
	}
//******************Verifying Admin ***************
	WebElement Admin=Driver.findElement(By.cssSelector(".drop"));
	Actions Act=new Actions(Driver);
	Act.moveToElement(Admin).perform();
//**************Focus on Company Info and Verifying all Elements**************
	
	
	WebElement CmpInfo=Driver.findElement(By.linkText("Company Info"));
	
	WebElement Job=Driver.findElement(By.cssSelector(".l2_link.parent.job>span"));
	if(CmpInfo.getText().equals("Company Info") && Job.getText().equals("Job"))
	{
		System.out.println("Company Information and Job is Displayed");
	}
	String Qlfy=Driver.findElement(By.cssSelector(".l2_link.parent.qualifications>span")).getText();
	String Skills=Driver.findElement(By.cssSelector(".l2_link.parent.skills>span")).getText();
	String Users=Driver.findElement(By.cssSelector(".l2_link.parent.users>span")).getText();
	String PrdctInfo=Driver.findElement(By.cssSelector(".l2_link.parent.project>span")).getText();
	System.out.println(Qlfy +" , "+Skills+" , "+Users +" , "+PrdctInfo+"  Are Displayed\n");
	
//***************Move to CompanyInfo and Verifying all elements there***********
	
	Act.moveToElement(CmpInfo).perform();
	WebElement Loc=Driver.findElement(By.xpath("//span[contains(text(),'Locations')]"));
	String Gen=Driver.findElement(By.xpath("//span[contains(text(),'General')]")).getText();
	String Structure=Driver.findElement(By.xpath("//span[contains(text(),'Company Structure')]")).getText();
	String Property=Driver.findElement(By.xpath("//span[contains(text(),'Company Property')]")).getText();
	
	if(Loc.getText().equals("Locations"))
	{
		System.out.println("Locations is Displayed");
	}
	System.out.println(Gen+" , " +Structure +" , " +Property +"  Are Displayed\n");
	
	Act.click(Loc).perform();
	
	Driver.switchTo().frame("rightMenu");

//***********Verifying Locations Page**************
	
	String SearchBy=Driver.findElement(By.xpath("//div[@class='searchbox']/label")).getText();
	String SearchFor=Driver.findElement(By.xpath("//div[@class='searchbox']/label[2]")).getText();
	
	WebElement Search=Driver.findElement(By.cssSelector(".plainbtn"));
	WebElement Reset=Driver.findElement(By.xpath("//input[@value='Reset']"));
	WebElement Add=Driver.findElement(By.xpath("//input[@value='Add']"));
	WebElement Delete=Driver.findElement(By.xpath("//input[@value='Delete']"));
	
	if(SearchBy.equals("Search By:") && SearchFor.equals("Search For:"))
	{
		System.out.println("SearchBy and SearchFor is Displayed");
	}
	
	if(Search.isDisplayed() && Reset.isDisplayed() && Add.isDisplayed() && Delete.isDisplayed())
	{
		System.out.println("Search Button , Add Button , Reset Button , Delete Buttons Are Displayed\n\n");
	}
	//Click On Add and then Verify Company Info : Locations
	
	Act.click(Add).perform();
	if(Driver.findElement(By.cssSelector(".mainHeading>h2")).getText().equals("Company Info : Locations"))
	{
		System.out.println("Company Info : Locations is Displayed");
	}
	WebElement Name=Driver.findElement(By.cssSelector("#txtLocDescription"));
	WebElement Country=Driver.findElement(By.cssSelector("#cmbCountry"));
	WebElement Address=Driver.findElement(By.cssSelector("#txtAddress"));
	WebElement ZipCode=Driver.findElement(By.cssSelector("#txtZIP"));
	WebElement Save=Driver.findElement(By.cssSelector("#editBtn"));
	
	//Click on Save Button and Handling Alerts
	Act.click(Save).perform();
	Alert Alrt;
	Alrt=wait.until(ExpectedConditions.alertIsPresent());
	if(Alrt.getText().equals("Please correct the following\n\n\t- Location Name has to be specified\n\t- Country should be selected!\n\t- Address should be specified\n\t- Zip Code should be specified\n"))
	{
		System.out.println(Alrt.getText() +"This Alert message is Displayed\n");
	}
	else
	{
		System.out.println("Alert message is failed to Display");
	}
	Alrt.accept();
	
	//Entering Name and click on save Button and handling with Alerts 
	
	String Location="Chennai Central";
	Name.sendKeys(Location);
	Act.click(Save).perform();
	
	Alrt=wait.until(ExpectedConditions.alertIsPresent());
	if(Alrt.getText().equals("Please correct the following\n\n\t- Country should be selected!\n\t- Address should be specified\n\t- Zip Code should be specified\n"))
	{
		System.out.println(Alrt.getText() +"This Alert message is Displayed\n");
	}
	else
	{
		System.out.println("Alert message is failed to Display");
	}
	Alrt.accept();
	// Selecting Country
	Act.click(Country).perform();
	Select S=new Select(Country); 
	S.selectByVisibleText("India");
	
	//Click on save  and Handling with Alerts
	Act.click(Save).perform();
	Alrt=wait.until(ExpectedConditions.alertIsPresent());
	if(Alrt.getText().equals("Please correct the following\n\n\t- Address should be specified\n\t- Zip Code should be specified\n"))
	{
		System.out.println(Alrt.getText() +"This Alert message is Displayed\n");
	}
	else
	{
		System.out.println("Alert message is failed to Display");
	}
	Alrt.accept();
	//Entering City Name
	WebElement City=Driver.findElement(By.cssSelector("#cmbDistrict"));
	String CityName="Velacheri";
	City.sendKeys(CityName);
	
	//Entering Address and click on Save and Handling with Alerts
	String Adrs="Tiruttani";
	Address.sendKeys(Adrs);
	
	Thread.sleep(2000);
	Act.click(Save).perform();
	Alrt=wait.until(ExpectedConditions.alertIsPresent());
	
	if(Alrt.getText().equals("Please correct the following\n\n\t- Zip Code should be specified\n"))
	{
		System.out.println(Alrt.getText() +"This Alert message is Displayed\n");
	}
	else
	{
		System.out.println("Alert message is failed to Display");
	}
	Alrt.accept();
	
	//Entering ZipCode and Click on Save
	ZipCode.sendKeys("517586");
	Thread.sleep(2000);
	
	Act.click(Save).perform();
	
	//Verifying Locations page
	if(Driver.findElement(By.cssSelector(".mainHeading>h2")).getText().equals("Company Info : Locations"))
	{
		System.out.println("Company Info : Locations is Displayed\n");
	}
	
	WebElement ObjLoc=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/descendant::a[contains(text(),'"+Location+"')]"));
	
	String CodeLoc=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/descendant::a[contains(text(),'"+Location+"')]/ancestor::td/preceding-sibling::td[1]/a")).getText();
	System.out.println("Location Code is	:"+ CodeLoc);
	
	Act.click(ObjLoc).perform();
	
	WebElement Edit=Driver.findElement(By.cssSelector(".editbutton"));
	Act.click(Edit).perform();
	String NewLoc="T-Nagar";
	Driver.findElement(By.cssSelector("#txtLocDescription")).clear();
	Thread.sleep(1000);
	
	Driver.findElement(By.cssSelector("#txtLocDescription")).sendKeys(NewLoc);
	Thread.sleep(1000);
	
	Driver.findElement(By.cssSelector(".savebutton")).click();
	
	String Edited=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/descendant::a[contains(text(),'"+CodeLoc+"')]/ancestor::td/following-sibling::td/a")).getText();
	System.out.println("\nNew Edited Location Name is	"+Edited);
	
	if(Edited.equals(NewLoc))
	{
		System.out.println("\n\nLocated Edited Successfully");
	}
	
	//Deleting the created Mail
	
	WebElement CheckBox=Driver.findElement(By.xpath("//a[contains(text(),'"+CodeLoc+"')]/ancestor::td/preceding-sibling::td/input"));
	Act.click(CheckBox).perform();
	
	WebElement Del=Driver.findElement(By.xpath("//input[@value='Delete']"));
	Act.click(Del).perform();
	
	//Handling Delete Alert
	Alrt=wait.until(ExpectedConditions.alertIsPresent());
	Alrt.accept();
	
	//Verifying Location Deleted or Nots
	
	WebElement SearchB=Driver.findElement(By.cssSelector("#loc_code"));
	Select SB=new Select(SearchB);
	SB.selectByVisibleText("ID");
	
	//Entering Location Code in Search For
	WebElement SearchF=Driver.findElement(By.cssSelector("#loc_name"));
	SearchF.sendKeys(CodeLoc);
	
	//To click on Search
	WebElement Srch=Driver.findElement(By.xpath("//input[@value='Search']"));
	Act.click(Srch).perform();
	
	String NoRec=Driver.findElement(By.cssSelector(".noresultsbar")).getText();
	//Checking Message like No Records to Display
	
	if(NoRec.equals("No Records to Display!"))
	{
		System.out.println("Location Deleted Successfully");
	}
	else
	{
		System.out.println("Failed to Delete");
	}

	
	Driver.switchTo().defaultContent();
	Thread.sleep(1000);
	
	Act.click(Driver.findElement(By.linkText("Logout"))).perform();
	Thread.sleep(500);
//Again Verifying Login Homepage
	if(Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
	{
		System.out.println("\n\nHome page Displayed SignOff Successfully");
	}
	else
	{
		System.out.println("Home page is not Displayed So failed to SignOff");
		return;
	}
	Thread.sleep(2000);
	
	Driver.close();
	Driver.quit();
	}

}
