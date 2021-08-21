package com.atrs.app.models;

public class ArbitrageStock {
	
	int rank;
	String companyname;
	Float nse;
	Float bse;
	Float priceDiff;
	String buy;
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public Float getNse() {
		return nse;
	}
	public void setNse(Float nse) {
		this.nse = nse;
	}
	public Float getBse() {
		return bse;
	}
	public void setBse(Float bse) {
		this.bse = bse;
	}
	public Float getPriceDiff() {
		return priceDiff;
	}
	public void setPriceDiff(Float priceDiff) {
		this.priceDiff = priceDiff;
	}
	public String getBuy() {
		return buy;
	}
	public void setBuy(String buy) {
		this.buy = buy;
	}
		
}


//userId : 25,
//rank : "3",
//companyName : "Cipla",
//nse : 32432,
//bse : 34232,
//priceDiff:1,
//buy: "NSE"