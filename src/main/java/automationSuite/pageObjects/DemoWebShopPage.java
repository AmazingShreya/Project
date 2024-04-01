package automationSuite.pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationSuite.AbstractComponents.AbstractComponent;

public class DemoWebShopPage extends AbstractComponent {
	
WebDriver driver;
	
	public DemoWebShopPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="userEmail") // sample to be deleted
	WebElement userEmail;
	
	private By login = By.xpath("//a[text()='Log in']");
	private By register = By.xpath("//a[text()='Register']");
	private By cart = By.xpath("//a[text()='Shopping cart']");
	private By wishlist = By.xpath("//a[text()='Wishlist']");
	private By contact = By.xpath("//a[text()='Contact us']");
	private By shippingReturns = By.xpath("//a[text()='Shipping & Returns']");
	private By featureProducts = By.xpath("//div[@class='product-grid home-page-product-grid']//strong");
	private By communityPoll = By.xpath("//div[@class='block block-poll']//strong");
	private By newsletter = By.xpath("//div[@class='block block-newsletter']//strong");
	private By category = By.xpath("//div[@class='block block-category-navigation']//strong");
	private By newProduct = By.xpath("//a[@href='/newproducts']");
	private By compareProduct = By.xpath("//a[@href='/compareproducts']");
	private By news = By.xpath("//a[@href='/news']");
	private By blog = By.xpath("//a[@href='/blog']");
	private By recentlyViwewed = By.xpath("//a[text()='Recently viewed products']");
	private By categoryHeader = By.xpath("//div[@class='header-menu']//a[@href='/computers']");
	private By subCategoryHeader = By.xpath("//div[@class='header-menu']//a[@href='/desktops']");
	private By homePage = By.xpath("//a[@href='/']");
	
	
	@FindBy(xpath = "//div[@class='block block-manufacturer-navigation']//strong") 
	private WebElement manufacturer;
	@FindBy(xpath = "//div[@class='block block-popular-tags']//strong") 
	private WebElement popTag;
	@FindBy(xpath = "//span[@class='cart-qty']") 
	private WebElement cartQty;
	@FindBy(xpath = "//span[@class='wishlist-qty']") 
	private WebElement wishlistQty;
	//@FindBy(xpath = "//a[@href='/producttag/13/camera']") 
	//private WebElement popLink;
	private By popLink = By.xpath("//a[@href='/producttag/13/camera']");
	@FindBy(xpath = "//div[@class='page product-tag-page']//h1") 
	private WebElement popLinkEle;
	@FindBy(xpath = "//div[@class='product-grid']") 
	private WebElement popLinkGrid;
	
	private By popLinkViewAll = By.xpath("//a[@href='/producttag/all']");
	@FindBy(xpath = "//div[@class='page product-tags-all-page']//h1") 
	private WebElement popLinkEleAll;
	@FindBy(xpath = "//ul[@class='product-tags-list']") 
	private WebElement popLinkGridAll;
	
	private By categorylink = By.xpath("//div[@class='listbox']//a[@href='/computers']");
	@FindBy(xpath = "//div[@class='item-box']") 
	private WebElement categoryLinkProduct;
	@FindBy(xpath = "//div[@class='page category-page']//h1") 
	private WebElement categoryLinkProductHeader;
	private By subCategorylink = By.xpath("//div[@class='listbox']//a[@href='/notebooks']");
	
	
	@FindBy(xpath = "//div[@class='header-menu']//a[@href='/computers']") 
	private WebElement categoryHeaderele;
	@FindBy(xpath = "//h2[@class='product-title']/a") 
	private WebElement recentlyViewedProduct;
	@FindBy(xpath = "//a[text()='YouTube']") 
	private WebElement youtube;
	@FindBy(xpath = "//div[@id='text-container']") 
	private WebElement youtubeView;
	@FindBy(xpath = "//div[@id='newsletter-subscribe-block']/span") 
	private WebElement subscribeGrid;
	@FindBy(xpath = "//input[@id='newsletter-email']") 
	private WebElement subscribeEmail;
	@FindBy(xpath = "//input[@id='newsletter-subscribe-button']") 
	private WebElement subscribeEle;
	@FindBy(xpath = "//div[@id='newsletter-result-block']") 
	private WebElement subscribeMsg;
	
	public void navigateToMainPage(String url) {
		driver.get(url);	// navigate to main URL of website		
	}
	
	public void navigateToRequiredPage(String pageName) {
		// navigate to required by passing parameter
		
		By ele = null;
		try {
		switch (pageName) {
		case "Login":
			ele = login;
			break;
		case "Register":
			ele=register;
			break;
		case "Cart":
			ele=cart;
			break;
		case "Wishlist":
			ele=wishlist;
			break;
		case "Contact":
			ele=contact;
			break;
		case "ShippingReturns":
			ele=shippingReturns;
			break;
		case "PopularLink":
			ele=popLink;
			break;
		case "PopularLinkViewAll":
			ele=popLinkViewAll;
			break;
		case "CategoryLink":
			ele=categorylink;
			break;
		case "SubCategoryLink":
			ele=subCategorylink;
			break;
		case "CategoryHeader":
			ele=categoryHeader;
			break;
		case "SubCategoryHeader":
			ele=subCategoryHeader;
			break;
		case "HomePage":
			ele=homePage;
			break;
		case "NewProduct":
			ele=newProduct;
			break;
		case "CompareProducts":
			ele=compareProduct;
			break;
		case "News":
			ele=news;
			break;
		case "Blog":
			ele=blog;
			break;
		case "RecentlyViewed":
			ele=recentlyViwewed;
			break;
		default:
			System.out.println("Screen name is invalid");
			break;
		}
		
			driver.findElement(ele).click(); //check if page link is working
			Thread.sleep(50);
		}
			catch (Exception e) {
			System.out.println("Some exception occured");
			e.printStackTrace();
		}		
		
	}
	
	public String returnText(String itemName) {
		String textname = null;
		try {
			switch (itemName) {
			case "Featured":
				textname = driver.findElement(featureProducts).getText();
				break;
			case "CommunityPoll":
				textname = driver.findElement(communityPoll).getText();
				break;
			case "Newsletter":
				textname = driver.findElement(newsletter).getText();
				break;
			case "Category":
				textname = driver.findElement(category).getText();
				break;
			case "Manufacturer":
				textname = manufacturer.getText();
				break;
			case "PopularTag":
				textname = popTag.getText();
				break;
			case "CartQuantity":
				textname = cartQty.getText();
				break;
			case "WishlistQuantity":
				textname = wishlistQty.getText();
				break;
			case "PopularLink":
				textname = popLinkEle.getText();
				break;
			case "PopularLinkViewAll":
				textname = popLinkEleAll.getText();
				break;
			case "CategoryLink":
				textname = categoryLinkProductHeader.getText();
				break;
			case "SubCategoryLink":
				textname = categoryLinkProductHeader.getText();
				break;
			case "CategoryHeader":
				textname = categoryLinkProductHeader.getText();
				break;
			case "SubCategoryHeader":
				textname = categoryLinkProductHeader.getText();
				break;
			case "Subscribe":
				textname =subscribeGrid.getText();
				break;
			default:
				System.out.println("Invalid name");
				break;
			}
			
		} catch (Exception e) {
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		
		return textname;
		
	}
	
	public WebElement checkPopularLink(String popLink) throws InterruptedException {
		navigateToRequiredPage(popLink);
		if(popLink.contains("All")) {
			waitForWebElementToAppear(popLinkEleAll);
			return popLinkGridAll;
		}
		else {
			waitForWebElementToAppear(popLinkEle);
			return popLinkGrid;
		}		
	}
	
	public WebElement checkCategory(String category) throws InterruptedException {
		navigateToRequiredPage(category);
		waitForWebElementToAppear(categoryLinkProduct);
		return categoryLinkProduct;
	}
	
	public WebElement checkSubCategory(String subCategory) {
		try {
			if(subCategory.contains("Link")) {
				checkCategory("CategoryLink");
				navigateToRequiredPage(subCategory);
				waitForWebElementToAppear(categoryLinkProduct);
			}
			else {
				Actions action = new Actions(driver);
				action.moveToElement(categoryHeaderele).perform();
				waitForElementToAppear(subCategoryHeader);
				navigateToRequiredPage(subCategory);
				waitForWebElementToAppear(categoryLinkProduct);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return categoryLinkProduct;
	}
	
	public String navigateToRecentlyViewed(String product) {
		String text = null;
		try {
			WebElement ele_product = driver.findElement(By.xpath("//a[text()='"+product+"']"));
			ele_product.click();
			navigateToRequiredPage("RecentlyViewed");
			waitForWebElementToAppear(recentlyViewedProduct);
			text = recentlyViewedProduct.getText();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return text;
	}
	
	public String navigateToYoutube() {
		String text = null;
		try {
			youtube.click();
			String currentWindowHandle = driver.getWindowHandle();
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        
	        Iterator<String> iterator = allWindowHandles.iterator();
	        while (iterator.hasNext()) {
	            String ChildWindow = iterator.next();
	                if (!currentWindowHandle.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
	                
	            }
	        }
	        waitForWebElementToAppear(youtubeView);
	        text=driver.getTitle();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		
		return text;
	}
	
	public String subscribe(String email, String msg) {
		String text = null;
		try {
			waitForWebElementToAppear(subscribeEle);
			subscribeEmail.clear();
			subscribeEmail.sendKeys(email);
			subscribeEle.click();
			waitForTextToAppear(subscribeMsg, msg);
			text = subscribeMsg.getText();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return text;
	}

}

