package automationSuite.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationSuite.AbstractComponents.AbstractComponent;

public class BlogPage extends AbstractComponent {
	WebDriver driver;
	
	public BlogPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//div[@class='page blog-page']//h1") 
	private WebElement blogHeader;
	@FindBy(xpath = "//div[@class='post-body']/p") 
	private WebElement blogBody;

	
	public String navigateToBlogTag(String tag) {
		String text=null;
		try {
			WebElement ele = driver.findElement(By.xpath("//a[@href='/blog/tag/"+tag+"']"));
			ele.click();
			waitForWebElementToAppear(blogHeader);
			text = blogHeader.getText();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return text;
	}
	
	public String navigateToArchive(String tag) {
		String text=null;
		try {
			WebElement ele = driver.findElement(By.xpath("//a[@href='/blog/"+tag+"']"));
			ele.click();
			waitForWebElementToAppear(blogHeader);
			text = blogHeader.getText();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
		return text;
	}
	public String navigateToABlog(String tag) {
		String text=null;
		try {
			WebElement ele = driver.findElement(By.xpath("//a[text()='"+tag+"']"));
			ele.click();
			waitForWebElementToAppear(blogBody);
			text = blogBody.getText();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception occured");
			e.printStackTrace();
		}

		return text;
	}

}
