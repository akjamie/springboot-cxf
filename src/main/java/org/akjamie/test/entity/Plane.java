package org.akjamie.test.entity;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Plane {
	
	private String type;
	
	@Column(nullable=true,scale=0,precision=3)
	@Max(300)
	@Min(0)
	private int totalSeats;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	
	
}
