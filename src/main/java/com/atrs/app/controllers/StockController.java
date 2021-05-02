package com.atrs.app.controllers;

import java.util.List;
import java.util.Set;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.atrs.app.payload.request.StockRequest;
import com.atrs.app.payload.response.StockResponse;
import com.atrs.app.payload.response.MessageResponse;
import com.atrs.app.models.Stock;
import com.atrs.app.security.services.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class StockController {
	@Autowired
	private StockServiceImpl stockService;


	@RequestMapping({ "/hello" })
	public String firstPage() {

		return "hello";
	}

	@PostMapping("/savestock")
	public ResponseEntity saveStock(@Valid @RequestBody StockRequest request) {
	
		Stock stk=new Stock(request.getRank(), request.getCompanyName(),
				request.getNse(), request.getBse(), request.getProfit(),
				request.getBuy());
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
		String username = userDetails.getUsername();
	
		stockService.saveStocks(stk, username);
		return ResponseEntity.ok(new MessageResponse("Stock added"));
	}
	
	@PostMapping("/retrievestocks")
	public ResponseEntity<?> getsavedStock() {
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
		String username = userDetails.getUsername();
	
		List<StockResponse> stockList = stockService.retrieveStocks(username);
		
		return ResponseEntity.ok(stockList);
	}
	
	@PostMapping("/watchlist")
	public ResponseEntity<?> getWatchList() {
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
		String username = userDetails.getUsername();
	
		Set<String> stockList = stockService.getWatchList(username);
		
		return ResponseEntity.ok(stockList);
	}
	

}