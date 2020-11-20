package it.client.rest.fabricktest.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MoneyTransferRequest {
	
	private Creditor creditor;
	private String description;
	private String amount;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate  executionDate;
	private String currency;
	
	public MoneyTransferRequest() {
	
	}
	
	public MoneyTransferRequest(Creditor creditor, String description, String amount, LocalDate executionDate,
			String currency) {
		super();
		this.creditor = creditor;
		this.description = description;
		this.amount = amount;
		this.executionDate = executionDate;
		this.currency = currency;
	}

	public Creditor getCreditor() {
		return creditor;
	}
	public void setCreditor(Creditor creditor) {
		this.creditor = creditor;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public LocalDate getExecutionDate() {
		return executionDate;
	}
	public void setExecutionDate(LocalDate executionDate) {
		this.executionDate = executionDate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	@Override
	public String toString() {
		return "MoneyTransferRequest [creditor=" + creditor + ", description=" + description + ", amount=" + amount
				+ ", executionDate=" + executionDate + ", currency=" + currency + "]";
	}
	
	
	
}
