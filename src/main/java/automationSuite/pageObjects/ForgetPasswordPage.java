package automationSuite.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationSuite.AbstractComponents.AbstractComponent;

public class ForgetPasswordPage extends AbstractComponent {
	WebDriver driver;

	public ForgetPasswordPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//a[text()='Forgot password?']") 
	private WebElement forgetPass;
	@FindBy(xpath = "//input[@class='button-1 password-recovery-button']") 
	private WebElement recover;
	@FindBy(xpath = "//span[@class='field-validation-error']/span") 
	private WebElement errorMsg;
	@FindBy(xpath = "//input[@id='Email']") 
	private WebElement email;
	@FindBy(xpath = "//div[@class='result']") 
	private WebElement resultMsg;
	
	public void navigateToForgetPassword() {
		
		try {
			forgetPass.click();
			waitForWebElementToAppear(recover);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
	}
	
	public String recoverPassword() {
		String msg = null;
		try {
			navigateToForgetPassword();
			recover.click(); waitForWebElementToAppear(errorMsg);
			msg = errorMsg.getText();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return msg;
	}
	
	public String recoverPassword(String emailValue) {
		String msg = null;
		try {
			navigateToForgetPassword();
			email.clear(); email.sendKeys(emailValue);
			recover.click();
			if(emailValue.contains("@")) {
				waitForWebElementToAppear(resultMsg);
				msg = resultMsg.getText();
			}
			else {
				waitForWebElementToAppear(errorMsg);
				msg = errorMsg.getText();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return msg;
	}

}
