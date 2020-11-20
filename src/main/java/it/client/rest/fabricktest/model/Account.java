package it.client.rest.fabricktest.model;

/**
 * 
 * @author Claudiu Iancu
 *  
 */
public class Account {
	private String accountCode;
	private String bicCode;
	
	public Account() {
	
	}
	
	public Account(String accountCode, String bicCode) {
		super();
		this.accountCode = accountCode;
		this.bicCode = bicCode;
	}

	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	public String getBicCode() {
		return bicCode;
	}
	public void setBicCode(String bicCode) {
		this.bicCode = bicCode;
	}
	
	@Override
	public String toString() {
		return "Account [accountCode=" + accountCode + ", bicCode=" + bicCode + "]";
	}

	
	
}
