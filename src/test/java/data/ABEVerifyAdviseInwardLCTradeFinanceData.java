package data;

public class ABEVerifyAdviseInwardLCTradeFinanceData {
	private String tcId;
	private String summary;
	private String username;
	private String password;
	private String menu;
	private String documentaryCreditId;
	private String expectedResult;
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
	public String getDocumentaryCreditId() {
		return documentaryCreditId;
	}
	public void setDocumentaryCreditId(String documentaryCreditId) {
		this.documentaryCreditId = documentaryCreditId;
	}
	public String getExpectedResult() {
		return expectedResult;
	}
	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}
	@Override
	public String toString() {
		return "ABEVerifyAdviseInwardLCTradeFinanceData [tcId=" + tcId + ", summary=" + summary + ", username="
				+ username + ", password=" + password + ", menu=" + menu + ", documentaryCreditId="
				+ documentaryCreditId + ", expectedResult=" + expectedResult + "]";
	}
	

}