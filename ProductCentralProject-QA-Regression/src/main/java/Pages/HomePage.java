package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;
import com.pwc.productcentral.ReadXLSdata;

public class HomePage extends HelperFunctions {
	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
		}
	@FindBy(xpath="//img[@class='cmp-hero__image']")
	private WebElement promotionBannerImage;
	
	@FindBy(xpath="//div[@class='cmp-hero__description']")
	private WebElement descriptionOfPromotionBanner;
	
	@FindBy(xpath="//div[@class='cmp-hero']")
	private WebElement promotionBanner;
	
	@FindBy(xpath="//div[@class='cmp-leftnavigation__items']")
	private static List<WebElement> leftNavigationItems2;
	
	@FindBy(xpath="//div[@class='cmp-tiles__entries']//a")
	private static List<WebElement> homePageTiles;
	
	@FindBy(xpath="(//div[@class='cmp-tiles__entry-title'])[1]")
	private WebElement legalTile;
	
	@FindBy(xpath="//div[@class='cmp-tiles__entries']//a[1]")
	private WebElement FirsthomePageTile;
	
	@FindBy(xpath="//div[@class='cmp-product-list__search-bar-container']")
	private WebElement landingPageComponentForLegalTile;
	
	@FindBy(xpath="//div[@class='cmp-tiles__entry-title']")
	private static List<WebElement> titleOfTiles;
	
	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private WebElement oneStopTitle;
	
	@FindBy(xpath="//div[@class='cmp-tiles__entry-desc']")
	private static List<WebElement> descriptionOfTiles;
	
	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private WebElement title;
	
	@FindBy(xpath="//div[@class='text cmp-tiles__description']")
	private WebElement descriptionOfTitle;
	
	@FindBy(xpath="(//a[@href='/us/en/my-products.html'])[1]")
	private WebElement logintoMyProduct;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/automation/homepage-demo/jcr:content/root/container/container/tiles/title']")
	private WebElement titleforAuthor;
	
	@FindBy(xpath="//button[@id='searchButtonHeader']")
	private WebElement searchButton;
	
	@FindBy(xpath="//input[@id='globalSearchInput']")
	private WebElement searchInput;
	
	@FindBy(xpath="//div[@id='searchProductDropdown']")
	private WebElement productDropdown;
	
	@FindBy(xpath="//div[@class='ap-dropdown-list show']//div//label")
	private static List<WebElement> productDropdownList;
	
	@FindBy(xpath="//input[@id='change-navigator']")
	private WebElement changeNavigatorCheckbox;
	
	@FindBy(xpath="//div[@id='docDropdown']")
	private WebElement catDropdown;
	
	@FindBy(xpath="//div[@id='searchSortingDropdown']")
	private WebElement sortingDropdown;
	
	@FindBy(xpath="//input[@id='data-processing-addendum']")
	private WebElement dataAppCheckbox;
	
	@FindBy(xpath="//input[@id='documentation']")
	private WebElement documentationCheckbox;
	
	@FindBy(xpath="(//div[@class='cmp-search-results__card-title'])[1]")
	private WebElement dataAppTitle;
	
	@FindBy(xpath="(//div[@class='cmp-search-results__card-title'])[2]")
	private WebElement documentationTitle;
	
	@FindBy(xpath="//span[@class='sdk-HeaderFileInfoView-fileBreadCrumb sdk-HeaderFileInfoView-fileBreadCrumbNormal']")
	private WebElement dataAppContent;
	
	@FindBy(xpath="(//div[@class='ap-dropdown-option-item'])//input")
	private static List<WebElement> catDropdownCheckboxes;
	
	@FindBy(xpath="((//div[@class='cmp-search-results__page ap-page-container'])//div[3])[position()=1 or position()=2 or position()=3 or position()=4 or position()=5 or position()=6 or position()=7 or position()=8 or position()=9 or position()=10]")
	private static List<WebElement> resultList;
	
	@FindBy(xpath="(//a[@href='/us/en/my-products.html'])[1]")
	private WebElement loginToMyProductLink;
	
	@FindBy(xpath="(//*[@id='searchProductDropdown']/div[2])//div")
	private static List<WebElement> productDropdownItems;
	
	@FindBy(xpath="//*[@id='docDropdown']/div[2]//div")
	private static List<WebElement> catDropdownItems;
	
	@FindBy(xpath="(//div[@class='ap-dropdown-list show'])[2]//div//label")
	private static List<WebElement> catDropdownList;
	
	@FindBy(xpath="//div[@data-href='/content/pc/us/en/my-products/product-4.html']")
	private WebElement loginLink;
	
	@FindBy(xpath="//img[@id='PwCLogo']")
	private WebElement pwcLogo;
	
	@FindBy(xpath="//input[@id='initEmail']")
	private WebElement email;
	
	@FindBy(xpath="//button[.='Next']")
	private WebElement next;
	
	@FindBy(xpath="//input[@class='ap-dropdown-option-checkbox']")
	private static List<WebElement> productCheckbox;
	
	@FindBy(xpath="//div[@class='cmp-search-results__card-title']")
	private static List<WebElement> resultsTitles;
	
	@FindBy(xpath="//div[@class='ap-dropdown-list show']")
	private static List<WebElement> productDropdownList2;
	
	@FindBy(xpath="//div[@class='cmp-pdfviewer']")
	private WebElement pdfViewer;
	
	@FindBy(xpath="//div[@class='cmp-tiles__products-link']")
	private static List<WebElement> loginToMyProductsLinks;
	
	@FindBy(xpath="//div[@id='resultsContainer']//div//a")
	private WebElement resultContainer;
	
	@FindBy(xpath="//div[@class='cmp-breadcrumb']//a")
	private WebElement breadCrumb;
	
	@FindBy(xpath="//input[@aria-label='Search Product']")
	private WebElement searchProducts;
	
	@FindBy(xpath="//div[@class='ap-option-item']")
	private WebElement optionItem;
	
	@FindBy(xpath="//a[@class='cmp-product-list__card-link']")
	private WebElement resultLink;
	
	@FindBy(xpath="//h1[@class='cmp-hero__title']")
	private WebElement promoTitle;
	
	@FindBy(xpath="//div[@class='cmp-hero__action-container']")
	private WebElement promoActionCont;
	
	@FindBy(xpath="//div[@class='ap-footer-link-group']//div")
	private static List<WebElement> footerElements;
	
	@FindBy(xpath="//div[@class='ap-footer-content']")
	private static WebElement footerHome;
	
	@FindBy(xpath="//div[@class='cmp-tiles__entries']//a[1]")
	private static WebElement firstTile;
	
	
	ReadXLSdata read2=new ReadXLSdata();
	
	
		
	static Logger logger=Logger.getLogger("HomePage");
	
	public void setTitlesColor() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		 for (WebElement title : titleOfTiles) { 

	           String color = title.getCssValue("color");
	           String hexColor = Color.fromString(color).asHex(); 
	           if(hexColor.equals("#252525")) {
	        	   String successMessage = "Color of Titles is black";
			        logger.info(successMessage);
				Assert.assertTrue(true);
	           }else {
	        	   String errorMessage = "Color of Titles is not black";
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
	           }
	          
	       }
	}
	
	public void setTilesNumber() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		int numberOfTiles=homePageTiles.size();
		if(numberOfTiles<=15) {
			Assert.assertTrue(true);
		}else {
			 String errorMessage = "Tiles' size more than 15 ";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		}
	}
	
	public void setTilesHasLoginLink() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		if(FirsthomePageTile.getText().contains("My Products")&&FirsthomePageTile.getText().contains("Login to My Products")) {
			Assert.assertTrue(true);
		}else {
			 String errorMessage = "My Product Tile does not contain 'login to my product' link";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		}
	}
	
