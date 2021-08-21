package com.atrs.app.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.atrs.app.models.Stock;
import com.atrs.app.models.User;
import com.atrs.app.payload.response.StockResponse;
import com.atrs.app.repository.StockRepository;
import com.atrs.app.repository.UserRepository;

@Service
public class StockServiceImpl {
	@Autowired
	UserRepository userRepository;
	@Autowired
	StockRepository stockRepository;
	
	public void saveStocks(Stock stock,String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		//user.addStock(stock);
		System.out.println(user.getId());
		stock.setUser(user);
		stockRepository.save(stock);
	}
	
	//returns list of stocks along with the time-stamps in a user's watchlist
	public List<StockResponse> retrieveStocks(String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		Set<Stock> stocks = user.getSavedStocks();
		List<StockResponse>  stockList= new ArrayList<>();
		
		for (Stock s : stocks) {
			StockResponse stockResponse=new StockResponse(s.getId(),s.getRank(),
					s.getCompanyName(),s.getBsePrice(),s.getNsePrice(),s.getPercentProfit(),s.getBuyFrom());
			stockList.add(stockResponse);
		}
		return stockList;
			
            
  
	}

	//a function to return name of companies in user's watchlist
	public Set<String> getWatchList(String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		Set<Stock> stocks = user.getSavedStocks();
		List<String>  stockList= new ArrayList<>();
		
		for (Stock s : stocks) {
			stockList.add(s.getCompanyName());
		}
		Set<String> stockSet = new HashSet<>(stockList);  
		return stockSet;
	}

	
	void getStocksData() {
		
	}
	
}
