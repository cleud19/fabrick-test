package it.client.rest.fabricktest.model;

/**
 * 
 * @author Claudiu Iancu
 *  
 */
public class MoneyTransferResponse {
	private String moneyTransferId;
	private Status status;
	private String direction;
	private Creditor creditor;
	
	public String getMoneyTransferId() {
		return moneyTransferId;
	}
	public void setMoneyTransferId(String moneyTransferId) {
		this.moneyTransferId = moneyTransferId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Creditor getCreditor() {
		return creditor;
	}
	public void setCreditor(Creditor creditor) {
		this.creditor = creditor;
	}
	
	@Override
	public String toString() {
		return "MoneyTransferResponse [moneyTransferId=" + moneyTransferId + ", status=" + status + ", direction="
				+ direction + ", creditor=" + creditor + "]";
	}
	
	
}
