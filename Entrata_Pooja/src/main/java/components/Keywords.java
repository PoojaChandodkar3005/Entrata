package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keywords {
	public static RemoteWebDriver driver = null;


	/**
	 * This Keyword is used to launch specified browser
	 
	 * @author Pooja Chandodkar
	 * @param browserName must be one of the following:
	 *                    <ul>
	 *                    <li>chrome</li>
	 *                    <li>firefox</li>
	 *                    </ul>
	 */
//As of now only for chrome browser below method  will work.
	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*"); 
			WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver(options);
			
			
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else
			System.err.println("Invalid Browser name" + browserName);
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quiteBrowser() {
		driver.quit();
	}
	public RemoteWebDriver getInstance() {
		return driver;
	}

	public void launchUrl(String url) {
		driver.get(url);
	}

	public void click(WebElement element) {
		element.click();
	}

	public WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element = null;
		if (locatorType.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("class")) {
			element = driver.findElement(By.className(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("tag")) {
			element = driver.findElement(By.tagName(locatorValue));
		}
		return element;

	}

	public void enterText(WebElement element, String textToEnter) {
		element.sendKeys(textToEnter);
	}
	/**
	 * In next version of framework this method will be deleted ,instead you can use enterText(String object,String textToEnter)
	 * @param locatorType
	 * @param locatorValue
	 * @param textToEnter
	 */
@Deprecated
	public void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

	public String getTitleOfPage() {
		return driver.getTitle();
	}

	public RemoteWebDriver getDriver() {
		return driver;
	}



}