public void setLegalTile() {
		
		HelperFunctions.waitForPageToLoad(5);
		for (WebElement link : homePageTiles) {
		    try {
		        String expectedUrl = link.getAttribute("href");
		        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
		        WebElement linkClickable = wait.until(ExpectedConditions.elementToBeClickable(link));
		        linkClickable.click();
		        String actualUrl = Driver.getDriver().getCurrentUrl();
		        Assert.assertTrue(actualUrl.startsWith("https://login"));
		    } catch (StaleElementReferenceException e) {
		      
		    }
		}
   
		
	}

public void setPromoTitle() throws Exception {
	HelperFunctions.waitForPageToLoad(5);
	HelperFunctions.staticWait(3);
	if(promoTitle.getText().equalsIgnoreCase("Welcome to Product Central")) {
		Assert.assertTrue(true);
	}else {
		 String errorMessage = "Promotion banner does not contain a page title 'Welcome to Product Central' ";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
	}
}

public void setPromotionBannerElements() throws Exception {
	HelperFunctions.waitForPageToLoad(5);
	HelperFunctions.staticWait(3);
	if(promotionBannerImage.isDisplayed()&&descriptionOfPromotionBanner.isDisplayed()&&promoTitle.isDisplayed()&&promoActionCont.isDisplayed()) {
		Assert.assertTrue(true);
	}else {
		 String errorMessage = "Missing promotion banner element";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
	}
}

public void setFooterBar() throws Exception {
	HelperFunctions.waitForPageToLoad(5);
	HelperFunctions.staticWait(3);
	HelperFunctions.scrollToElement(footerHome);
	HelperFunctions.staticWait(3);
	for(WebElement element: footerElements) {
		if(element.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			String errorMessage = "Missing footer element";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
		}
	}
	if(footerHome.isDisplayed()) {
		Assert.assertTrue(true);
	}else {
		String errorMessage = "Missing footer text";
        logger.error(errorMessage);
        throw new Exception(errorMessage);
	}
}

public void setDescriptionOfTiles() throws Exception {
	HelperFunctions.waitForPageToLoad(5);
	for(WebElement eachDescription: descriptionOfTiles) {
		System.out.println(eachDescription.getCssValue("-webkit-line-clamp"));
		if(eachDescription.getCssValue("-webkit-line-clamp").equals("6")) {
			 String successMessage = "The description is 6 lines";
		        logger.info(successMessage);
			Assert.assertTrue(true);
		}else {
			 String errorMessage = "The description is more than 6 lines";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);

			
		}
	}
}

public void setClickability() throws Exception {
	HelperFunctions.waitForPageToLoad(5);
	String beforeBoxShadow = firstTile.getCssValue("box-shadow");
	System.out.println(beforeBoxShadow);
	Actions actions = new Actions(Driver.getDriver());

	actions.moveToElement(firstTile).perform();
	HelperFunctions.staticWait(3);
	String afterBoxShadow = firstTile.getCssValue("box-shadow");
	System.out.println(afterBoxShadow);
	if(!beforeBoxShadow.equals(afterBoxShadow)) {
		String successMessage = "Tile shadow has changed";
        logger.info(successMessage);
	Assert.assertTrue(true);
	}else {
		 String errorMessage = "Tile shadow has not changed";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);

	}
}
	
	 
	

	
	
	
	
	
	
	
	
}
