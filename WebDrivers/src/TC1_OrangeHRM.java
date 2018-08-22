import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
public class TC1_OrangeHRM {
	public static void main(String[] args)throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\QAP6\\Downloads\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		
	//To maximize browser
		Driver.manage().window().maximize();
	//To open HRM application
		Driver.get("http://apps.qaplanet.in/qahrm/login.php");
		Thread.sleep(2000);
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
		
		Thread.sleep(2000);
		
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
		
	//Click On Logout
		Logout.click();
		Thread.sleep(2000);
//Again Verify HomePage
		if(Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
		{
			System.out.println("Signoff Succesful Home Page Displayed");
		}
		else
		{
			System.out.println("Failed to Signoff");
		}
	Driver.close();
	Driver.quit();
	}

}
