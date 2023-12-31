package pageobjects;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.AssertionFactory;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import utils.Paths;


public class ABETellerOperationTransferLiabilitiesAndOperationPage {
	
	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private String loginFrameById= "loginFrame";
	private String coreAbeFrameById= "Core_ABE";
	private String uxFrameById= "UX";
	private String type = "Customer Induced";
	public static String  referenceCsvColumnName = "reference";
	private By transactionIdMessage = By.xpath("(//div[@id='_tranIDRes_text'])[1]");
	private By transactionTypeDropDown = By.xpath("//*[@id=\"_trantype_subtype_select\"]");
	private By GoButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By addButton = By.xpath("(//span[@id='_tranSummary_AddRecBtn_label'])[1]");
	private By AccountIdTextField = By.xpath("(//input[@id='_df_acctId'])[1]");
	private By debitRadioButton = By.xpath("(//input[@id='_parttranpmr_rbDebit_radio'])[1]");
	private By creditRadioButton = By.xpath("(//input[@id='_parttranpmr_rbCredit_radio'])[1]");
	private By transactionAmmountTextField = By.xpath("(//input[@id='_df_txnAmt$amt'])[1]");
	private By transactionCcyTextField = By.xpath("(//input[@id='_txnCurrency'])[1]");
	private By saveAndAddNewButton = By.xpath("(//button[@id='_parttranpmr_addCreateNew'])[1]");
	private By saveAndPreviewButton = By.xpath("(//button[@id='_parttranpmr_addViewSummary'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By AcceptButton = By.xpath("(//button[normalize-space()='Accept'])[1]");
	public static String transactionId;
	public static String TcidCsvColumnName = "tcId";
	private By inputField = By.id("_parttranpmr_rateCodeRate$rateCode");

	
	
	
	public ABETellerOperationTransferLiabilitiesAndOperationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABETellerOperationTransferLiabilitiesAndOperationPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABETellerOperationTransferLiabilitiesAndOperationPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxFrameById);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending Transaction Type: {0}")
	public ABETellerOperationTransferLiabilitiesAndOperationPage sendTransactionType() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,transactionTypeDropDown);
		Select transactionTypeDropDownSelector = new Select(driver.findElement(transactionTypeDropDown));
		transactionTypeDropDownSelector.selectByVisibleText(type);

