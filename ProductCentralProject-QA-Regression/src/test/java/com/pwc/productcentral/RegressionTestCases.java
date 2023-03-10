package com.pwc.productcentral;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.AuthoringPage;
import Pages.BasePage;
import Pages.HomePage;
import Pages.HomePageTemplatePage;
import Pages.LegalPage;
import Pages.LoginPageObjects;

import Pages.ProductListingPage;
import Pages.ProductPage;
import Pages.ResellerPage;
import Pages.SecurityPage;
import Pages.UMSPage;


public class RegressionTestCases extends BasePage {
	
	ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	public static ConfigurationsReader read;
	String platform = null;
	LoginPageObjects lpo=new LoginPageObjects();
	HomePage hp=new HomePage();
	ProductListingPage plp=new ProductListingPage();
	HomePageTemplatePage hpt=new HomePageTemplatePage();
	ResellerPage rp=new ResellerPage();
	LegalPage lp=new LegalPage();
	SecurityPage sp=new SecurityPage();
	ProductPage pp=new ProductPage();
	AuthoringPage ap=new AuthoringPage();
	UMSPage ums=new UMSPage();
	screenshotUtil ssu=new screenshotUtil();
	private ExtentTest test;
	
	
	
	Logger logger=Logger.getLogger("SanityTestCases");
	
	ReadXLSdata read1=new ReadXLSdata();
	
	


	
	@BeforeSuite
	public void setUp() {
		 PropertyConfigurator.configure(".\\log4j.properties");
		 read = new ConfigurationsReader();
		 platform = read.getPlatform();
		 read.platformName();
		 htmlReporter = new ExtentHtmlReporter("Sanity Automation Report for Product Central.html");
	     extent = new ExtentReports();
	     extent.attachReporter(htmlReporter);
	    
	     
	}
		
