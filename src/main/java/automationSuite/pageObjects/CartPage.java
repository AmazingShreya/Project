package automationSuite.pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.naming.TimeLimitExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import automationSuite.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//div[@class='ajax-loading-block-window']") 
	private WebElement spinner;
	@FindBy(xpath = "//span[@class='close']") 
	private WebElement spinnerClose;
	@FindBy(xpath = "//span[@class='cart-label']") 
	private WebElement goToCart;
	@FindBy(xpath = "(//input[@class='button-2 product-box-add-to-cart-button'])[2]") 
	private WebElement productAddToCart;
	@FindBy(xpath = "//input[@name='discountcouponcode']") 
	private WebElement discountCode;
	@FindBy(xpath = "//input[@name='applydiscountcouponcode']") 
	private WebElement discount;
	@FindBy(xpath = "//input[@name='giftcardcouponcode']") 
	private WebElement giftcardCode;
	@FindBy(xpath = "//input[@name='applygiftcardcouponcode']") 
	private WebElement giftcard;
	@FindBy(xpath = "//div[@class='message']") 
	private WebElement message;
	@FindBy(xpath = "//span[@class='cart-qty']") 
	private WebElement cartQty;
	@FindBy(xpath = "//input[@class='button-1 cart-button']") 
	private WebElement goToCartButton;
	@FindBy(xpath = "//div[@class='page-title']/h1") 
	private WebElement cartHeader;
	
	public void addItemToCart() {
		int count = 0;
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");
			waitForWebElementToAppear(productAddToCart);
			productAddToCart.click();
			js.executeScript("window.scrollBy(0,-350)", "");
			do {
				count++;
				waitForWebElementToDisappear(spinnerClose);
				if(count>500)
					throw new TimeLimitExceededException(); 
				
			} while (!spinner.getAttribute("style").contains("display: none"));
			goToCart.click();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
	}
	
	public String applyCouponCode(String inputDiscountCode) {
		addItemToCart();
		String textMessage = null;
		try {
			waitForWebElementToAppear(discountCode);
			discountCode.clear(); discountCode.sendKeys(inputDiscountCode);
			discount.click();
			textMessage = message.getText();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return textMessage;
	}
	
	public String applyGiftCard(String inputGiftCard) {
		addItemToCart();
		String textMessage = null;
		try {
			waitForWebElementToAppear(giftcardCode);
			giftcardCode.clear(); giftcardCode.sendKeys(inputGiftCard);
			giftcard.click();
			textMessage = message.getText();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return textMessage;
	}
	
	public String checkCartQuantity() {
		String qty = null;
		addItemToCart();
		try {
			waitForWebElementToAppear(cartQty);
			Actions actions = new Actions(driver);
			actions.moveToElement(cartQty).build().perform();
			qty = cartQty.getText();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return qty;
	}
	public String goToCart() {
		String header=null;
		try {
			checkCartQuantity();
			waitForWebElementToAppear(goToCartButton);
			goToCart.click();
			waitForWebElementToAppear(cartHeader);
			header = cartHeader.getText();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return header;
	}

}
