import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC3_EditEmp {

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
		System.out.println("Change passwrod and Logout is Displayed");
	}
	
//To perform Actions on Add Employee
	Actions A = new Actions(Driver);
	//WebElement PIM=Driver.findElement(By.linkText("PIM"));

//finding an Element by CSS path
	WebElement PIM=Driver.findElement(By.cssSelector(".drop.current"));
	if (PIM.isDisplayed())
	{
		System.out.println("PIM is Dipsplayed");
	}
	A.moveToElement(PIM).perform();
	
	WebElement AddEmp=Driver.findElement(By.cssSelector(".l2_link.empadd>span"));
	if (AddEmp.isDisplayed())
	{
		System.out.println("Add Employee is Displayed");
	}
	A.click(AddEmp).perform();
	
//Changing Frame to Right Menu
	Driver.switchTo().frame("rightMenu");
	
	String EmpCode=Driver.findElement(By.cssSelector("#txtEmployeeId")).getAttribute("value");
	System.out.println("Employee Code\t"  + EmpCode);
	
	//Create WebElement for Save Button
	
	WebElement ObjSave=Driver.findElement(By.cssSelector("#btnEdit"));
	A.click(ObjSave).perform();
	
	Alert Alrt;
	Alrt=wait.until(ExpectedConditions.alertIsPresent());
	
	if(Alrt.getText().equals("Last Name Empty!"))
	{
		System.out.println("Last Name Empty! Displayed\n");
	}
	
	Alrt.accept();
	
	WebElement sLN=Driver.findElement(By.cssSelector("#txtEmpLastName"));
	WebElement sFN=Driver.findElement(By.xpath("//div[@class='maincontent']/input[3]"));
	
//Enetering LAst Name
	sLN.sendKeys("Pushpa");
	
	ObjSave.click();
	
	Alrt=wait.until(ExpectedConditions.alertIsPresent());
	
	if(Alrt.getText().equals("First Name Empty!"))
	{
		System.out.println(Alrt.getText()+" Displayed");
	}
	Alrt.accept();
	
//Entering First Name
	sFN.sendKeys("Pandloori");
	ObjSave.click();
	
//Verifying Personal Details Page
	String PD=Driver.findElement(By.cssSelector(".mainHeading>h2")).getText();
	if (PD.equals("Personal Details"))
	{
		System.out.println("Personal Details is Displayed");
	}
	//Changing frame to parent Frame
		Driver.switchTo().parentFrame();
			
	//Verifying Employee List
		if (PIM.isDisplayed())
		{
			System.out.println("PIM is Dipsplayed");
		}
	A.moveToElement(PIM).perform();
		
	WebElement EmpList=Driver.findElement(By.linkText("Employee List"));
			
	A.click(EmpList).perform();
			
	Driver.switchTo().frame("rightMenu");
	if(Driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Employee Information"))
		{
			System.out.println("Employee Information displayed");
		}	
			
	String EmpText=Driver.findElement(By.xpath("//table[@class='data-table']/descendant::td[contains(text(),'"+EmpCode+"')]/following-sibling::td/a")).getText();
	if(EmpText.equals("Pandloori Pushpa"))
		{
			System.out.println("Employee code  "+EmpCode+"\nEmployee Name  "+EmpText );
		}
	WebElement EmpName=Driver.findElement(By.xpath("//table[@class='data-table']/descendant::td[contains(text(),'"+EmpCode+"')]/following-sibling::td/a"));
	A.click(EmpName).perform();
	
	WebElement Edit=Driver.findElement(By.cssSelector(".editbutton"));
	A.click(Edit).perform();
	WebElement Female=Driver.findElement(By.xpath("//input[@class='formRadio'][2]"));
	A.click(Female).perform();
	WebElement Rename=Driver.findElement(By.xpath("//input[@class='formInputText'][2]"));
	Rename.clear();
	String NewName="Jasmine Venkatraman";
	Rename.sendKeys(NewName);
	
	//Saving Edited Data
	
	WebElement Save=Driver.findElement(By.cssSelector(".savebutton"));
	A.click(Save).perform();
	//Changing frame to parent Frame
		Driver.switchTo().parentFrame();
		
	//Verifying Employee List
		if (PIM.isDisplayed())
		{
			System.out.println("PIM is Dipsplayed");
		}
	A.moveToElement(PIM).perform();
		
	A.click(EmpList).perform();
			
	Driver.switchTo().frame("rightMenu");
	if(Driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Employee Information"))
		{
			System.out.println("Employee Information displayed");
		}	
			
	String NewEmpName=Driver.findElement(By.xpath("//table[@class='data-table']/descendant::td[contains(text(),'"+EmpCode+"')]/following-sibling::td/a")).getText();
	if(NewEmpName.equals("Pandloori "+NewName))
		{
			System.out.println("Employee code  "+EmpCode+"\nEmployee Name  "+NewEmpName);
		}
	
	//Checking Information Edited Or Not
	if(EmpText.equals(NewEmpName))
	{
		System.out.println("Name Not yet Edited");
	}
	else
	{
		System.out.println("Name is Edited Successfully");
	}
	Driver.switchTo().defaultContent();
	A.click(Driver.findElement(By.linkText("Logout"))).perform();

//Again Verifying Login Homepage
	if(Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
	{
		System.out.println("Home page Displayed SignOff Successfully");
	}
	else
	{
		System.out.println("Home page is not Displayed So failed to SignOff");
	}
	Driver.close();
	Driver.quit();
	
}
}