	@BeforeMethod
	public void initTest() throws Exception {
	    Driver.getDriver();
	    read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().deleteAllCookies();
		HelperFunctions.setWaitTime();
		
		
	}
	
	
	/*******************************************************Regression Test Case********************************************************/
	
	
	@Test(enabled=false)
	public void WEB_1() throws Exception{
		  String testName = "Verify the updated color of the title on the tiles is black.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 15)); 
		       
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName); 
		    }
	}
	@Test(enabled=false)
	public void WEB_2() throws Exception{
		  String testName = "Verify that two separate pages under Product central/Privacy and Product central/Security page on site navigation.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 15));
		        BasePage.setVerifySeperatePages();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	
	}
	
	@Test(enabled=false)
	public void WEB_3() throws Exception{
		 String testName = "Verify that documentation tile changed to Privacy and Security with an updated description";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 45));
		        plp.setDocumentationTileChanging();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	
	@Test(enabled=false)
	public void WEB_4() throws Exception{
		 String testName = "Verify the collapse icon is responsible for collapsing and expanding left navigation";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 15));
		        BasePage.setCollapseButton();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	
	}
	@Test(enabled=false)
	public void WEB_5() throws Exception{
		 String testName = "Verify left navigation component will appear on the left side";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 15));
		        BasePage.setLeftNavigationItems2();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test(enabled=false)
	public void WEB_6() throws Exception{
		 String testName = "Verify that when user click on breadcrumb then user go to previous page";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 4));
		        plp.setBreadcrumbs();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	
	@Test(enabled=false)
	public void WEB_7() throws Exception{
		 String testName = "Verify that breadcrumb is visible to user";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 4));
		        plp.setBreadcrumbsVisibility();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test(enabled=false)
	public void WEB_8() throws Exception{
		String testName = "Verify the description describe the product/site /page itself";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 46));
	        plp.setProductDescription();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test(enabled=false)
	public void WEB_9() throws Exception{
		String testName = "Verify the product title and description are visible to the users of the page/site";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 46));
	        plp.setProductTitleandDescriptionVisibility();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test(enabled=false)
	public void WEB_10() throws Exception{
		String testName = "Verify the system will know which link to present based on the "
				+ "content pages available for the product. For e.g. this could be done via tags "
				+ "(matching the tags between pages and assets, such as the product tag and the document type tag)";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 45));
	        plp.setContentPageTags();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}

	
	@Test (enabled=false)
	public void WEB_11() throws Exception{
		String testName = "Verify 'Download Full Terms' link will download all the content page related assets for the product in a zip file";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 45));
	        plp.setDownloadFullTermsLink();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test (enabled=false)
	public void WEB_12() throws Exception{
		String testName = "Verify homepage can host a maximum of ‘15’ tiles.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setTilesNumber();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	@Test(enabled=false)
	public void WEB_13() throws Exception{
		String testName = "Verify My products tile will contain a ‘login to my products’ tile";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setTilesHasLoginLink();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	
	
	@Test(enabled=false)
	public void WEB_14() throws Exception{
		String testName = "Verify clicking on the tile will navigate the user to a hyperlink page within the tab";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setLegalTile();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}

	
	@Test(enabled=false)
	public void WEB_15() throws Exception{
		String testName = "Verify that when user click on collapse icon under the left nav,then left nav will collapse and only the icons/image for each item will appear";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        BasePage.setCollapseButtonImg();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	@Test(enabled=false)
	public void WEB_16() throws Exception{
		String testName = "verify promotion banner must contain a page title \"Welcome to Product Central \"";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
            hp.setPromoTitle();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test (enabled=false)
	public void WEB_17() throws Exception{
		String testName = "Verify the user is able to view the title, description, Image and my product button on the banner";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setPromotionBannerElements();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test (enabled=false)
	public void WEB_18() throws Exception{
		String testName = "Verify the company will host the page title, description ,image ,link/button";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setPromotionBannerElements();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	
	
	@Test(enabled=false)
	public void WEB_19() throws Exception{
		String testName = "Verify that when user click on collapse icon then left navigation component name will be collapsing and after click then expanding";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        BasePage.setCollapseExpandButton();;
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	
	@Test (enabled=false)
	public void WEB_20() throws Exception{
		String testName = "Verify that all the component present in footer bar";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setFooterBar();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test (enabled=false)
	public void WEB_21() throws Exception{
		String testName = "Verify that the description in the tile only be a maximum of 6 lines, anything more than that will be truncated.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setDescriptionOfTiles();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	
	@Test (enabled=false)
	public void WEB_22() throws Exception{
		String testName = "Verify that footer are persistent on all PC pages";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        BasePage.setVerifyFooter();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	@Test (enabled=false)
	public void WEB_23() throws Exception{
		String testName = "Verify that when user hover over, the mouse icon then tiles color will change to indicate clickability";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setClickability();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test (enabled=false)
	public void WEB_24() throws Exception{
		String testName = "Verify that the first product in the Modal is the product being viewed.The remaining are products are alphabetical. ";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        lpo.setLogin();
	        pp.setProductSorting();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	
	}
	
	@Test(enabled=false)
	public void WEB_25() throws Exception{
		String testName = "Verify that within the modal when the user clicks on a product they are taken to that product page and the modal closes";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        lpo.setLogin();
	        pp.setModalClose();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	
	}
	
	@Test (enabled=false)
	public void WEB_26() throws Exception{
		String testName = "Verify that In replacement of the various product tabs, there is a “View all” link";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        lpo.setLogin();
	       pp.setViewAllVisibility();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	@Test(enabled=false)
	public void WEB_27() throws Exception{
		String testName = "Verify that once user executes this workflow, it should automatically unpublish the page or asset";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        lpo.setLogin();
	        ap.setUnpublishWorkflow2();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
		
	}
	
	
	@Test (enabled=false)
	public void WEB_28() throws Exception{
		String testName = "Verify that as a author or publisher with appropriate license or permissions should be able to trigger this work flow without any approval.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        lpo.setLogin();
	        ap.setExpressWorkflowApproval();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test (enabled=false)
	public void WEB_29() throws Exception{
		String testName = "Verify if the title exceeds 4 lines it should be able to handle via authoring or ellipse will be added.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        lpo.setLogin();
	        pp.setTitleOfAssets();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test (enabled=false)
	public void WEB_30() throws Exception{
		String testName = "Verify that text is showing with ellipses if the name of the product is too long.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 47));
	        sp.setProductNameLength();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test (enabled=false)
	public void WEB_31() throws Exception{
		String testName = "Verify that The alignment of the all text are vertically centered.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 47));
	        sp.setProductAlignment();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test (enabled=false)
	public void WEB_32() throws Exception{
		String testName = "Verify that The tile height should remain the same as previous";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 47));
	        sp.setTilesHeight();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test (enabled=false)
	public void WEB_33() throws Exception{
		String testName = "Verify that author/end user should be able to see the icon on the published page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        lpo.setLogin();
	        pp.setFooterIconVisibility();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test (enabled=false)
	public void WEB_34() throws Exception{
		String testName = "Verify If the user closes the banner then this action is retained during the session, and upon"
				+ " return visit if the outage still persists then the banner will be displayed again";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        lpo.setLogin();
	        pp.setBannerPersistance();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test (enabled=false)
	public void WEB_35() throws Exception{
		String testName = "Verify that 'Workflow title' field is mandatory";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        lpo.setLogin();
	        ap.setWorkflowApproval2();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false)
	public void WEB_36() throws Exception{
		String testName = "Verify that the background text is white only";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        lpo.setLogin();
	        pp.setHeroPromotionDesign();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false)
	public void WEB_37() throws Exception{
		String testName = "Verify that portfolio remains unchanged such as dropdown and behavior";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 14));
	        plp.setPortfolioDropdown();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false)
	public void WEB_38() throws Exception{
		String testName = "Verify that hover over remains unchanged";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 14));
	        plp.setPortfolioDropdownHoverOver();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false)
	public void WEB_39() throws Exception{
		String testName = "Verify that the items do not differ between non and logged in users";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setItemsinNeedHelp();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false)
	public void WEB_40() throws Exception{
		String testName = "Verify that icon allow expand and collapse and it moves to the bottom";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setItemsinNeedHelpExpandCollapse();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test(enabled=false)
	public void WEB_41() throws Exception{
		String testName = "verify the users must be able to use the filters to narrow down the search results";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setSearchResult();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	

	@Test(enabled=false)
	public void WEB_42() throws Exception{
		String testName = "verify as there is no limit on the number of search results that are needed to be displayed, "
				+ "the system needs to display all the search results using pagination";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setLimitOfSearchResults();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test(enabled=false)
	public void WEB_43() throws Exception{
		String testName = "verify on hover over the search result title will turn Orange";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setOrangeSearchResults();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false)
	public void WEB_44() throws Exception{
		String testName = "verify default state of search results will display in a black text";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setBlackSearchResults();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false)
	public void WEB_45() throws Exception{
		String testName = "verify all search results are presented as line items";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setLineItems();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false)
	public void WEB_46() throws Exception{
		String testName = "Verify sort by is not multi select";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setNotMultiSelectSortingDropdown();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false)
	public void WEB_47() throws Exception{
		String testName = "Verify sort by is used to sort the search results";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setSortingSearchResult();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false)
	public void WEB_48() throws Exception{
		String testName = "Verify the title of the page is ‘Search results";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setTitleofThePage();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false)
	public void WEB_49() throws Exception{
		String testName = "Verify on click of it the user will be navigated to the PC homepage or my products depending on where the user came from";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setNavigateHomepage();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false)
	public void WEB_50() throws Exception{
		String testName = "Verify by default it will be blue but on hover over it will turn Orange.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setColorDifferences();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false)
	public void WEB_51() throws Exception{
		String testName = "Verify the’ back to home’ breadcrumb appear on the top left corner of the page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setBackoHomeBreadcrumb();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false)
	public void WEB_52() throws Exception{
		String testName = "Verify that the items in the dropdown are multiselect";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setMultiselectDropdown();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false)
	public void WEB_53() throws Exception{
		String testName = "Verify that Product filter needs to reflect values to match the PC products";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setFilterMatchingSearchResults();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false)
	public void WEB_54() throws Exception{
		String testName = "Verify that there will be two filters present on the global search results page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setTwoFilteronGlobalSearchResult();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false)
	public void WEB_55() throws Exception{
		String testName = "Verify that user entered keyword remains into search bar either user select "
				+ "suggested product name or not & submitted keyword doesn't match any result.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 6));
	        plp.setSearchBarKeywordforNegativeTest();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false)
	public void WEB_56() throws Exception{
		String testName = "verify the search bar is at the top of the My Products page template";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        lpo.setLogin();
	        pp.setMyProductSearchBar(); 
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false) //!!!!!!!!!
	public void WEB_57() throws Exception{
		String testName = "verify the search bar is at the top of the My Products page template";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        lpo.setLogin();
	        pp.setFilterMyProductSearch();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false)
	public void WEB_58() throws Exception{
		String testName = "Verify that search product bar accepts the user input keywords";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        lpo.setLogin();
	        pp.setInputKeywords();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test(enabled=false)
	public void WEB_59() throws Exception{
		String testName = "Verify that search product bar is used for searching products";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        lpo.setLogin();
	        pp.setSearchingProducts();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false)
	public void WEB_60() throws Exception{
		String testName = "Verify any user can use global search";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        lpo.setLogin();
	        pp.setUsingGlobalSearch();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false)
	public void WEB_61() throws Exception{
		String testName = "Verify My Products search is only accessible on a My Products page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        lpo.setLogin();
	        pp.setMyProductSearchAccessibility();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false)
	public void WEB_62() throws Exception{
		String testName = "Verify field supports special characters";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        lpo.setLogin();
	        pp.setAcceptingSpecialChar();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test (enabled=false)//!!!!!!!!!!
	public void WEB_63() throws Exception{
		String testName = "Verify that on click of search product bar, the borders of the search bar lights up ";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        lpo.setLogin();
	        pp.setSearchBarLight();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test (enabled=false)//!!!!!!!!!!
	public void WEB_64() throws Exception{
		String testName = "Verify product names is present on the page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        lpo.setLogin();
	      
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test (enabled=false)//!!!!!!!!!!
	public void WEB_65() throws Exception{
		String testName = "Verify that the My Products search is only accessible on a My Products page, which requires login and permission.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        lpo.setLogin();
	      
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test (enabled=false)
	public void WEB_66() throws Exception{
		String testName = "Verify product names is present on the page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 42));
	       lp.setProductsNamePresent();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test (enabled=false)
	public void WEB_67() throws Exception{
		String testName = "Verify tile title, description, and thumbnail is repeated across Products";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 6));
	        plp.setTitleDescriptionThumbnail();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test (enabled=false)
	public void WEB_68() throws Exception{
		String testName = "Verify there will never be a case when there are zero tiles on the page.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 6));
	        plp.setZeroTiles();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test (enabled=false)
	public void WEB_69() throws Exception{
		String testName = "Verify on hover over the tile thumbnail should light up";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 6));
	        plp.setLightUpThumbnail();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test (enabled=false)
	public void WEB_70() throws Exception{
		String testName = "Verify document tiles can have only 3 lines of descriptions, anything more than that will be truncated.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 6));
	        plp.setDescriptionOfTiles();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test (enabled=false)
	public void WEB_71() throws Exception{
		String testName = "Verify page title and description component displays the name of the product";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 6));
	        plp.setMatchingTitleAndDescription();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	
	



	
	
	
	
	

	
	
	/******************************************************************************************************************************/
	public String takeScreenshot(String screenshotName) throws IOException {
	    WebDriver driver = Driver.getDriver();
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    String destination = "screenshots/" + screenshotName + ".png";
	    File target = new File(destination);
	    FileUtils.copyFile(source, target);
	    return destination;
	}
	public void captureScreenshotAndAddToReport(String testName) throws IOException {
		 String screenshotPath = takeScreenshot(testName);
		 ExtentTest test = extent.createTest(testName).pass("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}
	@AfterMethod
    public void closeTabs() {
        String currentWindow = Driver.getDriver().getWindowHandle();
        Set<String> allWindows = Driver.getDriver().getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
            	Driver.getDriver().switchTo().window(window);
            	Driver.getDriver().close();
            }
        }
        Driver.getDriver().switchTo().window(currentWindow);
         }
	public void tearDown(ITestResult result) throws IOException {
	    if (result.getStatus() == ITestResult.FAILURE) {
	        // Take screenshot if test method fails
	        String screenshotPath = takeScreenshot(result.getName() + "_failed");
	        test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    } else if (result.getStatus() == ITestResult.SUCCESS) {
	        // Take screenshot if test method passes
	        String screenshotPath = takeScreenshot(result.getName() + "_passed");
	        test.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    extent.flush();
	}
      @AfterSuite
	public void closingBrowser() {
		extent.flush();
		//Driver.closeDriver();
	}
	


	

}