package data;

public class ABECreateDepositLiabilitiesAndOperationData {
	
	private String tcId;
	private String summary;
	private String username;
	private String password;
	private String menu;
	private String cifType;
	private String cif;
	private String DepositType;
	private String schemeCode;
	private String ccy;
	private String initialDepositAmmount;
	private String debitAcId;
	private String linkedTcid;
	private String expectedResult;
	private String dailyPeriod;
	private String monthlyPeriod;

	
	
	public String getTcId() {
		return tcId;
	}
	public void setTcId(String tcId) {
		this.tcId = tcId;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCifType() {
		return cifType;
	}
	public void setCifType(String cifType) {
		this.cifType = cifType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getDepositType() {
		return DepositType;
	}
	public void setDepositType(String depositType) {
		DepositType = depositType;
	}
	public String getSchemeCode() {
		return schemeCode;
	}
	public void setSchemeCode(String schemeCode) {
		this.schemeCode = schemeCode;
	}
	public String getCcy() {
		return ccy;
	}
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	public String getInitialDepositAmmount() {
		return initialDepositAmmount;
	}
	public void setInitialDepositAmmount(String initialDepositAmmount) {
		this.initialDepositAmmount = initialDepositAmmount;
	}
	public String getDebitAcId() {
		return debitAcId;
	}
	public void setDebitAcId(String debitAcId) {
		this.debitAcId = debitAcId;
	}
	public String getLinkedTcid() {
		return linkedTcid;
	}
	public void setLinkedTcid(String linkedTcid) {
		this.linkedTcid = linkedTcid;
	}
	public String getExpectedResult() {
		return expectedResult;
	}
	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}
	public String getDailyPeriod() {
		return dailyPeriod;
	}
	public void setDailyPeriod(String dailyPeriod) {
		this.dailyPeriod = dailyPeriod;
	}
	public String getMonthlyPeriod() {
		return monthlyPeriod;
	}
	public void setMonthlyPeriod(String monthlyPeriod) {
		this.monthlyPeriod = monthlyPeriod;
	}
	@Override
	public String toString() {
		return "ABECreateDepositLiabilitiesAndOperationData [tcId=" + tcId + ", summary=" + summary + ", username="
				+ username + ", password=" + password + ", menu=" + menu + ", cifType=" + cifType + ", cif=" + cif
				+ ", DepositType=" + DepositType + ", schemeCode=" + schemeCode + ", ccy=" + ccy
				+ ", initialDepositAmmount=" + initialDepositAmmount + ", debitAcId=" + debitAcId + ", linkedTcid="
				+ linkedTcid + ", expectedResult=" + expectedResult + ", dailyPeriod=" + dailyPeriod
				+ ", monthlyPeriod=" + monthlyPeriod + "]";
	}
	
	

	
	
}
