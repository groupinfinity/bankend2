package com.atrs.app.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.atrs.app.payload.request.LoginRequest;
import com.atrs.app.payload.request.StockRequest;
import com.atrs.app.repository.StockRepository;
import com.atrs.app.models.Stock;
import com.atrs.app.models.User;

@RestController
public class StockController {
	@Autowired
	private StockRepository stockRepository;

	@RequestMapping({ "/hello" })
	public String firstPage() {

		return "hello";
	}

	@PostMapping("/savestock")
	public String saveStock(@Valid @RequestBody StockRequest request) {


		Stock stk=new Stock(request.getRank(), request.getCompanyName(),
				request.getNse(), request.getBse(), request.getProfit(),
				request.getBuy());

//		User user=stk.getUser();
//		user.addStock(stk);
		stockRepository.save(stk);

		return "added";
	}

	@PostMapping("/deletestock")
	public String deleteStock() {
		/*
		 * Stock stk=new Stock(request.getCompanyCode(), request.getCompanyName(),
		 * request.getNse(), request.getBse(), request.getProfit(),request.getBuy());
		 * 
		 * 
		 * stockRepository.delete(stk);
		 */

		//stockRepository.deleteById(id);
		//stockRepository.deleteById(3L);
		return "deleted";
	}

	@GetMapping("/update")
	public String update() {
		Process process;
		String s="";
		try {
			process = Runtime.getRuntime().exec("python http://localhost:8888/notebooks/YAHOO%20API/Untitled.ipynb hello");

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			s= reader.readLine();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s+" world";
	}

}