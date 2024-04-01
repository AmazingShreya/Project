package automationSuite.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationSuite.AbstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//input[@class='button-1 login-button']") 
	private WebElement loginButton;
	@FindBy(xpath = "//div[@class='message-error']//span") 
	private WebElement errorWarning;
	@FindBy(xpath = "//div[@class='message-error']//li") 
	private WebElement emailWarning;
	@FindBy(xpath = "//input[@id='Email']") 
	private WebElement emailField;
	@FindBy(xpath = "//input[@id='Password']") 
	private WebElement passwordField;
	@FindBy(xpath = "//span[@class='field-validation-error']/span") 
	private WebElement emailInvalid;
	@FindBy(xpath = "//a[@class='account']") 
	private WebElement account;
	@FindBy(xpath = "//input[@id='RememberMe']") 
	private WebElement rememberMe;
	@FindBy(xpath = "//a[@class='ico-logout']") 
	private WebElement logOut;
	@FindBy(xpath = "//a[@class='ico-register']") 
	private WebElement logOutCheck;
	
	public List<String> login() {
		List<String> errorMsgs = null;
		try {
			waitForWebElementToAppear(loginButton);
			loginButton.click();
			waitForWebElementToAppear(errorWarning);
			waitForWebElementToAppear(emailWarning);
			errorMsgs = new ArrayList<String>();
			errorMsgs.add(errorWarning.getText());
			errorMsgs.add(emailWarning.getText());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return errorMsgs;
	}
	
	public String login(String email) {
		String errorMsgs = null;
		try {
			waitForWebElementToAppear(loginButton);
			emailField.clear();
			emailField.sendKeys(email);
			loginButton.click();
			waitForWebElementToAppear(emailInvalid);
			errorMsgs = emailInvalid.getText();			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return errorMsgs;
	}
	public List<String> login(String email, String password) {
		List<String> errorMsgs = null;
		try {
			waitForWebElementToAppear(loginButton);
			emailField.clear();
			emailField.sendKeys(email);
			if(password!=null) {
				passwordField.clear();
				passwordField.sendKeys(password);
			}
			loginButton.click();
			waitForWebElementToAppear(errorWarning);
			waitForWebElementToAppear(emailWarning);
			errorMsgs = new ArrayList<String>();
			errorMsgs.add(errorWarning.getText());
			errorMsgs.add(emailWarning.getText());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return errorMsgs;
	}
	
	public String successfulLogin(String email, String password, boolean rememberme) {
		String loginCheck = null;
		try {
			waitForWebElementToAppear(loginButton);
			emailField.clear();
			emailField.sendKeys(email);
			passwordField.clear();
			passwordField.sendKeys(password);
			if(rememberme==true) {
				rememberMe.click();
			}
			loginButton.click();
			waitForWebElementToAppear(account);
			loginCheck = account.getText();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		
		return loginCheck;
		}
	
	public String logout(String email, String password) {
		String logoutCheck = null;
		try {
			successfulLogin(email, password, false);
			waitForWebElementToAppear(logOut);
			logOut.click();
			waitForWebElementToAppear(logOutCheck);
			logoutCheck = logOutCheck.getText();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		
		return logoutCheck;
	}
	

}
