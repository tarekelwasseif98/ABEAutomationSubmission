package procedures;
import org.openqa.selenium.WebDriver;
import data.ABECreateDepositLiabilitiesAndOperationData;
import pageobjects.ABECreateDepositLiabilitiesAndOperationPage;

public class ABECreateDepositLiabilitiesAndOperationProcedures {

	public static void CreateDepositByMaker(WebDriver driver, ABECreateDepositLiabilitiesAndOperationData data) throws Exception {
		ABECreateDepositLiabilitiesAndOperationPage OpenDepositPage = new ABECreateDepositLiabilitiesAndOperationPage(driver);
		OpenDepositPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
									  .SelectFunctionCodeDropDown()
									  .sendKeysCif(data.getCif())
									  .sendKeysSchemeCode(data.getSchemeCode())
									  .sendKeysCcy(data.getCcy())
									  .PressGoButton()
									  .sendKeysInitialDepositAmmount(data.getInitialDepositAmmount())
									  .sendKeysDebitAcId(data.getDebitAcId())
									  .selectRenewalType();
									String  f1= OpenDepositPage.getMonthPeriodValue();
									String f2= OpenDepositPage.getDayPeriodValue();

									
		if(f1.equals("MMM")  && f2.equals("DDD") ||f1.equals("0")  && f2.equals("0") || f1.equals(null)  && f2.equals(null)) {
									  
			OpenDepositPage.sendKeysTdPeriod(data.getMonthlyPeriod(), data.getDailyPeriod())
									  .pressSubmitButton();
		}else
		{
			OpenDepositPage.pressSubmitButton();
		}
		
		OpenDepositPage.saveDepositId(data.getDepositType(), data.getLinkedTcid() );

		}
}
