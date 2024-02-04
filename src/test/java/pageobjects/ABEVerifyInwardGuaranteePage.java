package pageobjects;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import utils.Paths;

public class ABEVerifyInwardGuaranteePage {


	

	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeID = By.xpath("//iframe[@name='formArea']");
	private String loginFrameIframeID = "loginFrame";
	private By but = By.xpath("(//a[@id='GlobalbgMenu_anchor'])[1]");
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	
	private By guaranteeIdTextField = By.xpath("(//input[@id='_othrGrntNo'])[1]");	
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");			

	
	private By generalDetailsContinueButton = By.xpath("(//button[@id='_ogmgendtls_gendet_Continue'])[1]");
	private By partyContinueButton = By.xpath("(//button[@id='_ogmpartydtls_partydet_Continue'])[1]");
	
	private By guaranteeContinueButton = By.xpath("(//button[@id='_igmguarntee_guarentedet_Continue'])[1]");
	
	private By limitContinueButton = By.xpath("(//button[@id='_limit_limit_Continue'])[1]");
	private By marginContinueButton = By.xpath("(//button[@id='_margin_margin_Continue'])[1]");
	private By chargesContinueButton = By.xpath("(//button[@id='_charge_charge_Continue'])[1]");
	private By instructionContinueButton = By.xpath("(//button[@id='_meobinstr_instructContineBtn'])[1]");
	

	private By textContinueButton = By.xpath("(//button[@id='_textdet_textdet_Continue'])[1]");
	

	private By viewFirstMessageButtonLiber = By.xpath("(//span[@class='viewcontent'])[2]");			
	private By viewFirstMessageButton = By.xpath("(//span[@class='viewcontent'])[2]");		
	private By acceptFirstMessageButton   = By.xpath("(//button[@id='_messagedetails_messageContinue'])[1]");
	private By closeFirstMessageButton = By.xpath("(//button[@id='_messagedetails_messagedet_closeBtn'])[1]");
	private By paymentStatusDropdown = By.xpath("(//select[@id='_messagedetails_hid_mesdet_payStat_select'])[1]");


	private By viewSecondMessageButton = By.xpath("(//span[@class='viewcontent'])[3]");	
	private By acceptSecondMessageButton   = By.xpath("(//button[@id='_messagedetails_messageContinue'])[1]");
	private By closeSecondMessageButton = By.xpath("(//button[@id='_messagedetails_messagedet_closeBtn'])[1]");

	
	private By messageContinueButton = By.xpath("(//button[@id='_messagedetails_msgdet_Continue'])[1]");
	
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	
	
	public ABEVerifyInwardGuaranteePage(WebDriver driver) {
		this.driver = driver;
	}
		
	

	@Step("Sending menu name: {0}")
	public ABEVerifyInwardGuaranteePage sendKeysSearchBarTextField(String menu) throws Exception {
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
	        }
        catch (Exception e) {
        }
        
        /*
        try {
        	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (Exception e) {
        	
        }
        PageFunctionUtils.sleep();
        try {
        	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (Exception e) {
        	
        }
        driver.findElement(By.xpath("(//input[@id='usertxt'])[1]")).sendKeys("ABE40");
        try {
        	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (Exception e) {
        	
        }
        driver.findElement(By.xpath("(//input[@id='passtxt'])[1]")).sendKeys("Infy@123");
        driver.findElement(By.xpath("(//input[@id='Submit'])[1]")).click();*/
	return this;
	}
	
	
	
	
	@Step("Frame switching")
	public ABEVerifyInwardGuaranteePage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnElement(driver, but);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending a/c. id: {0}")
	public ABEVerifyInwardGuaranteePage sendKeysGuaranteeIdTextField(String guaranteeNumberReferenceId) throws Exception {		
		PageFunctionUtils.waitOnElement(driver, guaranteeIdTextField);
		PageFunctionUtils.waitOnElement(driver, guaranteeIdTextField);	
		PageFunctionUtils.enterDataInWebElement(driver, guaranteeIdTextField, guaranteeNumberReferenceId.substring(1));
				
		return this;
	}
	
	
	@Step("press on go button")
	public ABEVerifyInwardGuaranteePage pressGoButton() throws Exception {	
		PageFunctionUtils.clickOnElement(driver, goButton);	
			return this;
	}
	
	
	@Step("press on general details continue button")
	public ABEVerifyInwardGuaranteePage pressGeneralDetailsContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, generalDetailsContinueButton);
		PageFunctionUtils.clickOnElement(driver, generalDetailsContinueButton);
			return this;
	}
	
	
	@Step("press on party continue button")
	public ABEVerifyInwardGuaranteePage pressPartyContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, partyContinueButton);
		PageFunctionUtils.clickOnElement(driver, partyContinueButton);
		return this;
}

	
	@Step("press on Guarantee continue button")
	public ABEVerifyInwardGuaranteePage pressGuaranteeContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, guaranteeContinueButton);
		PageFunctionUtils.clickOnElement(driver, guaranteeContinueButton);
		return this;
}
	
	
	@Step("press on Limite continue button")
	public ABEVerifyInwardGuaranteePage pressLimitContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, limitContinueButton);
		PageFunctionUtils.clickOnElement(driver, limitContinueButton);
		return this;
}

	
	@Step("press on margin continue button")
	public ABEVerifyInwardGuaranteePage pressMarginContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, marginContinueButton);
		PageFunctionUtils.clickOnElement(driver, marginContinueButton);
		return this;
}

	
	@Step("press on charges continue button")
	public ABEVerifyInwardGuaranteePage pressChargesContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, chargesContinueButton);
		PageFunctionUtils.clickOnElement(driver, chargesContinueButton);
		return this;
}
	

	


	@Step("press on instruction continue button")
	public ABEVerifyInwardGuaranteePage pressInstructionContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, instructionContinueButton);
		PageFunctionUtils.clickOnElement(driver,instructionContinueButton);
		return this;
}
	
	
	

	
	

	@Step("press on text continue button")
	public ABEVerifyInwardGuaranteePage pressTextContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, textContinueButton);
		PageFunctionUtils.clickOnElement(driver, textContinueButton);
		return this;
}
	
	
	@Step("press on view first message button")
	public ABEVerifyInwardGuaranteePage pressViewFirstMessageButtonLiber() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, viewFirstMessageButtonLiber);
		PageFunctionUtils.clickOnElement(driver, viewFirstMessageButtonLiber);
		return this;
	}
	
	

