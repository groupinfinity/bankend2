package com.atrs.app.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.atrs.app.payload.request.DeleteStockRequest;
import com.atrs.app.payload.request.RetrieveRequest;
import com.atrs.app.payload.request.StockRequest;
import com.atrs.app.payload.response.StockResponse;
import com.atrs.app.services.*;
import com.atrs.app.payload.response.MessageResponse;
import com.atrs.app.models.ArbitrageStock;
import com.atrs.app.models.Stock;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class StockController {
	@Autowired
	private StockServiceImpl stockService;

	@Autowired
	private FinanceAPIService financeAPIService; 

	//A function to save the stock recommendation
	@PostMapping("/savestock")
	public ResponseEntity saveStock(@Valid @RequestBody StockRequest request) {

		Stock stk=new Stock(request.getRank(), request.getCompanyName(),
				request.getNse(), request.getBse(), request.getPercentDiff(),
				request.getBuy());
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		String username = userDetails.getUsername();
		
		stockService.saveStocks(stk, username);
		return ResponseEntity.ok(new MessageResponse("Stock added"));
	}

	//retrieve all the saved entries of the user
	@PostMapping("/retrievestocks")
	public ResponseEntity<List<StockResponse>> getsavedStock() {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		String username = userDetails.getUsername();

		List<StockResponse> stockList = stockService.retrieveStocks(username);

		return ResponseEntity.ok(stockList);
	}


	//sends a list of companies name in saved table 
	@PostMapping("/watchlist")
	public ResponseEntity<Set<String>> getWatchList() {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		String username = userDetails.getUsername();

		Set<String> stockList = stockService.getWatchList(username);

		return ResponseEntity.ok(stockList);
	}

	//sends a list of companies name in saved table 
	@PostMapping("/retrieve_stocks_by_company")
	public ResponseEntity<List<StockResponse>> getSavedStockByCompanyName(@Valid @RequestBody RetrieveRequest request) {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		String username = userDetails.getUsername();

		List<StockResponse> stockList = stockService.retrieveStocksByName(username, request.getCompanyName());

		return ResponseEntity.ok(stockList);
	}

	//A function to delete the stock 
	@PostMapping("/deletestock")
	public ResponseEntity deleteStock(@Valid @RequestBody DeleteStockRequest request) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		String username = userDetails.getUsername();

		String message = stockService.deleteStock(username, request.getCompanyName(), request.getSaveAt());
		
		return ResponseEntity.ok(new MessageResponse(message));
	}


	//returns a json array of nifty 50 stocks
	@PostMapping("/stocktable")
	public ResponseEntity<ArbitrageStock[]> getStockTable() {
		System.out.println();
		return ResponseEntity.ok(financeAPIService.sendGET());
	}



}