package it.client.rest.fabricktest.model;

/**
 * 
 * @author Claudiu Iancu
 *  
 */
public class Creditor {
	
	private String name;
	private Account account;
	
	public Creditor() {
	
	}
	public Creditor(String name, Account account) {
		super();
		this.name = name;
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	@Override
	public String toString() {
		return "Creditor [name=" + name + ", account=" + account + "]";
	}
	
	
}
