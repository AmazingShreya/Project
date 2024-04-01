package automationSuite.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationSuite.AbstractComponents.AbstractComponent;

public class RegisterPage extends AbstractComponent {
	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//input[@id='register-button']") 
	private WebElement registerButton;
	@FindBy(xpath = "//input[@id='FirstName']") 
	private WebElement firstNameField;
	@FindBy(xpath = "//input[@id='LastName']") 
	private WebElement lastNameField;
	@FindBy(xpath = "//input[@id='Email']") 
	private WebElement emailField;
	@FindBy(xpath = "//input[@id='Password']") 
	private WebElement passwordField;
	@FindBy(xpath = "//input[@id='ConfirmPassword']") 
	private WebElement confirmPasswordField;
	private By validationMsg = By.xpath("//span[@class='field-validation-error']/span");
	@FindBy(xpath = "//div[@class='validation-summary-errors']//li") 
	private WebElement validation;
	private By genderRadioButton = By.xpath("//div[@class='gender']/input");
	
	public List<String> register() {
		List<String> errorMsgs = new ArrayList<String>();
		try {
			waitForWebElementToAppear(registerButton);
			registerButton.click();
			waitForElementToAppear(validationMsg);
			List<WebElement> ele = driver.findElements(validationMsg);
			for(WebElement i :ele ) {
				errorMsgs.add(i.getText());
			}			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return errorMsgs;
	}
	public List<String> registerOnlyName(String firstName, String lastName) {
		List<String> errorMsgs = new ArrayList<String>();
		try {
			waitForWebElementToAppear(registerButton);
			if(firstName!=null) {
				firstNameField.clear(); firstNameField.sendKeys(firstName);
			}
			if(lastName!=null) {
				lastNameField.clear(); lastNameField.sendKeys(lastName);
			}
			registerButton.click();
			waitForElementToAppear(validationMsg);
			List<WebElement> ele = driver.findElements(validationMsg);
			for(WebElement i :ele ) {
				errorMsgs.add(i.getText());
			}			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return errorMsgs;
	}
	public String registerInvalidEmail(String email) {
		String errorMsg = null ;
		try {
			waitForWebElementToAppear(registerButton);
			emailField.clear(); emailField.sendKeys(email);
			emailField.sendKeys(Keys.TAB);
			waitForElementToAppear(validationMsg);
			errorMsg = driver.findElement(validationMsg).getText();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return errorMsg;
	}
	public String registerInvalidPassword(String pass) {
		String errorMsg = null ;
		try {
			waitForWebElementToAppear(registerButton);
			passwordField.clear(); passwordField.sendKeys(pass);
			passwordField.sendKeys(Keys.TAB);
			waitForElementToAppear(validationMsg);
			errorMsg = driver.findElement(validationMsg).getText();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return errorMsg;
	}
	public String registerInvalidConfirmPassword(String pass, String confirmPass) {
		String errorMsg = null ;
		try {
			waitForWebElementToAppear(registerButton);
			passwordField.clear(); passwordField.sendKeys(pass);
			confirmPasswordField.clear(); confirmPasswordField.sendKeys(confirmPass);
			confirmPasswordField.sendKeys(Keys.TAB);
			waitForElementToAppear(validationMsg);
			errorMsg = driver.findElement(validationMsg).getText();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return errorMsg;
	}
	public List<String> invalidRegister(String firstName, String lastName, String email, String pass, String confirmPass) {
		List<String> errorMsgs = new ArrayList<String>();
		try {
			waitForWebElementToAppear(registerButton);
			if(firstName!=null) {
				firstNameField.clear(); firstNameField.sendKeys(firstName);
			}
			if(lastName!=null) {
				lastNameField.clear(); lastNameField.sendKeys(lastName);
			}
			if(email!=null) {
				emailField.clear(); emailField.sendKeys(email);
			}
			if(pass!=null) {
				passwordField.clear(); passwordField.sendKeys(pass);
			}
			if(confirmPass!=null) {
				confirmPasswordField.clear(); confirmPasswordField.sendKeys(confirmPass);
			}
			
			registerButton.click();
			
			waitForElementToAppear(validationMsg);
			List<WebElement> ele = driver.findElements(validationMsg);
			for(WebElement i :ele ) {
				errorMsgs.add(i.getText());
			}			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return errorMsgs;
	}
	public String Register(String firstName, String lastName, String email, String pass, String confirmPass) {
		String errorMsgs =null;
		try {
			waitForWebElementToAppear(registerButton);

			firstNameField.clear(); firstNameField.sendKeys(firstName);

			lastNameField.clear(); lastNameField.sendKeys(lastName);

			emailField.clear(); emailField.sendKeys(email);

			passwordField.clear(); passwordField.sendKeys(pass);

			confirmPasswordField.clear(); confirmPasswordField.sendKeys(confirmPass);
			
			registerButton.click();
			
			waitForWebElementToAppear(validation);
			errorMsgs = validation.getText()	;		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return errorMsgs;
	}
	
	public Boolean SelectGender() {
		try {
			waitForWebElementToAppear(registerButton);
			List<WebElement> ele = driver.findElements(genderRadioButton);
			for (int i = 0; i < ele.size(); i++) 
			{
				if(!ele.get(i).isSelected()) {
					ele.get(i).click();		
				}
			}
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return false;
	}

}