@Step("press on view first message button")
public ABEVerifyInwardGuaranteePage pressViewFirstMessageButton() throws Exception {	
	PageFunctionUtils.waitOnElement(driver, viewFirstMessageButton);
	PageFunctionUtils.clickOnElement(driver, viewFirstMessageButton);
	return this;
}


@Step("select message type: {0}")
public ABEVerifyInwardGuaranteePage selectPaymentStatusFirstMessage(String paymentStatus) throws Exception{
	  PageFunctionUtils.waitOnElement(driver, paymentStatusDropdown);
			PageFunctionUtils.clickOnElement(driver, paymentStatusDropdown);
			PageFunctionUtils.selectDropDownListByVisibleText(driver, paymentStatusDropdown, paymentStatus);
	return this;
}
	
@Step("press on accept first message button")
public ABEVerifyInwardGuaranteePage pressAcceptFirstMessageButton() throws Exception {	
	PageFunctionUtils.waitOnElement(driver, acceptFirstMessageButton);
	PageFunctionUtils.clickOnElement(driver, acceptFirstMessageButton);
	return this;
}	
	
@Step("press on close first message button")
public ABEVerifyInwardGuaranteePage pressCloseFirstMessageButton() throws Exception {	
	PageFunctionUtils.waitOnElement(driver, closeFirstMessageButton);
	PageFunctionUtils.clickOnElement(driver, closeFirstMessageButton);
	return this;
}



@Step("press on view second message button")
public ABEVerifyInwardGuaranteePage pressViewSecondMessageButton() throws Exception {	
	PageFunctionUtils.waitOnElement(driver, viewSecondMessageButton);
	PageFunctionUtils.clickOnElement(driver, viewSecondMessageButton);
	return this;
}


@Step("select message type: {0}")
public ABEVerifyInwardGuaranteePage selectPaymentStatusSecondMessage(String paymentStatus) throws Exception{
	  PageFunctionUtils.waitOnElement(driver, paymentStatusDropdown);
			PageFunctionUtils.clickOnElement(driver, paymentStatusDropdown);
			PageFunctionUtils.selectDropDownListByVisibleText(driver, paymentStatusDropdown, paymentStatus);
	return this;
}
	
@Step("press on accept second message button")
public ABEVerifyInwardGuaranteePage pressAcceptSecondMessageButton() throws Exception {	
	PageFunctionUtils.waitOnElement(driver, acceptSecondMessageButton);
	PageFunctionUtils.clickOnElement(driver, acceptSecondMessageButton);
	return this;
}	
	
@Step("press on close second message button")
public ABEVerifyInwardGuaranteePage pressCloseSecondMessageButton() throws Exception {	
	PageFunctionUtils.waitOnElement(driver, closeSecondMessageButton);
	PageFunctionUtils.clickOnElement(driver, closeSecondMessageButton);
	return this;
}

	
	

	@Step("press on message continue button")
	public ABEVerifyInwardGuaranteePage pressMessageContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, messageContinueButton);
		PageFunctionUtils.clickOnElement(driver, messageContinueButton);
		return this;
}
	

	
	@Step("press on submit continue button")
	public ABEVerifyInwardGuaranteePage pressSubmitButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, submitButton);
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.acceptWarning(driver);
		PageFunctionUtils.closeWarning(driver);
		return this;
}		
	
	

	
	
}
