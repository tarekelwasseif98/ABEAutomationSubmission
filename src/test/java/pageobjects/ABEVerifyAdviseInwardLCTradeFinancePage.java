package pageobjects;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABEVerifyAdviseInwardLCTradeFinancePage {

	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']");
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By documentaryCreditNoTextField = By.xpath("(//input[@id='_odcmNum_O'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	//Side Navigation Menu
	private By relatedPartyDetailsSideNavigationMenu = By.xpath("(//span[@id='partydetid_textSpan'])[1]");
	private By documentaryCreditDetailsSideNavigationMenu = By.xpath("(//span[@id='doccredetid_textSpan'])[1]");
	private By chargesDetailsSideNavigationMenu = By.xpath("(//span[@id='chargeid_textSpan'])[1]");
	private By MessageDetailsSideNavigationMenu = By.xpath("(//span[@id='messagetabid_textSpan'])[1]");
	//Message details
	private By messageActionsImageButton = By.xpath("//a[@id='_messagedetails_mainmsgdet_FinDataGrid_viewIcon_0']//span[@class='viewcontent']");
	private By paymentStatusDropDownList = By.xpath("(//select[@id='_messagedetails_hid_mesdet_payStat_select'])[1]");
	private By acceptMessageActionsButton  = By.xpath("(//button[@id='_messagedetails_messageContinue'])[1]");
	private By closeMessageActionsButton = By.xpath("(//button[@id='_messagedetails_messagedet_closeBtn'])[1]");
    //Submit Record	
	private By acceptWarning = By.xpath("(//button[normalize-space()='Accept'])[1]");
	private By submitRecord = By.xpath("(//button[normalize-space()='Submit'])[1]");
	

	public ABEVerifyAdviseInwardLCTradeFinancePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name")
	public ABEVerifyAdviseInwardLCTradeFinancePage sendKeysSearchBarTextField(String menu) throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
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
	public ABEVerifyAdviseInwardLCTradeFinancePage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;
	}
	
	@Step("Enter the Documentary Credit No.")
	public ABEVerifyAdviseInwardLCTradeFinancePage enterDocCredit(String documentaryCreditNo) throws Exception {
		PageFunctionUtils.waitOnElement(driver, documentaryCreditNoTextField);
		PageFunctionUtils.enterDataInWebElement(driver, documentaryCreditNoTextField, documentaryCreditNo.substring(1));
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
	}
	
	@Step("Visit/Navigate Between SideMenus")
	public ABEVerifyAdviseInwardLCTradeFinancePage navigateBetweenSideMenus() throws Exception {
		PageFunctionUtils.waitOnElement(driver, relatedPartyDetailsSideNavigationMenu);
		PageFunctionUtils.clickOnElement(driver, relatedPartyDetailsSideNavigationMenu );
		PageFunctionUtils.clickOnElement(driver, documentaryCreditDetailsSideNavigationMenu);
		PageFunctionUtils.clickOnElement(driver, chargesDetailsSideNavigationMenu);
		return this;
	}
	
	@Step("Visit/Navigate Between SideMenus")
	public ABEVerifyAdviseInwardLCTradeFinancePage messageDetails() throws Exception {
		PageFunctionUtils.clickOnElement(driver, MessageDetailsSideNavigationMenu);
		PageFunctionUtils.waitOnElement(driver, messageActionsImageButton);
		PageFunctionUtils.clickOnElement(driver, messageActionsImageButton );
		PageFunctionUtils.waitOnElement(driver, paymentStatusDropDownList);
		PageFunctionUtils.selectDropDownListByIndex(driver, paymentStatusDropDownList, 2);
		PageFunctionUtils.clickOnElement(driver, acceptMessageActionsButton);
		PageFunctionUtils.clickOnElement(driver, closeMessageActionsButton);
		return this;
	}
	
	@Step("Submit Record")
	public ABEVerifyAdviseInwardLCTradeFinancePage submitRecord() throws Exception {
		PageFunctionUtils.waitOnElement(driver, submitRecord);
		PageFunctionUtils.clickOnElement(driver, submitRecord);
		try {
			driver.switchTo().parentFrame();
			PageFunctionUtils.clickOnElement(driver, acceptWarning);
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		} catch (Exception e) {
		}
		return this;
	}

}
