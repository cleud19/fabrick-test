package it.client.rest.fabricktest.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Transaction {
	
	private String transactionId;
	private String operationId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate accountingDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate valueDate;
	private EnumType type;
	private String amount;
	private String currency;
	private String description;
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getOperationId() {
		return operationId;
	}
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}
	public LocalDate getAccountingDate() {
		return accountingDate;
	}
	public void setAccountingDate(LocalDate accountingDate) {
		this.accountingDate = accountingDate;
	}
	public LocalDate getValueDate() {
		return valueDate;
	}
	public void setValueDate(LocalDate valueDate) {
		this.valueDate = valueDate;
	}
	public EnumType getType() {
		return type;
	}
	public void setType(EnumType type) {
		this.type = type;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", operationId=" + operationId + ", accountingDate="
				+ accountingDate + ", valueDate=" + valueDate + ", type=" + type + ", amount=" + amount + ", currency="
				+ currency + ", description=" + description + "]";
	}
	
	
}
