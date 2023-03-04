package Pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.github.javafaker.Faker;
import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;
import com.pwc.productcentral.ReadXLSdata;

public class UMSPage extends HelperFunctions {
	public UMSPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		} 
	
	
	@FindBy(xpath="//input[@id='initEmail']")
	private WebElement email;
	
	@FindBy(xpath="//button[.='Next']")
	private WebElement next;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement pass;
	
	@FindBy(xpath="//button[.='Submit']")
	private WebElement submit;
	
	@FindBy(xpath="(//button[.='Add User'])[3]")
	private WebElement addUser;
	
	@FindBy(xpath="(//button[.='Add User'])[4]")
	private WebElement addUser2;
	
	@FindBy(xpath="//input[@name='emailAddress']")
	private WebElement emailAddress;
	
	@FindBy(xpath="//input[@name='firstName']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastName']")
	private WebElement lastName;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveButton;
	
	@FindBy(xpath="(//div[@class='ap-field-validation-error ng-star-inserted'])[position()=1]")
	private WebElement firstErrorMessage;
	
	@FindBy(xpath="(//div[@class='ap-field-validation-error ng-star-inserted'])[position()=2]")
	private WebElement secondErrorMessage;
	
	@FindBy(xpath="(//div[@class='ap-field-validation-error ng-star-inserted'])[position()=3]")
	private WebElement thirdErrorMessage;
	
	@FindBy(xpath="(//i[@alt='toggle icon'])[1]")
	private WebElement selectUserLevel;
	
	@FindBy(xpath="//label[.='User']")
	private WebElement userLabel;
	
	@FindBy(xpath="//label[.='Admin']")
	private WebElement adminLabel;
	
	@FindBy(xpath="(//i[@alt='toggle icon'])[2]")
	private WebElement selectProducts;
	
	@FindBy(xpath="//div[@class='ap-dropdown-select disabled']")
	private WebElement selectProducts2;
	
	@FindBy(xpath="//div[@class='ap-checkbox']")
	private static List<WebElement> checkBoxes;
	
	@FindBy(xpath="//label[@class='ap-option-label']")
	private static List<WebElement> checkBoxes2;
	
	@FindBy(xpath="(//mat-expansion-panel-header[starts-with(@id, \"mat-expansion-panel-header\")])[3]")
	private WebElement checkProducts;
	
	@FindBy(xpath="(//span[.='Product 2'])[1]")
	private WebElement product2;
	

	
	@FindBy(xpath="(((//table[starts-with(@class, \"ng-tns\")])[9])//tr)[9]//td[4]//button")
	private WebElement otherProductUsers;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement searchUsers;
	
	@FindBy(xpath="//span[.=' close']")
	private WebElement closeUsers;
	
	@FindBy(xpath="//div[@class='cdk-virtual-scroll-content-wrapper']//tbody//tr//td")
	private static List<WebElement> allUsers;
	
	@FindBy(xpath="(//table[@class='ng-tns-c58-13'])[2]//td[3]")
	private static List<WebElement> features;
	
	@FindBy(xpath="(//table[@class='ng-tns-c58-13'])[2]//td[2]")
	private static List<WebElement> products;
	
	@FindBy(xpath="((//table[starts-with(@class, \"ng-tns\")])[9])//tr")
	private static List<WebElement> productsRows;
	
	@FindBy(xpath="(((//table[starts-with(@class, \"ng-tns\")])[9])//tr)[8]//td[4]//button")
	private WebElement product2users;
	
	@FindBy(xpath="(((//table[starts-with(@class, \"ng-tns\")])[9])//tr)[8]//td[2]")
	private WebElement product2Title;
	
	@FindBy(xpath="//td[@class='emailAdd']")
	private WebElement emailForVerification;
	
	@FindBy(xpath="//div[@class='table ap-table-div']")
	private WebElement resultTable;
	
		
	
	ReadXLSdata read1=new ReadXLSdata();
	static Logger logger=Logger.getLogger("UMSPage");
	
}
