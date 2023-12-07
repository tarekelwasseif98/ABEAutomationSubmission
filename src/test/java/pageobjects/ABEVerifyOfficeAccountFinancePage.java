package pageobjects;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABEVerifyOfficeAccountFinancePage {
	
	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By acidTextField = By.xpath("(//input[@id='_acctId'])[1]");
	private By GoButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By backgroundMenuButton = By.xpath("(//a[@id='GlobalbgMenu_anchor'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeId = By.xpath("//iframe[@name='formArea']");

	public ABEVerifyOfficeAccountFinancePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEVerifyOfficeAccountFinancePage sendKeysSearchBarTextField(String menu) throws Exception {
	     	driver.switchTo().parentFrame();
	     	PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, loginFrameIframeID);
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
	public ABEVerifyOfficeAccountFinancePage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.sleep();

		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnElement(driver, backgroundMenuButton);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		return this;	
	}

	@Step("Sending a/c. id: {0}")
	public ABEVerifyOfficeAccountFinancePage sendKeysAcidTextField(String ACID) throws Exception {
		ACID = ACID.substring(1);
		PageFunctionUtils.waitOnElement(driver, acidTextField);
		driver.findElement(acidTextField).click();
		driver.findElement(acidTextField).sendKeys(ACID);
		return this;
	}
	@Step("press go button")
	public ABEVerifyOfficeAccountFinancePage pressGoButton() throws Exception {
		driver.findElement(GoButton).click();
		return this;
	}
	
	@Step("Press submit button")
	public ABEVerifyOfficeAccountFinancePage pressSubmitButton() throws Exception {
		driver.findElement(submitButton).click();
		PageFunctionUtils.sleep();
		return this;
	}
	
	


}
