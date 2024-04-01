package automationSuite.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import automationSuite.testComponents.BaseTest;

@Listeners(automationSuite.testComponents.Listeners.class)
public class TestSuite_Regression_Suite1 extends BaseTest{
	// /*
	@Test //check after adding testng file priority and after before suite
	// check and try catch and all locators as private
	// try and catch added can remove throws from all TC in test suite 
	public void TC01_CheckIfSiteIsRunning() {
		//TC01_CheckIfSiteIsRunning
		String expectedTitle= getTestData("TC01");
		
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Site is loaded");	
		
	}
	@Test
	public void TC02_CheckIfLoginPageIsRunning() {
		//TC02_CheckIfLoginPageIsRunning
		String expectedTitle= getTestData("TC02");
		demoWebShopPage.navigateToRequiredPage("Login");
		
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Login page is loaded");	
	}
	
	@Test
	public void TC03_CheckIfRegisterPageIsRunning() {
		//TC03_CheckIfRegisterPageIsRunning
		String expectedTitle = null;
		expectedTitle = getTestData("TC03");
		demoWebShopPage.navigateToRequiredPage("Register");
		
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Register page is loaded");	
	}
	
	@Test
	public void TC04_CheckIfShoppingCartPageIsRunning(){
		//TC04_CheckIfShoppingCartPageIsRunning
		String expectedTitle = getTestData("TC04");
		demoWebShopPage.navigateToRequiredPage("Cart");
		
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Shopping Cart page is loaded");	
	}
	
	@Test
	public void TC05_CheckIfWishlistPageIsRunning() {
		//TC05_CheckIfWishlistPageIsRunning
		String expectedTitle = getTestData("TC05");
		demoWebShopPage.navigateToRequiredPage("Wishlist");
		
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Wishlist page is loaded");	
	}
	
	@Test
	public void TC06_CheckIfContactUsPageIsRunning(){
		//TC06_CheckIfContactUsPageIsRunning
		String expectedTitle = getTestData("TC06");
		demoWebShopPage.navigateToRequiredPage("Contact");
		
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Contact us page is loaded");	
	}
	
	@Test
	public void TC07_CheckIfShippingReturnsPageIsRunning() {
		//TC07_CheckIfShippingReturnsPageIsRunning
		String expectedTitle = getTestData("TC07");
		demoWebShopPage.navigateToRequiredPage("ShippingReturns");
		
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Shipping & Returns page is loaded");	
	}
	
