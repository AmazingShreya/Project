package automationSuite.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		//child class will send driver to parent class here
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void waitForElementToAppear(By findByEle) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(900));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findByEle));

	}
	
	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(900));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}
	
	public void waitForTextToAppear(WebElement findBy, String msg) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(900));
		wait.until(ExpectedConditions.textToBePresentInElement(findBy,msg));

	}
	
	public void waitForWebElementToDisappear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(900));
		wait.until(ExpectedConditions.invisibilityOf(findBy));

	}

}
