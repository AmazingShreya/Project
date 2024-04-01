package automationSuite.testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import automationSuite.pageObjects.BlogPage;
import automationSuite.pageObjects.CartPage;
import automationSuite.pageObjects.DemoWebShopPage;
import automationSuite.pageObjects.ForgetPasswordPage;
import automationSuite.pageObjects.LoginPage;
import automationSuite.pageObjects.RegisterPage;
import automationSuite.pageObjects.SearchPage;
import lombok.Builder.Default;

public class BaseTest {

	public WebDriver driver;
	public DemoWebShopPage demoWebShopPage;
	public SearchPage searchPage;
	public BlogPage blogPage;
	public LoginPage loginPage;
	public ForgetPasswordPage forgetPasswordPage;
	public RegisterPage registerPage;
	public CartPage cartPage;
	String browserName;
	String url;
	

	public WebDriver initializeDriver() throws IOException {
		//reading browser type and url from GlobalData.properties file
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src/main/java/automationSuite/resources/GlobalData.properties");
		prop.load(fis); 
		//System.out.println(System.getProperty("user.dir"));
		browserName = prop.getProperty("browser");
		url=prop.getProperty("url");
		
		
		//Initializing driver based on browser
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();			
		}		
		else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		return driver;
		
	}
	
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		//method to capture screenshot
		
	}
	
	public String getTestData(String testCaseName) {
		//method to read test data
		String testData = null;
		 FileInputStream inputStream;
		 XSSFWorkbook workbook = null;
		try {
			inputStream = new FileInputStream("C:\\Users\\Shreya\\Desktop\\Project\\SCDLProject\\src\\test\\java\\automationSuite\\data\\TestData.xlsx");
			workbook = new XSSFWorkbook(inputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		 XSSFSheet sheet=workbook.getSheet("TestData");
		 
		 for(int i=0;i<=sheet.getLastRowNum()-sheet.getFirstRowNum();i++) {
			 
			 if(testCaseName.equalsIgnoreCase(sheet.getRow(i).getCell(0).getStringCellValue().trim())){
				 testData = sheet.getRow(i).getCell(1).getStringCellValue().trim();
			 }
		 }

		 return testData;
		
	}
	
	public String getTestData(String testCaseName, int col)  {
		//method to read test data
		String testData = null;
		FileInputStream inputStream ;
		XSSFWorkbook workbook = null;
		try {
			inputStream = new FileInputStream("C:\\Users\\Shreya\\Desktop\\Project\\SCDLProject\\src\\test\\java\\automationSuite\\data\\TestData.xlsx");
			workbook = new XSSFWorkbook(inputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 XSSFSheet sheet=workbook.getSheet("TestData");
		 
		 for(int i=0;i<=sheet.getLastRowNum()-sheet.getFirstRowNum();i++) {
			 
			 if(testCaseName.equalsIgnoreCase(sheet.getRow(i).getCell(0).getStringCellValue().trim())){
				 testData = sheet.getRow(i).getCell(col).getStringCellValue().trim();
			 }
		 }

		 return testData;
		
	}
	
	public SearchPage launchSearchPage() {
		searchPage = new SearchPage(driver);
		return searchPage;
		}
	public BlogPage launchBlogPage() {
		blogPage = new BlogPage(driver);
		return blogPage;
		}
	public LoginPage launchLoginPage() {
		loginPage = new LoginPage(driver);
		demoWebShopPage.navigateToRequiredPage("Login");
		return loginPage;
	}
	public ForgetPasswordPage launchForgetPasswordPage() {
		forgetPasswordPage = new ForgetPasswordPage(driver);
		demoWebShopPage.navigateToRequiredPage("Login");
		return forgetPasswordPage;
	}
	public RegisterPage launchRegisterPage() {
		registerPage = new RegisterPage(driver);
		demoWebShopPage.navigateToRequiredPage("Register");
		return registerPage;
	}
	public CartPage launchCartPage() {
		cartPage = new CartPage(driver);
		return cartPage;
		}
	@BeforeMethod(alwaysRun=true)
	public DemoWebShopPage launchApplication() throws IOException
	{
		
		 driver = initializeDriver();
		 demoWebShopPage = new DemoWebShopPage(driver);
		 demoWebShopPage.navigateToMainPage(url);
		 return demoWebShopPage;	
		
	}
	
	@AfterMethod(alwaysRun=true)	
	public void tearDown()
	{
		driver.quit();
		//close chrome after every test case execution
	}
	
	
}
