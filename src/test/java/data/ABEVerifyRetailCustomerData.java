package data;

public class ABEVerifyRetailCustomerData {
	private String tcid;
	private String summary;
	private String username;
	private String password;
	private String menu;
	private String CIF;
	private String expectedResult;
	public String getTcid() {
		return tcid;
	}
	public void setTcid(String tcid) {
		this.tcid = tcid;
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
	public String getCIF() {
		return CIF;
	}
	public void setCIF(String cIF) {
		CIF = cIF;
	}
	public String getExpectedResult() {
		return expectedResult;
	}
	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}
	@Override
	public String toString() {
		return "ABEVerifyRetailCustomerData [tcid=" + tcid + ", summary=" + summary + ", username=" + username
				+ ", password=" + password + ", menu=" + menu + ", CIF=" + CIF + ", expectedResult=" + expectedResult
				+ "]";
	}

	
	
}