package components;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class BaseClass {

	
	Keywords keyword= new Keywords();
	
	public RemoteWebDriver driver=null;
//Below code will run before each Testcase 
	@BeforeMethod
	public void setup() {
		keyword.openBrowser("chrome");
		this.driver= keyword.getInstance();
		driver.get("https://www.entrata.com/c");
		driver.manage().window().maximize();
	}
//Below code will run after each testcase
	@AfterMethod
	public void tearDown() {
		keyword.quiteBrowser();
	}
}

