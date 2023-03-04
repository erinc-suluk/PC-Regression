package Pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import com.github.javafaker.Faker;
import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;



public class ProductListingPage extends HelperFunctions {
	public ProductListingPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		}
	
	
	
	@FindBy(xpath="//div[@class='cmp-related-links__items']//div//a")
	private static List<WebElement> allLinks;
	
	@FindBy(xpath="//div[@class='cmp-related-links']")
	private static List<WebElement> allLinks2;
	
	@FindBy(xpath="//a[@href='/us/en/automation/products/cloud/offering-overview.html']")
	private WebElement offeringOverviewFromCloud;
	
	@FindBy(xpath="//a[@href='/us/en/automation/products/cloud/terms---conditions.html']")
	private WebElement termsAndConditionsLink;
	
	@FindBy(xpath="(//span[.='PricewaterhouseCoopers2'])[1]")
	private WebElement termsAndConditionsTitle;
	
	@FindBy(xpath="//a[@href='/us/en/automation/products/cloud/maintenance---support.html']")
	private WebElement maintenanceAndSupportLink;
	
	@FindBy(xpath="(//span[.='sample (5)'])[1]")
	private WebElement headerForMaintenanceAndSupport;
	
	
	@FindBy(xpath="//a[@href='/us/en/automation/products/cloud/offering-overview.html']")
	private WebElement offeringOverviewLink;
	
	@FindBy(xpath="(//span[.='PDF Template for AEM Testing'])[1]")
	private WebElement offeringOverviewLinkTitle;
	
	
	@FindBy(xpath="//a[@href='/us/en/automation/products/cloud/documentation.html']")
	private WebElement documentationLink;
	
	@FindBy(xpath="(//span[.='PDF Template for AEM Testing'])[2]")
	private WebElement documentationTitle;
	
	@FindBy(xpath="//div[@class='HUDView__hudContainer___3mx_O HUDView__immersiveShow___1pWVE']")
	private WebElement offeringPdfIcon;
	
	@FindBy(xpath="//nav[@id='skinny-rail']")
	private WebElement pdfIcon;
	
	@FindBy(linkText="Back to Cloud")
	private WebElement backToCloudBreadcrumb;
	
	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private WebElement cloudTitle;
	
	@FindBy(linkText="Back to Products")
	private WebElement backToProductsBreadcrumb;
	
	@FindBy(xpath="//h1[@class='cmp-product-list__search-bar-title']")
	private WebElement productsTitle;
	
	@FindBy(xpath="//input[@aria-label='Search Product']")
	private WebElement searchProduct;
	
	@FindBy(xpath="//div[@class='ap-option-item']")
	private WebElement searchItem;
	
	@FindBy(xpath="//span[@class='cmp-product-list__card-title ']")
	private WebElement products;
	
	@FindBy(xpath="//a[@data-product-name='Strategic']")
	private WebElement strategicProduct;
	
	@FindBy(xpath="//a[@data-product-name='Cloud']")
	private WebElement cloudProduct;
	
	@FindBy(xpath="//a[@data-product-name='Risk']")
	private WebElement riskProduct;
	
	@FindBy(xpath="//input[@placeholder='Search Products']")
	private WebElement productSearchBar;
	
	@FindBy(xpath="//div[@class='has-no-results']")
	private WebElement noResult;
	
	@FindBy(xpath="//div[@class='cmp-product-list__card-content']//span[2]")
	private static List<WebElement> titleofTiles;
	
	@FindBy(xpath="//span[@class='cmp-pdf-highlights__title']")
	private WebElement contentTitle;
	
	@FindBy(xpath="//div[@id='pdfviewer-cc9adec430-content']")
	private WebElement termsConditionContent;
	
	@FindBy(xpath="//div[@id='pdfviewer-4fb6948d1d-content']")
	private WebElement offeringOverviewContent;
	
	@FindBy(xpath="//div[@id='pdfviewer-4fb8297d06-content']")
	private WebElement documentationContent;
	
	@FindBy(xpath="//div[@id='pdfviewer-033ffa1470-content']")
	private WebElement maintenanceContent;
	
	@FindBy(xpath="//div[@class='cmp-breadcrumb']//a")
	private static List<WebElement> breadcrumbLinks;
	
	@FindBy(xpath="//div[@class='cmp-pdfviewer']")
	private WebElement pdfViewer;
	
	@FindBy(xpath="//div[@class='cmp-product-list__card-content']//span")
	private static List<WebElement> cardTitle;
	
	@FindBy(xpath="//div[@class='cmp-product-list__cards-container']//a")
	private static List<WebElement> productLinks;
	
	@FindBy(xpath="//div[@class='cmp-product-list__cards-alphabet-section']//div//a[2]")
	private WebElement productBasedonSearch;
	
	@FindBy(xpath="//span[@class='cmp-related-links__download-text']")
	private WebElement downloadLink;
	
	@FindBy(xpath="(//a[@href='/us/en/products/change-navigator/documentation.html'])[2]")
	private WebElement documentationLink2;
	
	@FindBy(xpath="//a[@href='/us/en/products/change-navigator/privacysecurity.html']")
	private WebElement privacyandSecurityLink;
	
	@FindBy(xpath="//div[@class='cmp-document-tiles__entry-info-container']//div[1]")
	private static List<WebElement> productTitles;
	
	@FindBy(xpath="//div[@class='cmp-document-tiles__entry-info-container']//div[2]")
	private static List<WebElement> productDescriptions;
	
	
	
	
	static Logger logger=Logger.getLogger("ProductListingPage");
	
	
	
	
	



   

    public void setAllLinks() throws IOException { 
    	HelperFunctions.waitForPageToLoad(5);
    	  for (WebElement link : allLinks) {
            
              String href = link.getAttribute("href");

          
              if (!href.isEmpty()) {
            
                  System.out.println(href);
                  Assert.assertTrue(true);
              }else {
            	  Assert.assertTrue(false);
              }
          }
    	
    }


	
    
    public void setLinks() {
    	
    	for (WebElement link : allLinks) {
    	    try {
    	        link.click();   
    	        Assert.assertNotNull(pdfViewer);
    	    } catch (StaleElementReferenceException e) { 
    	       
    	    }
    	}
    }
    
    public void setPdfControllers() {
    	
    	for (WebElement link : allLinks) {
    	    try {
    	        link.click();   
    	        Assert.assertNotNull(pdfIcon);
    	    } catch (StaleElementReferenceException e) {
    	       
    	    }
    	}
    	
    
    }

	

	public void setBreadcrumbs() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		 for (WebElement link : breadcrumbLinks) {
			 String hrefValue = link.getAttribute("href");
			 link.click();
			 String currentUrl = Driver.getDriver().getCurrentUrl();
			// Assert.assertEquals(hrefValue, currentUrl);
			  if (!hrefValue.equals(currentUrl)) {
				  String errorMessage = "The promotion banner does not match with the expected text.";
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
			  }else {
				  String successMessage = "The promotion banner contains an image";
			        logger.info(successMessage);
			  }
	            }
    
         
			 
	
	
	}
	public void setBreadcrumbsVisibility() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		 for (WebElement link : breadcrumbLinks) {
			 String hrefValue = link.getAttribute("href");
			 link.click();
			 String currentUrl = Driver.getDriver().getCurrentUrl();
			// Assert.assertEquals(hrefValue, currentUrl);
			  if (!hrefValue.equals(currentUrl)&& link.isDisplayed()) {
				  String errorMessage = "The promotion banner does not match with the expected text.";
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
			  }else {
				  String successMessage = "The promotion banner contains an image";
			        logger.info(successMessage);
			  }
	            }
    
         
			 
	
	
	}
	public void setLinkOfBreadcrumbs() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
    
		for (WebElement link : breadcrumbLinks) {
			if(link.getAttribute("href")!=null) {
				 String successMessage = "Breadcrumb contains a link.";
			        logger.info(successMessage);
				Assert.assertTrue(true);
			}else {
				 String errorMessage = "Breadcrumb does not contain a link.";
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
			//	Assert.assertTrue(false);
			}
		}

		
	}
	
	public void setSearchBox() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		searchProduct.click();
		String str="Customer Link";
		searchProduct.sendKeys(str);
		HelperFunctions.staticWait(3);
		searchItem.click();
		HelperFunctions.staticWait(3);
		System.out.println(productBasedonSearch.getAttribute("data-product-name"));
		if(productBasedonSearch.getAttribute("data-product-name").equalsIgnoreCase(str)) {
			 String successMessage = "Texts are matching";
		        logger.info(successMessage);
			Assert.assertTrue(true);
		}else {
			 String errorMessage = "Texts are not matching.";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		//	Assert.assertTrue(false);
		}
		HelperFunctions.staticWait(3);
		searchProduct.click();
		HelperFunctions.staticWait(3);
		searchProduct.clear();
		String str2="Digital on Demand";
		searchProduct.sendKeys(str2);
		HelperFunctions.staticWait(3);
		searchItem.click();
		HelperFunctions.staticWait(3);
		System.out.println(productBasedonSearch.getAttribute("data-product-name"));
		if(productBasedonSearch.getAttribute("data-product-name").equalsIgnoreCase(str2)) {
			 String successMessage = "Texts are matching";
		        logger.info(successMessage);
			Assert.assertTrue(true);
		}else {
			 String errorMessage = "Texts are not matching."; 
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		//	Assert.assertTrue(false);
		}
		
		
		
		
	}
	
	public void setSearchResult() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		searchProduct.click();
		String str="Cus";
		String str2="Customer Link";
		searchProduct.sendKeys(str);
		HelperFunctions.staticWait(3);
		searchItem.click();
		HelperFunctions.staticWait(3);
		if(productBasedonSearch.getAttribute("data-product-name").equalsIgnoreCase(str2)) {
			 String successMessage = "Texts are matching";
		        logger.info(successMessage);
			Assert.assertTrue(true);
		}else {
			 String errorMessage = "Texts are not matching.";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		//	Assert.assertTrue(false);
		}
		HelperFunctions.staticWait(3);
		searchProduct.click();
		HelperFunctions.staticWait(3);
		searchProduct.clear();
		String str3="Dig";
		String str4="Digital on Demand";
		searchProduct.sendKeys(str3);
		HelperFunctions.staticWait(3);
		searchItem.click();
		HelperFunctions.staticWait(3);
		if(productBasedonSearch.getAttribute("data-product-name").equalsIgnoreCase(str4)) {
			String successMessage = "Texts are matching";
	        logger.info(successMessage);
			Assert.assertTrue(true);
		}else {
			 String errorMessage = "Texts are not matching.";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
			//Assert.assertTrue(false);
		}

			
		
	}
	
	public void setSearchBarKeywordforNegativeTest() {
		HelperFunctions.waitForPageToLoad(5);
		productSearchBar.click();
		Faker faker=new Faker();
		productSearchBar.sendKeys(faker.name().firstName());
		if(noResult.isDisplayed() && noResult.getText().contains("Nothing matches your results")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		
	}
	
	public void setDocumentTileLine() {
		HelperFunctions.waitForPageToLoad(5);
		for(WebElement eachProductTitle: titleofTiles) {
			System.out.println(eachProductTitle.getCssValue("-webkit-line-clamp"));
			if(eachProductTitle.getCssValue("-webkit-line-clamp").equals("2")) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
				
			}
		}
	}
	public void setContentPageSameTab() {
		HelperFunctions.waitForPageToLoad(5);
		for(WebElement each:productLinks) {
			each.click();
			break;
		}
		HelperFunctions.waitForPageToLoad(5);
		 for (WebElement link : productLinks) {
			 String hrefValue = link.getAttribute("href");
			 link.click();
			 String currentUrl = Driver.getDriver().getCurrentUrl();
			 Assert.assertEquals(hrefValue, currentUrl);
	            }
		
		
	}
	
	
	public void setDownloadFullTermsLink() {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		 downloadLink.click();
		 HelperFunctions.staticWait(3);
	        String filePath = "C:\\Users\\erong\\Downloads\\Bookkeeping-Connect-Full-Terms-3-2-2023.zip";
	        File file = new File(filePath);
	        int attempts = 0;
	        while (!file.exists() && attempts < 5) {
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            attempts++;
	        }
	        Assert.assertTrue(file.exists());
		
		
	}
	
	public void setDocumentationTileChanging() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		documentationLink2.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		for(WebElement link:allLinks2) {
			System.out.println(link.getText());
			if(link.getText().contains("Privacy and Security")) {
				String successMessage = "Related links contain Privacy and Security Link";
		        logger.info(successMessage);
			}else {
				String errorMessage = "Related links do not contain Privacy and Security Link";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
			}
		}
		HelperFunctions.staticWait(3);
		JavascriptExecutor executor13 = (JavascriptExecutor) Driver.getDriver();
	    executor13.executeScript("arguments[0].click();", privacyandSecurityLink);
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		 String title = Driver.getDriver().getTitle();
		 if(title.contains("Privacy & Security")) {
			 String successMessage = "Privacy & Security Page is verified";
		        logger.info(successMessage);
			Assert.assertTrue(true); 
		 }else {
			 String errorMessage = "Privacy & Security is not verified";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		 }
		 HelperFunctions.staticWait(2);
	}
	
	
    
	public void setProductDescription() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		List<String> titles = new ArrayList<String>();
		List<String> descriptions = new ArrayList<String>();

		for (WebElement titleElement : productTitles) {
		    titles.add(titleElement.getText());
		}
		for (WebElement descElement : productDescriptions) {
		    descriptions.add(descElement.getText());
		}
		for (int i = 0; i < titles.size(); i++) {
		    String title = titles.get(i);
		    String desc = descriptions.get(i);
		    String titlePrefix = title.substring(0, 4).toLowerCase();
		    if (desc.toLowerCase().contains(titlePrefix)) {
		    	 String successMessage = "Title and description match for element";
			        logger.info(successMessage);
		    } else {
		    	 String errorMessage = "Title and description do not match for element"+i;
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
		       
		    }
		}
         
			 
	
	
	}
	
	public void setProductTitleandDescriptionVisibility() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		List<String> titles = new ArrayList<String>();
		List<String> descriptions = new ArrayList<String>();

		for (WebElement titleElement : productTitles) {
		    if (titleElement.isDisplayed()) {
		        titles.add(titleElement.getText());
		    }else {
		    	 String errorMessage = "Titles are not visible";
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
		    }
		}

		for (WebElement descElement : productDescriptions) {
		    if (descElement.isDisplayed()) {
		        descriptions.add(descElement.getText());
		    }else {
		    	 String errorMessage = "Descriptions are not visible";
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
		    }
		}

         
			 
	
	
	}
	
	public void setContentPageTags() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		for (WebElement link : allLinks) {
		    String linkText = link.getText();
		    String linkUrl = link.getAttribute("href");
		    link.click();
		    HelperFunctions.staticWait(2);
		    String pageTitle = Driver.getDriver().getTitle();
		    System.out.println(pageTitle);
		    Assert.assertTrue(pageTitle.toLowerCase().contains(linkText.substring(0, 4).toLowerCase()));
		    break;
		}
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);
		WebElement linkToClick = allLinks.get(1);
		String linkText = linkToClick.getText();
		String linkUrl = linkToClick.getAttribute("href");

		linkToClick.click();
		HelperFunctions.staticWait(2);
		String pageTitle = Driver.getDriver().getTitle();
		Assert.assertTrue(pageTitle.toLowerCase().contains(linkText.substring(0, 4).toLowerCase()));
		
	}
	
	
	
	
	
	
	
   
        
	
		
		
	     
     
	    
	      
	
	
	

}
