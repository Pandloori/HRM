import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWebtable {
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\QAP6\\Downloads\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		//Get URL
	}

}
