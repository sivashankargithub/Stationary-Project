package com.sangamone.pkg1;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface StationeryRepo extends JpaRepository<StationeryEntity, Integer>{
	
	@Query(value="select distinct location from sales",nativeQuery=true)
	public ArrayList<String> getDistinctLocations();
	
	@Query(value="select sum(salesamt)from sales where location =:location",nativeQuery = true)
	public int getSalesAmt1(@Param("location") String location);
	
	
	
	@Query(value="select sum(salesamt) from sales where location like 'Mallasandra'",nativeQuery=true)
	public int getSalesAmt2();
}
