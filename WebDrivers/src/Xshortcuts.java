import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
public class Xshortcuts {
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\QAP6\\Downloads\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		
		Driver.manage().window().maximize();
		Driver.get("http://apps.qaplanet.in/qahrm/login.php");
		Thread.sleep(2000);
		
		if(Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
		{
			System.out.println("Homepage Displayed");
		}

//Verify User name Using Contains Command
		String UN=Driver.findElement(By.xpath("//table[@id='Table_01']/descendant::td[contains(text(),'Login Name :')]")).getText();
		String PWD=Driver.findElement(By.xpath("//table[@id='Table_01']/descendant::td[contains(text(),'Password :')]")).getText();
		System.out.println(UN);
		System.out.println(PWD);

//Creating WebElemets Using Descendant Command
		WebElement sUN=Driver.findElement(By.xpath("//table[@id='Table_01']/descendant::input[@class='loginText']"));
		WebElement sPWD=Driver.findElement(By.xpath("//table[@id='Table_01']/descendant::input[@class='loginText'][2]"));
		WebElement Login=Driver.findElement(By.xpath("//table[@id='Table_01']/descendant::input[@type='Submit']"));
		
		sUN.sendKeys("qaplanet1");
		sPWD.sendKeys("lab1");
		Login.click();
		Thread.sleep(2000);
		
//Verifying OrangeHRM window and Change Password and Logout Using Preceding-sibling
		
		if(Driver.getTitle().equals("OrangeHRM"))
		{
			System.out.println("OrangeHRM Homepage Displayed");
		}
		
		String WelText=Driver.findElement(By.xpath("//ul[@id='option-menu']/descendant::li[3]/preceding-sibling::li[2]")).getText();
		WebElement CP=Driver.findElement(By.xpath("//ul[@id='option-menu']/descendant::li[3]/preceding-sibling::li[1]"));
		//WebElement Logout=Driver.findElement(By.xpath("//ul[@id='option-menu']/descendant::li[3]"));
		WebElement Logout=Driver.findElement(By.xpath("//div[@id='option-menu-bar']/ul/li[3]/a"));
		
		System.out.println(WelText);
		if(CP.isDisplayed() && Logout.isDisplayed())
		{
			System.out.println("Change Password and Logout are Displayed");
		}	
		
		Logout.click();
		Thread.sleep(2000);
		
		if(Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
		{
			System.out.println("Homepage Displayed So Signoff Successful");
		}
	}

}
