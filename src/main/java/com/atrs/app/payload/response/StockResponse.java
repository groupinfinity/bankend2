package com.atrs.app.payload.response;

import com.atrs.app.models.Stock;

public class StockResponse {
	long userId;
	int rank;
	String company;
	float bse;
	float nse;
	float profit;
	String buy;
	
	public StockResponse(long userId, int rank, String company, float bse, float nse, float profit, String buy) {
		super();
		this.userId = userId;
		this.rank = rank;
		this.company = company;
		this.bse = bse;
		this.nse = nse;
		this.profit = profit;
		this.buy = buy;
	}
	
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
		return company;
	}
	public void setCompanyName(String companyName) {
		this.company = companyName;
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
