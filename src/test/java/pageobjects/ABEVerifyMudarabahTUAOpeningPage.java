package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABEVerifyMudarabahTUAOpeningPage {
	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeId = By.xpath("//iframe[@name='formArea']");
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By accountIdTextField = By.xpath("(//input[@id='_modacctid'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By additionalDetailsSideTab = By.xpath("(//span[@id='stepIII_textSpan'])[1]");
	private By generalDetailsSideTab = By.xpath("(//span[@id='stepIV_textSpan'])[1]");
	private By schemeDetailsSideTab = By.xpath("(//span[@id='stepV_textSpan'])[1]");
	private By profitAndTaxDetailsSideTab = By.xpath("(//span[@id='stepVI_textSpan'])[1]");
	private By relatedPartyDetailsSideTab = By.xpath("(//span[@id='stepVII_textSpan'])[1]");
	private By renewalAndClosureDetailsSideTab = By.xpath("(//span[@id='stepVIII_textSpan'])[1]");	
	private By paymentInstructionsDetailsSideTab = By.xpath("(//span[@id='stepIX_textSpan'])[1]");
	private By flowDetailsSideTab = By.xpath("(//span[@id='stepX_textSpan'])[1]");
	private By documentDetailsSideTab = By.xpath("(//span[@id='stepXII_textSpan'])[1]");
	private By misCodeDetailsSideTab = By.xpath("(//span[@id='stepXIII_textSpan'])[1]");
	private By otherDetailsSideTab = By.xpath("(//span[@id='stepXIV_textSpan'])[1]");
	private By menuNameTextBox = By.xpath("(//h1[normalize-space()='Verify Islamic Top Up Deposit Account Opening'])[1]");

	public ABEVerifyMudarabahTUAOpeningPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEVerifyMudarabahTUAOpeningPage sendKeysSearchBarTextField(String menu) throws Exception {
		if(menu != null) {
			PageFunctionUtils.sleep();
			PageFunctionUtils.switchToParentFrame(driver);
			PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
			PageFunctionUtils.waitOnElement(driver, searchBarTextField);
			PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
	        PageFunctionUtils.clickOnElement(driver, searchButton);	       
	        WebDriverWait wait = new WebDriverWait(driver, 45);
	        try {
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            alert.accept();
	            PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
		        PageFunctionUtils.clickOnElement(driver, searchButton);
		        }
	        catch (Exception e) {
	        }
        }
	return this;
	}
	
	@Step("Frame switching")
	public ABEVerifyMudarabahTUAOpeningPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		return this;	
	}
	
	@Step("Sending account id: {0}")
	public ABEVerifyMudarabahTUAOpeningPage sendKeysAccountIdTextField(String accountId) throws Exception {
		if(accountId != null) {
			PageFunctionUtils.waitOnElement(driver, accountIdTextField);
			PageFunctionUtils.clickOnElement(driver, accountIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, accountIdTextField, accountId.substring(1));
		}
		return this;
	}
	
	@Step("Press go button")
	public ABEVerifyMudarabahTUAOpeningPage pressGoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
	}
	
	@Step("Side tab navigation")
	public ABEVerifyMudarabahTUAOpeningPage navigateSideTabMenu() throws Exception {
		PageFunctionUtils.clickOnElement(driver, additionalDetailsSideTab);
		PageFunctionUtils.clickOnElement(driver, generalDetailsSideTab);
		PageFunctionUtils.clickOnElement(driver, schemeDetailsSideTab);
		PageFunctionUtils.clickOnElement(driver, profitAndTaxDetailsSideTab);
		PageFunctionUtils.clickOnElement(driver, relatedPartyDetailsSideTab);
		PageFunctionUtils.clickOnElement(driver, renewalAndClosureDetailsSideTab);
		PageFunctionUtils.clickOnElement(driver, paymentInstructionsDetailsSideTab);
		PageFunctionUtils.clickOnElement(driver, flowDetailsSideTab);
		PageFunctionUtils.clickOnElement(driver, documentDetailsSideTab);
		PageFunctionUtils.clickOnElement(driver, misCodeDetailsSideTab);
		PageFunctionUtils.clickOnElement(driver, otherDetailsSideTab);
		return this;
	}
	
	@Step("Press submit button")
	public ABEVerifyMudarabahTUAOpeningPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.acceptWarning(driver);
		PageFunctionUtils.sleep();
		PageFunctionUtils.acceptWarning(driver);
		PageFunctionUtils.scrollUpToElement(driver, menuNameTextBox);
		return this;
	}
}