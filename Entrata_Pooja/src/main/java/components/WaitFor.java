package components;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


// This class contains different waits.
public class WaitFor {

	Keywords keyword= new Keywords();
	private static final WebDriverWait wait;
	static {
		wait = new WebDriverWait(Keywords.driver, Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofMillis(500));
	}

	public static void visiblityOfElement(WebElement element, int duration) {
		wait.withTimeout(Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
public static void normalWait() {
	wait.withTimeout(Duration.ofSeconds(30));
	
}
	public static void stalenessOf(WebElement element, int duration) {
		wait.withTimeout(Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.stalenessOf(element));
	}
	/**
	 * This method waits for element to be clicable , max time is 30 seconds which is not configurable
	 * @param element
	 * @param duration
	 */
	public static  void elementToBeClickable(WebElement element) {
		wait.withTimeout(Duration.ofSeconds(30));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}

