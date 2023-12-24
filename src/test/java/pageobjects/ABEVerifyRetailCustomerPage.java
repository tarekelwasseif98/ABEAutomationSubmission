package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABEVerifyRetailCustomerPage {

	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By htmlDataFrmIFrameXpath = By.xpath("//frame[@name='HTMLDataFrm'][1]");
	private By crmABEIFrameXpath = By.xpath("//iframe[@name='CRM_ABE']");
	private By loginFrameIframeXpath = By.xpath("//iframe[@name='loginFrame']");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']");
	private By adminButton = By.xpath("(//input[@id='login_Admin'])[1]");
	private By submitAdminButton = By.xpath("(//input[@id='submitBtn'])[1]");
	private By operationApproveDropDownList = By.xpath("(//select[@id='_operation_select'])[1]");
	private By cifIDTextField = By.xpath("(//input[@id='_cifId'])[1]");
	private By searchButtonRCCAT = By.xpath("(//button[normalize-space()='Search'])[1]");
	private By approveButton = By.xpath("(//a[normalize-space()='Approve'])[1]");
	private By decisionDropDownList = By.xpath("(//select[@id='_approval_FinComboBox1_select'])[1]");
	private By remarkTextBox = By.xpath("(//textarea[@id='_approval_FinTextArea1_textArea'])[1]");
	private By closedCIFSearch = By.xpath("(//button[normalize-space()='Closed CIF Search'])[1]");
	private By xClosedSearchButton = By.xpath("(//i[@class='material-icons'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");

	public ABEVerifyRetailCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEVerifyRetailCustomerPage sendKeysSearchBarTextField(String menu) throws Exception {
	     	driver.switchTo().parentFrame();
	     	PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, loginFrameIframeXpath);
			PageFunctionUtils.waitOnElement(driver, searchBarTextField);
	        PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
	        PageFunctionUtils.clickOnElement(driver, searchButton);
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        try {
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            alert.accept();
	            PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
		        PageFunctionUtils.clickOnElement(driver, searchButton);
	        } catch (Exception e) {
	        }
	        return this;        
	}
	
	@Step("Frame switching")
	public ABEVerifyRetailCustomerPage switchFormAreaFrame() throws Exception {
		driver.switchTo().parentFrame();
	    driver.switchTo().frame(("loginFrame"));
	    driver.switchTo().frame(("Core_ABE"));
	    driver.switchTo().frame(("UX"));
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Open RCCAT and verify")
	public ABEVerifyRetailCustomerPage enterDataAtRCCAT(String cif) throws Exception{
		PageFunctionUtils.selectDropDownListByIndex(driver, operationApproveDropDownList, 1);
		PageFunctionUtils.enterDataInWebElement(driver, cifIDTextField, cif.substring(1));
		PageFunctionUtils.clickOnElement(driver, searchButtonRCCAT);
		return this;
	}
	
	@Step("Approve CIF")
	public ABEVerifyRetailCustomerPage approveCIF() throws Exception{
		PageFunctionUtils.waitOnElement(driver, approveButton);
		PageFunctionUtils.clickOnElement(driver, approveButton);
		return this;
	}

	@Step("Select Admin View")
	public ABEVerifyRetailCustomerPage openRetailCustomerFirstPage() throws Exception {
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, loginFrameIframeXpath);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, crmABEIFrameXpath);
		PageFunctionUtils.clickOnElement(driver, adminButton);
		PageFunctionUtils.clickOnElement(driver, submitAdminButton);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, htmlDataFrmIFrameXpath);
		return this;
	}
	
	@Step("Approval Form")
	public ABEVerifyRetailCustomerPage approvalForm()throws Exception{
		PageFunctionUtils.waitOnElement(driver, decisionDropDownList);
		PageFunctionUtils.selectDropDownListByIndex(driver, decisionDropDownList, 3);
		driver.findElement(remarkTextBox).sendKeys("Done");
		PageFunctionUtils.clickOnElement(driver, closedCIFSearch);
		PageFunctionUtils.clickOnElement(driver, xClosedSearchButton);
		PageFunctionUtils.clickOnElement(driver, submitButton);
		return this;
	}
	
	
	
	
	
}