package org.akjamie.test.entity;

import javax.persistence.Column;

public class CurrencyAmount {
	
	//@DecimalMax(value="2")
	@Column(nullable=true,scale=2,precision=9)
	private double amount;
	
	//@Length(min=0,max=6)
	@Column(length=3)
	private String currency;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	} 

}
