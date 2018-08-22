import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
public class Xpath {

	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\QAP6\\Downloads\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		
		Driver.manage().window().maximize();
		Driver.get("http://apps.qaplanet.in/qahrm/login.php");
		Thread.sleep(2000);
	//Verifying Homepage
		/*String Title=Driver.findElement(By.xpath("/html/head/title")).getText();
		System.out.println(Title);*/
		
		if(Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
				{
			System.out.println("Homepage Displayed");
				}
		else
		{
			System.out.println("Failed to Display Homepage");
		}
		
	//Verify Username
		String UN=Driver.findElement(By.xpath("//table[@id='Table_01']/tbody/tr/td[2]/table/tbody/tr[2]/td[1]")).getText();
		String PWD=Driver.findElement(By.xpath("//table[@id='Table_01']/tbody/tr/td[2]/table/tbody/tr[3]/td")).getText();
		System.out.println(UN);
		System.out.println(PWD);
		
	//Creating WebElemets
		WebElement sUN=Driver.findElement(By.xpath("//table[@id='Table_01']/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/input"));
		WebElement sPWD=Driver.findElement(By.xpath("//table[@id='Table_01']/tbody/tr/td[2]/table/tbody/tr[3]/td/input"));
		WebElement Login=Driver.findElement(By.xpath("//table[@id='Table_01']/tbody/tr/td[2]/table/tbody/tr[4]/td/input"));
	//Verifying User name and Password
		
		if(UN.equals("Login Name :") && PWD.equals("Password :"))
		{
			System.out.println("Username and Password are Displayed");
		}
		else
		{
			System.out.println("UN and PWD failed to Displayed");
		}
		
		sUN.sendKeys("qaplanet1");
		sPWD.sendKeys("lab1");
		Login.click();
		Thread.sleep(2000);
	}

}