	@Test
	public void TC08_CheckIfFeatureProductsAreDisplayed() {
		//TC08_CheckIfFeatureProductsAreDisplayed
		String expectedTitle = getTestData("TC08");
		String actualValue = demoWebShopPage.returnText("Featured");
		
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, expectedTitle, "Featured products are displayed");	
	}
	
	@Test
	public void TC09_CheckIfCommunityPollIsDisplayed(){
		//C09_CheckIfCommunityPollIsDisplayed
		String expectedTitle = getTestData("TC09");
		String actualValue = demoWebShopPage.returnText("CommunityPoll");
		
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, expectedTitle, "Community poll is displayed");	
	}
	
	@Test
	public void TC10_CheckIfNewsletterIsDisplayed() {
		//C09_CheckIfCommunityPollIsDisplayed
		String expectedTitle = getTestData("TC10");
		String actualValue = demoWebShopPage.returnText("Newsletter");
		
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, expectedTitle, "Newsletter is displayed");	
	}
	@Test
	public void TC11_CheckIfCategoryIsDisplayed(){
		//TC11_CheckIfCategoryIsDisplayed
		String expectedTitle = getTestData("TC11");
		String actualValue = demoWebShopPage.returnText("Category");
		
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, expectedTitle, "Category is displayed");	
	}
	@Test
	public void TC12_CheckIfManufacturerIsDisplayed(){
		//TC12_CheckIfManufacturerIsDisplayed
		String expectedTitle = getTestData("TC12");
		String actualValue = demoWebShopPage.returnText("Manufacturer");
		
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, expectedTitle, "Manufacturer is displayed");	
	}
	@Test
	public void TC13_CheckIfPopularTagIsDisplayed(){
		//TC13_CheckIfPopularTagIsDisplayed
		String expectedTitle = getTestData("TC13");
		String actualValue = demoWebShopPage.returnText("PopularTag");
		
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, expectedTitle, "PopularTag is displayed");	
	}
	@Test
	public void TC14_CheckIfCartQuantityIsDisplayed(){
		//TC14_CheckIfCartQuantityIsDisplayed
		String expectedTitle = getTestData("TC14");
		String actualValue = demoWebShopPage.returnText("CartQuantity");
		
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, expectedTitle, "CartQuantity is displayed");	
	}
	@Test
	public void TC15_CheckIfWishlistQuantityIsDisplayed(){
		//TC15_CheckIfWishlistQuantityIsDisplayed
		String expectedTitle = getTestData("TC15");
		String actualValue = demoWebShopPage.returnText("WishlistQuantity");
		
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, expectedTitle, "WishlistQuantity is displayed");	
	}
	
	@Test
	public void TC16_CheckPopulatTagLink() throws InterruptedException{
		//TC16_CheckPopulatTagLink
		String page = getTestData("TC16");
		String expectedTitle = getTestData("TC16",2);
		Assert.assertTrue(demoWebShopPage.checkPopularLink(page).isDisplayed(), "Popular Tag Link is working");
		String actualValue = demoWebShopPage.returnText(page);
		System.out.println(actualValue);
		
		Assert.assertEquals(actualValue, expectedTitle, "Popular Tag Link is working");	
	}
	
	@Test
	public void TC17_CheckPopularTagViewAll() throws IOException, InterruptedException {
		//TC17_CheckPopularTagViewAll
		String popLink = getTestData("TC17");
		String expectedTitle = getTestData("TC17",2);
		Assert.assertTrue(demoWebShopPage.checkPopularLink(popLink).isDisplayed(), "Popular Tag ViewAll is working");
		String actualValue = demoWebShopPage.returnText(popLink);
		System.out.println(actualValue);
		
		Assert.assertEquals(actualValue, expectedTitle, "Popular Tag ViewAll is working");	
	}
	
	@Test
	public void TC18_CheckCategoryLink() throws IOException, InterruptedException {
		//TC18_CheckCategoryLink
		String category = getTestData("TC18");
		String expectedTitle = getTestData("TC18",2);
		Assert.assertTrue(demoWebShopPage.checkCategory(category).isDisplayed(), "Category is working");
		String actualValue = demoWebShopPage.returnText(category);
		System.out.println(actualValue);
		
		Assert.assertEquals(actualValue, expectedTitle, "Category is working");	
	}
	@Test
	public void TC19_CheckSubCategoryLink() throws IOException, InterruptedException {
		//TC19_CheckSubCategoryLink
		String subCategory = getTestData("TC19");
		String expectedTitle = getTestData("TC19",2);
		Assert.assertTrue(demoWebShopPage.checkSubCategory(subCategory).isDisplayed(), "SubCategory is working");
		String actualValue = demoWebShopPage.returnText(subCategory);
		System.out.println(actualValue);
		
		Assert.assertEquals(actualValue, expectedTitle, "SubCategory is working");	
	}
	@Test
	public void TC20_CheckCategoryLink_InHeader() throws IOException, InterruptedException {
		//TC20_CheckCategoryLink_InHeader
		String category = getTestData("TC20");
		String expectedTitle = getTestData("TC20",2);
		Assert.assertTrue(demoWebShopPage.checkCategory(category).isDisplayed(), "Category is working");
		String actualValue = demoWebShopPage.returnText(category);
		System.out.println(actualValue);
		
		Assert.assertEquals(actualValue, expectedTitle, "Category is working");	
	}
	@Test
	public void TC21_CheckSubCategoryLink_InHeader() throws IOException, InterruptedException {
		//TC21_CheckSubCategoryLink_InHeader
		
		String subCategory = getTestData("TC21");
		String expectedTitle = getTestData("TC21",2);
		Assert.assertTrue(demoWebShopPage.checkSubCategory(subCategory).isDisplayed(), "SubCategory is working");
		String actualValue = demoWebShopPage.returnText(subCategory);
		System.out.println(actualValue);
		
		Assert.assertEquals(actualValue, expectedTitle, "SubCategory is working");	
	}
	
	@Test
	public void TC22_NavigatetoHomePage() throws IOException, InterruptedException {
		//TC22_NavigatetoHomePage
		
		String page = getTestData("TC22");
		demoWebShopPage.navigateToRequiredPage(page);
		page = getTestData("TC22",2);
		demoWebShopPage.navigateToRequiredPage(page);
		String expectedTitle = getTestData("TC22",3);
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title matched");
		
	}
	@Test
	public void TC35_NewProductLink() {
		//TC35_NewProductLink
		String expectedTitle= getTestData("TC35",2);
		String page = getTestData("TC35");
		demoWebShopPage.navigateToRequiredPage(page);
		
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), expectedTitle, "New Product page is loaded");	
	}
	@Test
	public void TC36_CompareProductsList() {
		//TC36_CompareProductsList
		String expectedTitle= getTestData("TC36",2);
		String page = getTestData("TC36");
		demoWebShopPage.navigateToRequiredPage(page);
		
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Compare Products page is loaded");	
	}
	@Test
	public void TC37_NewsLink() {
		//TC37_NewsLink
		String expectedTitle= getTestData("TC37",2);
		String page = getTestData("TC37");
		demoWebShopPage.navigateToRequiredPage(page);
		
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), expectedTitle, "News page is loaded");	
	}
	@Test
	public void TC38_BlogLink(){
		//TC38_BlogLink
		String expectedTitle= getTestData("TC38",2);
		String page = getTestData("TC38");
		demoWebShopPage.navigateToRequiredPage(page);
		
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Blog page is loaded");	
	}
	@Test
	public void TC43_CheckRecentlyViewedProductLink() {
		//TC43_CheckRecentlyViewedProductLink
		String expectedTitle= getTestData("TC43",2);
		String page = getTestData("TC43");
		demoWebShopPage.navigateToRequiredPage(page);
		
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Recently Viewed page is working");	
	}
	@Test
	public void TC44_CheckIfUserCanNavigateToYoutubeLink() {
		//TC44_CheckIfUserCanNavigateToYoutubeLink
		String expectedTitle= getTestData("TC44");
		
		String actualTitle = demoWebShopPage.navigateToYoutube();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "Youtube Link is working");	
	}
	@Test
	public void TC45_LoginPage_CheckIfForgerPasswordLinkIsWorking() {
		//TC45_LoginPage_CheckIfForgerPasswordLinkIsWorking
		String expectedTitle= getTestData("TC45");
		launchForgetPasswordPage();
		forgetPasswordPage.navigateToForgetPassword();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Forget password link is working");	
	}
	@Test
	public void TC70_MainPage_SubscribeIsDisplayed(){
		//TC70_MainPage_SubscribeIsDisplayed
		String expectedValue = getTestData("TC70",2);
		String actualValue = demoWebShopPage.returnText(getTestData("TC70"));
		
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, expectedValue, "Subscribe is displayed");	
	}

}
