package Tests;




import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import components.BaseClass;
import components.Keywords;
import components.WaitFor;

public class HomePageTest extends BaseClass{	
	Keywords keyword= new Keywords();
	
//This method will verify the Watch Demo tab if it is opening the page .
	@Test
	public void verifywatchDemoTab()  {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		keyword.getWebElement("css", "a#cookie-accept").click();
		 //driver.findElement(By.cssSelector("a#cookie-accept")).click();
		 System.out.println("accepted cookie");
		WaitFor.normalWait();
		WebElement watchDemoTab=keyword.getWebElement("xpath", "(//a[contains(@href,'watch-demo')])[1]");
		js.executeScript("arguments[0].scrollIntoView(true);",watchDemoTab);
		action.moveToElement(watchDemoTab).click().build().perform();
		WaitFor.normalWait();
		WebElement propertyManagemnetTitle= driver.findElement(By.xpath("//h1[contains( text(),'Optimize Property Management with One Platform')]"));
		System.out.println(driver.getTitle());
	Assert.assertTrue(propertyManagemnetTitle.isDisplayed()); 
	}
	//This method will verify if all fields of SChedule demo are available to fill.
	// not added functionality to submit as it is mentioned in mail to avoid form submission 
	@Test
	public void fillWatchDemoForm()  {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		keyword.getWebElement("css", "a#cookie-accept").click();
		 System.out.println("accepted cookie");
		WaitFor.normalWait();
		WebElement watchDemoTab=keyword.getWebElement("xpath", "(//a[contains(@href,'watch-demo')])[1]");
		js.executeScript("arguments[0].scrollIntoView(true);",watchDemoTab);
		action.moveToElement(watchDemoTab).click().build().perform();
		WaitFor.normalWait();
		keyword.getWebElement("css","input#FirstName").sendKeys("Pooja");
		keyword.getWebElement("css","input#LastName").sendKeys("Chandodkar");
		keyword.getWebElement("css","input#Phone").sendKeys("9584562311");
		keyword.getWebElement("css","input#Email").sendKeys("PoojaChandodkar30@gmail.com");
		keyword.getWebElement("css","input#Company").sendKeys("abcs");
		keyword.getWebElement("css","input#Title").sendKeys("SDET");
		WebElement unitCount= driver.findElement(By.cssSelector("select#Unit_Count__c"));
		Select select = new Select(unitCount);
		select.selectByValue("11 - 100");
		WebElement iAm= driver.findElement(By.cssSelector("select#demoRequest"));
		Select selectiAm = new Select(iAm);
		selectiAm.selectByValue("a Resident");
		
	}
	// Below testcase will verify if we enter wrong username or passwaord then the error message is displaying 
	@Test
	public void verifyWrongSignIn() {
		Actions action = new Actions(driver);
		JavascriptExecutor js= (JavascriptExecutor) keyword.getDriver();
		WaitFor.elementToBeClickable( driver.findElement(By.cssSelector("a#cookie-accept")));
		 driver.findElement(By.cssSelector("a#cookie-accept")).click();
		 System.out.println("accepted cookie");
		WaitFor.normalWait();
		WebElement SignInTab= driver.findElement(By.xpath("//a[contains(@href,'sign-in')]"));
		js.executeScript("arguments[0].scrollIntoView(true);",SignInTab);	
		action.moveToElement(SignInTab).click().build().perform();
		WaitFor.normalWait();
		WebElement propertyManagemnetLogin= driver.findElement(By.xpath("//a[contains(@href,'sso.entrata.com')]"));
		js.executeScript("arguments[0].scrollIntoView(true);",propertyManagemnetLogin);
		action.moveToElement(propertyManagemnetLogin).click().build().perform();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@id='entrata-username']")).sendKeys("pooja");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123");
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		String errorMsg; 
		 errorMsg=driver.findElement(By.xpath("//p[@id='statusMessage']")).getText();
System.out.println(errorMsg);
Assert.assertEquals(errorMsg,"The username and password provided are not valid. Please try again.");

	}
	// This Test will verify if the Resident LogIn tab is working or not 
	@Test
	public void verifyResidentLogInTab() {
		Actions action = new Actions(driver);
		JavascriptExecutor js= (JavascriptExecutor) keyword.getDriver();
		WaitFor.elementToBeClickable( driver.findElement(By.cssSelector("a#cookie-accept")));
		 driver.findElement(By.cssSelector("a#cookie-accept")).click();
		 System.out.println("accepted cookie");
		WaitFor.normalWait();
		WebElement SignInTab= driver.findElement(By.xpath("//a[contains(@href,'sign-in')]"));
		js.executeScript("arguments[0].scrollIntoView(true);",SignInTab);	
		action.moveToElement(SignInTab).click().build().perform();
		WaitFor.normalWait();
		WebElement residentLoginTab= driver.findElement(By.xpath("//a[contains(@href,'residentportal.com' )][div]"));
		js.executeScript("arguments[0].scrollIntoView(true);",residentLoginTab);
		action.moveToElement(residentLoginTab).click().build().perform();
		Assert.assertEquals(driver.getTitle(),"Welcome to the Resident Portal App");
		
	}
}
