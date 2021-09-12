package com.atrs.app.repository;

import java.util.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.atrs.app.models.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{
	@Query(value = "select * FROM saved_stocks WHERE company_name = :name AND user_id = :id ORDER BY saved_at", 
			  nativeQuery = true)
	Set<Stock> findStockListByCompanyNameAndUserId(@Param("name") String companyName, 
					@Param("id") Long userId);

	@Query(value = "select * FROM saved_stocks WHERE user_id = :id ORDER BY saved_at desc", 
			  nativeQuery = true)
	Set<Stock> findStockListByUserId(@Param("id") Long userId);
	
	@Query(value = "select stock_id FROM saved_stocks WHERE user_id = :id and company_name = :name and saved_at = :timestamp ORDER BY saved_at desc", 
			  nativeQuery = true)
	long[] getStockId(@Param("id") Long userId, @Param("name") String companyName, @Param("timestamp") Date timestamp);
	
//
//	@Modifying
//	@Query(value = "delete from Stock s WHERE s.id = :id and s.companyName = :name and s.saved_at = :timestamp")
//	int deleteSavedStock(@Param("id") Long userId, @Param("name") String companyName, @Param("timestamp") Date timestamp);

}
