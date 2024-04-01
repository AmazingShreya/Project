package automationSuite.pageObjects;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import automationSuite.AbstractComponents.AbstractComponent;

public class SearchPage extends AbstractComponent {
	WebDriver driver;

	public SearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//input[@class='button-1 search-box-button']") 
	private WebElement searchEle;
	@FindBy(xpath = "//input[@id='small-searchterms']") 
	private WebElement searchBox;
	@FindBy(xpath = "//div[@class='search-results']//strong") 
	private WebElement searchMsg;
	@FindBy(xpath = "//div[@class='search-results']") 
	private WebElement searchResult;
	@FindBy(xpath = "//*[@class='product-title']//a") 
	private WebElement searchItem;
	@FindBy(xpath = "//input[@id='As']") 
	private WebElement searchCheckbox;
	@FindBy(xpath = "//select[@id='Cid']") 
	private WebElement searchCategory;
	@FindBy(xpath = "//input[@class='button-1 search-button']") 
	private WebElement advancedSearchEle;
	@FindBy(xpath = "//select[@id='Mid']") 
	private WebElement searchManufacturer;
	@FindBy(xpath = "//input[@id='Isc']") 
	private WebElement subCategoryCheckbox;
	@FindBy(xpath = "//input[@id='Sid']") 
	private WebElement productDescCheckbox;
	@FindBy(xpath = "//div[@class='product-grid']//div[@class='product-item']") 
	private List<WebElement> searchProducts;
	@FindBy(xpath = "//input[@id='Pf']") 
	private WebElement searchPriceFrom;
	@FindBy(xpath = "//input[@id='Pt']") 
	private WebElement searchPriceTo;
	@FindBy(xpath = "//span[@class='price actual-price']") 
	private List<WebElement> searchProductPrice;
	
	public String searchProduct(String search) {
		String msgString = null;
		try {
			if(search.equals("NoData")) {
				searchEle.click();
				Alert alert = driver.switchTo().alert();
				msgString= alert.getText();
				alert.accept();
			}
			else
			{
				searchBox.clear(); searchBox.sendKeys(search);
				searchEle.click();
				if (search.length()<=3 || search.contains("!")) {
					waitForWebElementToAppear(searchMsg);
					msgString =  searchMsg.getText();
				}
				else {
					waitForWebElementToAppear(searchResult);
					msgString = searchItem.getText();
				}
			}	
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		
		
		
		return msgString;
	}
	
	public String advancedSearchProducts(String search, String dropdown) {
		String searchText = null;
		try {
			searchBox.clear(); searchBox.sendKeys(search);
			searchEle.click();
			waitForWebElementToAppear(searchResult);
			if(searchCheckbox.isDisplayed() && !searchCheckbox.isSelected()) {
				searchCheckbox.click();
				
				Select select = null;
				if(dropdown.equals("1")) {
					waitForWebElementToAppear(searchCategory);
					select= new Select(searchCategory);
				}
				else {
					waitForWebElementToAppear(searchManufacturer);
					select = new Select(searchManufacturer);
				}
				select.selectByValue(dropdown);
				advancedSearchEle.click();
				waitForWebElementToAppear(searchMsg);
				searchText = searchMsg.getText();
			}else {
				System.out.println("Checkbox not displayed/selected without selecting");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return searchText;
	}
	
	public String advancedSearchProductsAll(String search, String dropdown, String dropdown2) {
		String searchText = null;
		try {
			searchBox.clear(); searchBox.sendKeys(search);
			searchEle.click();
			waitForWebElementToAppear(searchResult);
			if(searchCheckbox.isDisplayed() && !searchCheckbox.isSelected()) {
				searchCheckbox.click();
				waitForWebElementToAppear(searchCategory);
				Select select = new Select(searchCategory);
				select.selectByValue(dropdown);
				select = new Select(searchManufacturer);
				select.selectByValue(dropdown2);
				advancedSearchEle.click();
				
				searchText = searchItem.getText();
			}else {
				System.out.println("Checkbox not displayed/selected without selecting");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return searchText;
	}
	
	public List<WebElement> advancedSearchItem(String search, String checkbox) {
		
		WebElement ele=null;
		try {
			searchBox.clear(); searchBox.sendKeys(search);
			searchEle.click();
			waitForWebElementToAppear(searchResult);
			searchCheckbox.click();
			if(checkbox.equals("Subcategory"))
				ele = subCategoryCheckbox;
			else if(checkbox.equals("ProductDescription"))
				ele = productDescCheckbox;
			waitForWebElementToAppear(ele);			
			if(ele.isDisplayed() && !ele.isSelected()) {
				ele.click();
				advancedSearchEle.click();	
				waitForWebElementToAppear(searchItem);
			}
			else {
				System.out.println("Checkbox not displayed/selected without selecting");	
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return searchProducts;
		
	}
	
	public List<WebElement> advancedSearchPrice(String search, String priceFrom, String priceTo){
		
		try {
			searchBox.clear(); searchBox.sendKeys(search);
			searchEle.click();
			waitForWebElementToAppear(searchResult);
			searchCheckbox.click();
			
			if(priceTo==null) {
				waitForWebElementToAppear(searchPriceFrom);
				searchPriceFrom.clear(); searchPriceFrom.sendKeys(priceFrom);
			}
			else if(priceFrom==null){
				waitForWebElementToAppear(searchPriceTo);
				searchPriceTo.clear(); searchPriceTo.sendKeys(priceTo);
			}
			else {
				waitForWebElementToAppear(searchPriceFrom);
				searchPriceFrom.clear(); searchPriceFrom.sendKeys(priceFrom);
				waitForWebElementToAppear(searchPriceTo);
				searchPriceTo.clear(); searchPriceTo.sendKeys(priceTo);
			}
			advancedSearchEle.click();	
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return searchProductPrice;
	}
}
