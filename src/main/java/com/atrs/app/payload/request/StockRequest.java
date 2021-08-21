package com.atrs.app.payload.request;

import javax.validation.constraints.NotBlank;

public class StockRequest {
	
	long userId;
	int rank;
	String companyName;
	float bse;
	float nse;
	float profit;
	String buy;
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getBuy() {
		return buy;
	}
	public void setBuy(String buy) {
		this.buy = buy;
	}
	
	public float getBse() {
		return bse;
	}
	public void setBse(float bse) {
		this.bse = bse;
	}
	public float getNse() {
		return nse;
	}
	public void setNse(float nse) {
		this.nse = nse;
	}
	public float getProfit() {
		return profit;
	}
	public void setProfit(float profit) {
		this.profit = profit;
	}
	
	

}
