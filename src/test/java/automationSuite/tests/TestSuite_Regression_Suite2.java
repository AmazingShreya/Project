package automationSuite.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import automationSuite.testComponents.BaseTest;
@Listeners(automationSuite.testComponents.Listeners.class)
public class TestSuite_Regression_Suite2 extends BaseTest{
	
	@Test 
	public void TC23_Search_NoData() throws IOException{
		//TC23_Search_NoData
		launchSearchPage();
		String expectedValue= getTestData("TC23",2);
		String actualValue = searchPage.searchProduct(getTestData("TC23"));
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, expectedValue, "Search alert is loaded");	
		
	}
	
	@Test 
	public void TC24_Search_LessData() throws IOException{
		//TC24_Search_LessData
		launchSearchPage();
		String expectedValue= getTestData("TC24",2);
		String actualValue = searchPage.searchProduct(getTestData("TC24"));
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, expectedValue, "Search with less data is loaded");	
		
	}
	@Test 
	public void TC25_Search_WrongData() throws IOException{
		//TC25_Search_WrongData
		launchSearchPage();
		String expectedValue= getTestData("TC25",2);
		String actualValue = searchPage.searchProduct(getTestData("TC25"));
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, expectedValue, "Search with wrong data is loaded");	
		
	}
	@Test 
	public void TC26_Search_CorrectData() throws IOException{
		//TC26_Search_CorrectData
		launchSearchPage();
		String expectedValue= getTestData("TC26",2);
		String actualValue = searchPage.searchProduct(getTestData("TC26"));
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, expectedValue, "Search with correct is loaded");	
		
	}
	@Test 
	public void TC27_AdvancedSearch_WrongCategory() throws IOException{
		//TC27_AdvancedSearch_WrongCategory
		launchSearchPage();
		String expectedValue= getTestData("TC27",3);
		String actualValue = searchPage.advancedSearchProducts(getTestData("TC27"), getTestData("TC27",2));
		System.out.println(actualValue);	
		Assert.assertEquals(actualValue, expectedValue, "Advanced Search with wrong data is loaded");	
	}
	@Test 
	public void TC28_AdvancedSearch_WrongCatManufac() throws IOException{
		//TC28_AdvancedSearch_WrongCategoryManufac
		launchSearchPage();
		String expectedValue= getTestData("TC28",3);
		String actualValue = searchPage.advancedSearchProducts(getTestData("TC28"), getTestData("TC28",2));
		System.out.println(actualValue);	
		Assert.assertEquals(actualValue, expectedValue, "Advanced Search with wrong data is loaded");	
	}
	@Test 
	public void TC29_AdvancedSearch_AllData() throws IOException{
		//TC29_AdvancedSearch_AllData
		launchSearchPage();
		String expectedValue= getTestData("TC29",4);
		String actualValue = searchPage.advancedSearchProductsAll(getTestData("TC29"), getTestData("TC29",2),getTestData("TC29",3) );
		System.out.println(actualValue);	
		Assert.assertEquals(actualValue, expectedValue, "Advanced Search with correct data is loaded");	
	}
	
	@Test 
	public void TC30_AdvancedSearch_Subcategory() throws IOException{
		//TC30_AdvancedSearch_Subcategory
		launchSearchPage();
		List<WebElement> element = searchPage.advancedSearchItem(getTestData("TC30"),getTestData("TC30",2));
		System.out.println(element);	
		Assert.assertFalse(element.isEmpty(), "Advanced Search with subcategory is loaded");
	}
	@Test 
	public void TC31_AdvancedSearch_ProductDescription() throws IOException{
		//TC31_AdvancedSearch_ProductDescription
		launchSearchPage();
		List<WebElement> element = searchPage.advancedSearchItem(getTestData("TC31"),getTestData("TC31",2));
		System.out.println(element);
		Assert.assertFalse(element.isEmpty(), "Advanced Search with product description is loaded");
	}
	@Test 
	public void TC32_AdvancedSearch_FromPrice() throws IOException{
		//TC32_AdvancedSearch_FromPrice
		launchSearchPage();
		List<WebElement> element = searchPage.advancedSearchPrice(getTestData("TC32"),getTestData("TC32",2),null);
		
		for(int i =0; i<element.size();i++) {
			System.out.println(Double.parseDouble(element.get(i).getText()));
			if(Double.parseDouble(element.get(i).getText())>=Long.parseLong(getTestData("TC32",2))) {
				Assert.assertTrue(true, "Advanced Search with from price is loaded");

			}
			else {
				Assert.assertTrue(false, "Advanced Search with from price is not loaded");
			}
		}
	}
	
	@Test 
	public void TC33_AdvancedSearch_ToPrice() throws IOException{
		//TC33_AdvancedSearch_ToPrice
		launchSearchPage();
		List<WebElement> element = searchPage.advancedSearchPrice(getTestData("TC33"),null,getTestData("TC33",2));

		for(int i =0; i<element.size();i++) {
			System.out.println(Double.parseDouble(element.get(i).getText()));
			if(Double.parseDouble(element.get(i).getText())<=Long.parseLong(getTestData("TC33",2))) {
				Assert.assertTrue(true, "Advanced Search with to price is loaded");

			}
			else {
				Assert.assertTrue(false, "Advanced Search with to price is not loaded");
			}
		}
	}
	@Test 
	public void TC34_AdvancedPrice_FromToPrice() throws IOException{
		//TC34_AdvancedPrice_FromToPrice
		launchSearchPage();
		List<WebElement> element = searchPage.advancedSearchPrice(getTestData("TC34"),getTestData("TC34",2),getTestData("TC34",3));

		for(int i =0; i<element.size();i++) {
			System.out.println(Double.parseDouble(element.get(i).getText()));
			if(Double.parseDouble(element.get(i).getText())>=Long.parseLong(getTestData("TC34",2)) && Double.parseDouble(element.get(i).getText())<=Long.parseLong(getTestData("TC34",3))) {
				Assert.assertTrue(true, "Advanced Search with from to price is loaded");

			}
			else {
				Assert.assertTrue(false, "Advanced Search with from to price is not loaded");
			}
		}
	}
	@Test
	public void TC39_BlogTagsLink() throws IOException, InterruptedException{
		//TC39_BlogTagsLink
		String expectedText= getTestData("TC39",3);
		String page = getTestData("TC39");
		demoWebShopPage.navigateToRequiredPage(page);
		launchBlogPage();
		String actualText = blogPage.navigateToBlogTag(getTestData("TC39",2));
		
		System.out.println(actualText);
		Assert.assertEquals(actualText, expectedText, "blog tag page is loaded");	
	}
	@Test
	public void TC40_BlogArchiveTags_Link() throws IOException, InterruptedException{
		//TC40_BlogArchiveTags_Link
		String expectedText= getTestData("TC40",3);
		String page = getTestData("TC40");
		demoWebShopPage.navigateToRequiredPage(page);
		launchBlogPage();
		String actualText = blogPage.navigateToArchive(getTestData("TC40",2));
		
		System.out.println(actualText);
		Assert.assertEquals(actualText, expectedText, "blog archive tag page is loaded");	
	}
	
	@Test
	public void TC41_CheckIfABlogIsLoaded() throws IOException, InterruptedException{
		//TC41_CheckIfABlogIsLoaded
		String expectedText= getTestData("TC41",3);
		String page = getTestData("TC41");
		demoWebShopPage.navigateToRequiredPage(page);
		launchBlogPage();
		String actualText = blogPage.navigateToABlog(getTestData("TC41",2));
		
		System.out.println(actualText);
		Assert.assertEquals(actualText, expectedText, "blog page is loaded");	
	}
	@Test
	public void TC42_CheckRecentlyViewedProduct() throws InterruptedException , IOException{
		//TC42_CheckRecentlyViewedProduct
		String expectedTitle= getTestData("TC42");
		String actualTitle = demoWebShopPage.navigateToRecentlyViewed(getTestData("TC42"));
		
		
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "Recently Viewed page is working");	
	}
	@Test
	public void TC46_LoginPage_ForgetPasswordWithoutEmail() {
		//TC46_LoginPage_ForgetPasswordWithoutEmail
		String expectedMsg= getTestData("TC46");
		launchForgetPasswordPage();
		String actualMsg = forgetPasswordPage.recoverPassword();
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg, "Forget password warning is working");	
	}
	@Test
	public void TC47_LoginPage_ForgetPasswordWithInvalidEmail() {
		//TC47_LoginPage_ForgetPasswordWithInvalidEmail
		String expectedMsg= getTestData("TC47",2);
		launchForgetPasswordPage();
		String actualMsg = forgetPasswordPage.recoverPassword(getTestData("TC47"));
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg, "Forget password warning for wrong email is working");	
	}
	@Test
	public void TC48_LoginPage_ForgetPasswordWithUnregisteredEmail() {
		//TC48_LoginPage_ForgetPasswordWithUnregisteredEmail
		String expectedMsg= getTestData("TC48",2);
		launchForgetPasswordPage();
		String actualMsg = forgetPasswordPage.recoverPassword(getTestData("TC48"));
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg, "Forget password for unregistered email warning is working");	
	}
	@Test
	public void TC49_LoginPage_LoginWithoutInput() {
		//TC49_LoginPage_LoginWithoutInput
		String expectedMsg1= getTestData("TC49");
		String expectedMsg2= getTestData("TC49",2);
		launchLoginPage();
		List<String> msg = new ArrayList<String>();
		msg = loginPage.login();
		System.out.println(msg);
		Assert.assertEquals(msg.get(0), expectedMsg1, "Login Warning is working");	
		Assert.assertEquals(msg.get(1), expectedMsg2, "Login Warning is working");	
	}
	@Test
	public void TC50_LoginPage_LoginInvalidEmail() {
		//TC50_LoginPage_LoginInvalidEmail
		String expectedMsg= getTestData("TC50",2);
		launchLoginPage();
		String actualMsg =loginPage.login(getTestData("TC50"));
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg, "Login Warning is working");	
	}
	@Test
	public void TC51_LoginPage_LoginUnregisteredEmail() {
		//TC51_LoginPage_LoginUnregisteredEmail
		String expectedMsg1= getTestData("TC51",3);
		String expectedMsg2= getTestData("TC51",4);
		launchLoginPage();
		List<String> msg = new ArrayList<String>();
		msg = loginPage.login(getTestData("TC51"), getTestData("TC51",2));
		System.out.println(msg);
		Assert.assertEquals(msg.get(0), expectedMsg1, "Login Warning is working");	
		Assert.assertEquals(msg.get(1), expectedMsg2, "Login Warning is working");	
	}
	@Test
	public void TC52_Register_NoInput() {
		//TC52_Register_NoInput
		List<String> msg = new ArrayList<String>();
		launchRegisterPage();
		msg = registerPage.register();
		for (int i = 0; i < msg.size(); i++) 
		{
			System.out.println(msg.get(i));
			Assert.assertEquals(msg.get(i), getTestData("TC52",i+1), "Register Warning is working");
		}
	}
	@Test
	public void TC53_Register_OnlyFirstName() {
		//TC53_Register_OnlyFirstName
		List<String> msg = new ArrayList<String>();
		launchRegisterPage();
		msg = registerPage.registerOnlyName(getTestData("TC53"),null);
		for (int i = 0; i < msg.size(); i++) 
		{
			System.out.println(msg.get(i));
			Assert.assertEquals(msg.get(i), getTestData("TC53",i+2), "Register Warning is working");
		}
	}
	@Test
	public void TC54_Register_OnlyFirstNameAndLastName() {
		//TC54_Register_OnlyFirstNameAndLastName
		List<String> msg = new ArrayList<String>();
		launchRegisterPage();
		msg = registerPage.registerOnlyName(getTestData("TC54"),getTestData("TC54",2));
		for (int i = 0; i < msg.size(); i++) 
		{
			System.out.println(msg.get(i));
			Assert.assertEquals(msg.get(i), getTestData("TC54",i+3), "Register Warning is working");
		}
	}
	@Test
	public void TC55_Register_InvalidEmail() {
		//TC55_Register_InvalidEmail
		String expectedMsg= getTestData("TC55",2); 
		launchRegisterPage();
		String actualMsg= registerPage.registerInvalidEmail(getTestData("TC55"));
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg, "Regitster Warning is working");
	}
	@Test
	public void TC56_Register_InvalidPassword() {
		//TC56_Register_InvalidPassword 
		String expectedMsg= getTestData("TC56",2); 
		launchRegisterPage();
		String actualMsg= registerPage.registerInvalidPassword(getTestData("TC56"));
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg, "Regitster Warning is working");
	}
	@Test
	public void TC57_Register_ConfirmpasswordMismatch() {
		//TC57_Register_ConfirmpasswordMismatch
		String expectedMsg= getTestData("TC57",3); 
		launchRegisterPage();
		String actualMsg= registerPage.registerInvalidConfirmPassword(getTestData("TC57"), getTestData("TC57",2));
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg, "Regitster Warning is working");
	}
	@Test
	public void TC58_Register_ConfirmpasswordLengthMismatch() {
		//TC58_Register_ConfirmpasswordLengthMismatch
		String expectedMsg= getTestData("TC58",3); 
		launchRegisterPage();
		String actualMsg= registerPage.registerInvalidConfirmPassword(getTestData("TC58"), getTestData("TC58",2));
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg, "Regitster Warning is working");
	}
	@Test
	public void TC59_Register_ValidEmailInvalidPassword() {
		//TC59_Register_ValidEmailInvalidPassword
		List<String> msg = new ArrayList<String>();
		launchRegisterPage();
		msg = registerPage.invalidRegister(getTestData("TC59"),getTestData("TC59",2),getTestData("TC59",3),getTestData("TC59",4),getTestData("TC59",5));
		for (int i = 0; i < msg.size(); i++) 
		{
			System.out.println(msg.get(i));
			Assert.assertEquals(msg.get(i), getTestData("TC59",i+6), "Register Warning is working");
		}
	}
	@Test
	public void TC60_Register_OnlyLastName() {
		//TC60_Register_OnlyLastName
		List<String> msg = new ArrayList<String>();
		launchRegisterPage();
		msg = registerPage.registerOnlyName(null,getTestData("TC60"));
		for (int i = 0; i < msg.size(); i++) 
		{
			System.out.println(msg.get(i));
			Assert.assertEquals(msg.get(i), getTestData("TC60",i+2), "Register Warning is working");
		}
	}
	@Test
	public void TC61_Register_OnlyEmail() {
		//TC61_Register_OnlyEmail
		List<String> msg = new ArrayList<String>();
		launchRegisterPage();
		msg = registerPage.invalidRegister(null,null,getTestData("TC61"),null,null);
		for (int i = 0; i < msg.size(); i++) 
		{
			System.out.println(msg.get(i));
			Assert.assertEquals(msg.get(i), getTestData("TC61",i+2), "Register Warning is working");
		}
	}
	@Test
	public void TC62_Register_OnlyEmailAndPassword() {
		//TC62_Register_OnlyEmailAndPassword
		List<String> msg = new ArrayList<String>();
		launchRegisterPage();
		msg = registerPage.invalidRegister(null,null,getTestData("TC62"),getTestData("TC61",2),null);
		for (int i = 0; i < msg.size(); i++) 
		{
			System.out.println(msg.get(i));
			Assert.assertEquals(msg.get(i), getTestData("TC62",i+3), "Register Warning is working");
		}
	}
	@Test
	public void TC63_Register_OnlyEmailMissing() {
		//TC63_Register_OnlyEmailMissing
		List<String> msg = new ArrayList<String>();
		launchRegisterPage();
		msg = registerPage.invalidRegister(getTestData("TC63"),getTestData("TC63",2),null,getTestData("TC63",3),getTestData("TC63",4));
		for (int i = 0; i < msg.size(); i++) 
		{
			System.out.println(msg.get(i));
			Assert.assertEquals(msg.get(i), getTestData("TC63",i+5), "Register Warning is working");
		}
	}
	@Test
	public void TC64_Register_OnlyPasswordsMissing() {
		//TC64_Register_OnlyPasswordsMissing
		List<String> msg = new ArrayList<String>();
		launchRegisterPage();
		msg = registerPage.invalidRegister(getTestData("TC64"),getTestData("TC64",2),getTestData("TC64",3),null,null);
		for (int i = 0; i < msg.size(); i++) 
		{
			System.out.println(msg.get(i));
			Assert.assertEquals(msg.get(i), getTestData("TC64",i+4), "Register Warning is working");
		}
	}
	@Test
	public void TC65_Register_OnlyConfirmPasswordMissing() {
		//TC65_Register_OnlyConfirmPasswordMissing
		List<String> msg = new ArrayList<String>();
		launchRegisterPage();
		msg = registerPage.invalidRegister(getTestData("TC65"),getTestData("TC65",2),getTestData("TC65",3),getTestData("TC65",4),null);
		for (int i = 0; i < msg.size(); i++) 
		{
			System.out.println(msg.get(i));
			Assert.assertEquals(msg.get(i), getTestData("TC65",i+5), "Register Warning is working");
		}
	}
	@Test
	public void TC66_Register_OnlyUserNameMissing () {
		//TC66_Register_OnlyUserNameMissing
		List<String> msg = new ArrayList<String>();
		launchRegisterPage();
		msg = registerPage.invalidRegister(null,getTestData("TC66"),getTestData("TC66",2),getTestData("TC66",3),getTestData("TC66",4));
		for (int i = 0; i < msg.size(); i++) 
		{
			System.out.println(msg.get(i));
			Assert.assertEquals(msg.get(i), getTestData("TC66",i+5), "Register Warning is working");
		}
	}
	@Test
	public void TC67_Register_OnlyLastnameMissing () {
		//TC67_Register_OnlyLastnameMissing
		List<String> msg = new ArrayList<String>();
		launchRegisterPage();
		msg = registerPage.invalidRegister(getTestData("TC67"),null,getTestData("TC67",2),getTestData("TC67",3),getTestData("TC67",4));
		for (int i = 0; i < msg.size(); i++) 
		{
			System.out.println(msg.get(i));
			Assert.assertEquals(msg.get(i), getTestData("TC67",i+5), "Register Warning is working");
		}
	}
	@Test
	public void TC68_Register_WithAlreadyRegisteredUser () {
		//TC68_Register_WithAlreadyRegisteredUser
		String expectedErrorMsg = getTestData("TC68",6);
		launchRegisterPage();
		String actualErrorMsg = registerPage.Register(getTestData("TC68"),getTestData("TC68",2),getTestData("TC68",3),getTestData("TC68",4),getTestData("TC68",5));
		System.out.println(actualErrorMsg);
		
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Regitster Warning is working");
	}
	@Test
	public void TC69_Register_CheckIfUserIsAbleToSelectGender() {
		//TC69_Register_CheckIfUserIsAbleToSelectGender
		launchRegisterPage();
		Assert.assertTrue(registerPage.SelectGender(), "Gender Radio button is working");
	}
	@Test
	public void TC71_MainPage_SubscribeWithInvalidEmail() {
		//TC71_MainPage_SubscribeWithInvalidEmail
		String expectedValue= getTestData("TC71",2);
		String actualValue = demoWebShopPage.subscribe(getTestData("TC71"), expectedValue);
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, expectedValue, "Subscribe is working");	
	}
	@Test
	public void TC72_MainPage_SubscribeWithValidEmail() {
		//TC72_MainPage_SubscribeWithValidEmail
		String expectedValue= getTestData("TC72",2);
		String actualValue = demoWebShopPage.subscribe(getTestData("TC72"), expectedValue);
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, expectedValue, "Subscribe is working");	
	}
	@Test
	public void TC73_LoginPage_ForgetPasswordWithRegisteredEmail() {
		//TC73_LoginPage_ForgetPasswordWithRegisteredEmail
		String expectedMsg= getTestData("TC73",2);
		launchForgetPasswordPage();
		String actualMsg = forgetPasswordPage.recoverPassword(getTestData("TC73"));
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg, "Forget password for registered email warning is working");	
	}
	@Test
	public void TC74_LoginPage_RegisteredEmailBlankPassword() {
		//TC74_LoginPage_RegisteredEmailBlankPassword
		String expectedMsg1= getTestData("TC74",2);
		String expectedMsg2= getTestData("TC74",3);
		launchLoginPage();
		List<String> msg = new ArrayList<String>();
		msg = loginPage.login(getTestData("TC74"), null);
		System.out.println(msg);
		Assert.assertEquals(msg.get(0), expectedMsg1, "Login Warning is working");	
		Assert.assertEquals(msg.get(1), expectedMsg2, "Login Warning is working");	
	}
	@Test
	public void TC75_LoginPage_LoginSuccessful() {
		//TC75_LoginPage_LoginSuccessful
		String expectedMsg= getTestData("TC75");
		launchLoginPage();
		String actualMsg =loginPage.successfulLogin(getTestData("TC75"), getTestData("TC75",2),false);
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg, "User is able to login");	
	}
	@Test
	public void TC76_LoginPage_LoginSuccessfulWithRememberMe() {
		//TC76_LoginPage_LoginSuccessfulWithRememberMe
		String expectedMsg= getTestData("TC76");
		launchLoginPage();
		String actualMsg =loginPage.successfulLogin(getTestData("TC76"), getTestData("TC76",2),true);
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg, "User is able to login");	
	}
	@Test
	public void TC77_LoginPage_LogoutSuccessful() {
		//TC77_LoginPage_LogoutSuccessful
		String expectedMsg= getTestData("TC77",3);
		launchLoginPage();
		String actualMsg =loginPage.logout(getTestData("TC77"), getTestData("TC77",2));
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg, "User is able to logout");	
	}
	
	@Test
	public void TC78_CartPageInvalidDiscountCode() {
		//TC78_CartPageInvalidDiscountCode
		String expectedMsg= getTestData("TC78",2);
		launchCartPage();
		String actualMsg = cartPage.applyCouponCode(getTestData("TC78"));
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg, "Discount Code warning is working ");
	}
	@Test
	public void TC79_CartPageInvalidGiftCard() {
		//TC79_CartPageInvalidGiftCard
		String expectedMsg= getTestData("TC79",2);
		launchCartPage();
		String actualMsg = cartPage.applyGiftCard(getTestData("TC79"));
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg, "Gift code warning is working");
	}
	@Test
	public void TC80_User_CheckShoppingCartCountAfterAddingProduct() {
		//TC80_User_CheckShoppingCartCountAfterAddingProduct
		String expectedValue= getTestData("TC80");
		launchCartPage();
		String actualValue = cartPage.checkCartQuantity();
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, expectedValue, "Shopping Cart qty is working ");
		
	}
	@Test
	public void TC81_User_NavigateFromGoToCart() {
		//TC81_User_NavigateFromGoToCart
		String expectedMsg= getTestData("TC81");
		launchCartPage();
		String actualMsg = cartPage.goToCart();
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg, "Go To Cart qty is working ");
		
	}

}
