package com.atrs.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.Column;

@Entity
@Table(name = "saved_stocks")
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="stock_id")
	long id;
	@Column(name="stock_rank")
	int rank;
	@Column(name="company_name")
	String companyName;
	@Column(name="nse")
	float nsePrice;
	@Column(name="bse")
	float bsePrice;
	@Column(name="percent_profit")
	float percentProfit;
	@Column(name="buy_from")
	String buyFrom;
//	@Column(name="user_id")
//	long userId;
//	
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

	
	public Stock() {
		this.rank = 0;
		this.companyName = "";
		this.nsePrice = 0.0f;
		this.bsePrice = 0.0f;
		this.percentProfit = 0.0f;
		this.buyFrom = "";
	}
	public Stock(int rank, String companyName, float nsePrice, float bsePrice, float percentProfit,
			 String buyFrom) {
	
		this.rank = rank;
		this.companyName = companyName;
		this.nsePrice = nsePrice;
		this.bsePrice = bsePrice;
		this.percentProfit = percentProfit;
		this.buyFrom = buyFrom;
		//this.userId=userId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public float getNsePrice() {
		return nsePrice;
	}
	public void setNsePrice(float nsePrice) {
		this.nsePrice = nsePrice;
	}
	public float getBsePrice() {
		return bsePrice;
	}
	public void setBsePrice(float bsePrice) {
		this.bsePrice = bsePrice;
	}
	public float getPercentProfit() {
		return percentProfit;
	}
	public void setPercentProfit(float percentProfit) {
		this.percentProfit = percentProfit;
	}
	public String getBuyFrom() {
		return buyFrom;
	}
	public void setBuyFrom(String buyFrom) {
		this.buyFrom = buyFrom;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	/*
	 * public long getUserId() { return userId; }
	 * 
	 * public void setUserId(long userId) { this.userId = userId; }
	 */
	
}
