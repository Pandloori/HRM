import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WorkingIE 
{
	public static void main(String[] args)throws Exception
	{
		System.setProperty("webdriver.ie.driver", "C:\\Users\\QAP6\\Downloads\\IEDriverServer.exe");
		InternetExplorerDriver Driver=new InternetExplorerDriver();

		//To maximize Browser
		Driver.manage().window().maximize();
		//open HRM link
		Driver.get("http://apps.qaplanet.in/qahrm/login.php");
		//wait for 2 seconds
		Thread.sleep(2000);
		//Verify User name element present
		WebElement UN=Driver.findElement(By.name("txtUserName"));
		WebElement PWD=Driver.findElement(By.name("txtPassword"));
		UN.sendKeys("qaplanet1");
		//Verify User name element present
		PWD.sendKeys("lab1");
		//Click on Submit Button
		Driver.findElement(By.name("Submit")).click();
		Thread.sleep(2000);
		Driver.findElement(By.linkText("Logout")).click();
		Driver.close();
	}

}