		return this;
	}
	
	@Step("pressing go button")
	public ABETellerOperationTransferLiabilitiesAndOperationPage pressGoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver,GoButton);

		return this;
	}
	
	@Step("pressing add button")
	public ABETellerOperationTransferLiabilitiesAndOperationPage pressAddButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver,addButton);

		return this;
	}
	

	@Step("click in debit radio button")
	public ABETellerOperationTransferLiabilitiesAndOperationPage ClickOnDebitRadioButton() throws Exception {
		PageFunctionUtils.waitOnElement(driver, AccountIdTextField);
		PageFunctionUtils.clickOnElement(driver,debitRadioButton);
		
		return this;
	}
	
	@Step("Sending account Id: {0}")
	public ABETellerOperationTransferLiabilitiesAndOperationPage SendKeysAccountId(String accountIdDr ) throws Exception {
		PageFunctionUtils.clickOnElement(driver,AccountIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver, AccountIdTextField, accountIdDr.substring(1));
		
		return this;
	}
	
	@Step("Sending transaction ammount: {0}")
	public ABETellerOperationTransferLiabilitiesAndOperationPage SendKeysTransactionAmmount(String transactionAmount ) throws Exception {
	
		PageFunctionUtils.clickOnElement(driver,transactionAmmountTextField);
		driver.findElement(transactionAmmountTextField).clear();
		PageFunctionUtils.enterDataInWebElement(driver, transactionAmmountTextField, transactionAmount);		
		return this;
	}
	
	@Step("Sending transaction ammount: {0}")
	public ABETellerOperationTransferLiabilitiesAndOperationPage SendKeysCcyDr(String ccyDr) throws Exception {
	
		PageFunctionUtils.clickOnElement(driver,transactionCcyTextField);
		PageFunctionUtils.enterDataInWebElement(driver, transactionCcyTextField, ccyDr);
		return this;
	}
	
	@Step("Click on save and add new button")
	public ABETellerOperationTransferLiabilitiesAndOperationPage PressOnSaveAndAddNewButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver,saveAndAddNewButton);

		return this;
	}
	

	@Step("Sending Creditor Details: {0}")
	public ABETellerOperationTransferLiabilitiesAndOperationPage PressCrRadioButton() throws Exception {
	
		PageFunctionUtils.waitOnElement(driver, AccountIdTextField);
		PageFunctionUtils.clickOnElement(driver,creditRadioButton);
	
		return this;
	}
	
	@Step("Sending Creditor Details: {0}")
	public ABETellerOperationTransferLiabilitiesAndOperationPage sendKeysCrAccountId(String accountIdCr) throws Exception {
		PageFunctionUtils.clickOnElement(driver,AccountIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver, AccountIdTextField, accountIdCr.substring(1));
		return this;
	}
	
	
	@Step("Sending Creditor Details: {0}")
	public ABETellerOperationTransferLiabilitiesAndOperationPage sendKeystransactionAmmount(String transactionAmount ) throws Exception {
		PageFunctionUtils.clickOnElement(driver,transactionAmmountTextField);
		driver.findElement(transactionAmmountTextField).clear();
		PageFunctionUtils.enterDataInWebElement(driver, transactionAmmountTextField, transactionAmount);
		return this;
	}
	
	@Step("Sending Creditor Details: {0}")
	public ABETellerOperationTransferLiabilitiesAndOperationPage sendKeystransactionCcy(String ccyCr) throws Exception {
		PageFunctionUtils.clickOnElement(driver,transactionCcyTextField);
		PageFunctionUtils.enterDataInWebElement(driver, transactionCcyTextField, ccyCr);
		return this;
	}
	
	@Step("press save And Preview Button: {0}")
	public ABETellerOperationTransferLiabilitiesAndOperationPage PressSaveAndPreviewButton() throws Exception {
		PageFunctionUtils.waitOnElement(driver, saveAndPreviewButton);
		PageFunctionUtils.clickOnElement(driver,saveAndPreviewButton);

		return this;
	}
		
	@Step("finding rate code color")
	public String FindRateCodeColor() throws Exception {
		  String borderColor = ((WebElement) inputField).getCssValue("border-color");
	      System.out.println(borderColor);
		return borderColor;
	}
	
	@Step("Scrolling and switching to form area iframe")
	public ABETellerOperationTransferLiabilitiesAndOperationPage ScrollAndSwitchToFormArea() throws Exception {
		driver.switchTo().parentFrame();
    	PageFunctionUtils.scrollUp(driver);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		AssertionFactory.assertionFailWithMessage(((WebElement) inputField).getTagName());
		driver.quit();
		return this;
	}
	
	@Step("getting rate code result")
	public ABETellerOperationTransferLiabilitiesAndOperationPage RateCodeResult() throws Exception {
		driver.switchTo().parentFrame();
    	PageFunctionUtils.scrollUp(driver);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		AssertionFactory.assertionFailWithMessage(((WebElement) inputField).getTagName());
		driver.quit();
		return this;
	}
	
	
	@Step("Press Submit Button: {0}")
	public ABETellerOperationTransferLiabilitiesAndOperationPage saveTransactionId(String linkedId) throws Exception {
	
		try {
		PageFunctionUtils.clickOnElement(driver,submitButton);
		PageFunctionUtils.acceptWarning(driver);
		transactionId = driver.findElement(transactionIdMessage).getText();
		System.out.println("transaction id: "+ transactionId);
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABETELLEROPERATIONTRANSFERLIABILITIESANDOPERATIONCSV, TcidCsvColumnName, linkedId);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ABETELLEROPERATIONTRANSFERLIABILITIESANDOPERATIONCSV, referenceCsvColumnName);
		CSVUtils.insertValueInCsvCell(Paths.ABETELLEROPERATIONTRANSFERLIABILITIESANDOPERATIONCSV, rowByTcid1, columnByColumnName1, transactionId);

		}catch (Exception e) {
			// TODO: handle exception
			driver.switchTo().parentFrame();
			 WebElement errorMessage = driver.findElement(By.id("errorHeadingH2"));
	     	//AssertionFactory.assertionFailWithMessage(errorMessage.getText());

		        if (errorMessage.isDisplayed()) {
		        	AssertionFactory.assertionFailWithMessage(errorMessage.getText());
		        } else {
		            PageFunctionUtils.clickOnElement(driver,AcceptButton);
					PageFunctionUtils.scrollUp(driver);
					PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
					transactionId = driver.findElement(transactionIdMessage).getText();
					System.out.println("transaction id: "+ transactionId);
					int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABETELLEROPERATIONTRANSFERLIABILITIESANDOPERATIONCSV, TcidCsvColumnName, linkedId);
					int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ABETELLEROPERATIONTRANSFERLIABILITIESANDOPERATIONCSV, referenceCsvColumnName);
					CSVUtils.insertValueInCsvCell(Paths.ABETELLEROPERATIONTRANSFERLIABILITIESANDOPERATIONCSV, rowByTcid1, columnByColumnName1, transactionId);

		        }
		}
		
	

			return this;

			}
			}
