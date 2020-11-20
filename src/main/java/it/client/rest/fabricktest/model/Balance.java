package it.client.rest.fabricktest.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author Claudiu Iancu
 *  
 */
public class Balance {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date;
	private String balance;
	private String availableBalance;
		
	public Balance() {
		
	}
	
	public Balance(LocalDate date, String balance, String availableBalance) {
		super();
		this.date = date;
		this.balance = balance;
		this.availableBalance = availableBalance;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(String availableBalance) {
		this.availableBalance = availableBalance;
	}

	@Override
	public String toString() {
		return "Balance [date=" + date + ", balance=" + balance + ", availableBalance=" + availableBalance + "]";
	}
	
	
	
}
