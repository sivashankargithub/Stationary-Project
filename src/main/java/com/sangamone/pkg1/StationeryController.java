package com.sangamone.pkg1;

import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
@RestController

public class StationeryController {
	
	@Autowired
	StationeryRepo sr;
	
	@PostMapping("/sale/add")
	public String addSales(@RequestBody StationeryEntity se) {
		sr.save(se);
		return "Success";
	}
	
	@GetMapping("/sale/get")
	public List<StationeryEntity> getSales() {
		return sr.findAll();
	}
	
	@GetMapping("/sale/report1")
	public int genReport1() {
		String location=getLocationById(1);
		int total1=sr.getSalesAmt1(location);
		return total1;
	}
	
	@GetMapping("/sale/report2")
	public int genReport2() {
		String location=getLocationById(2);
		int total2=sr.getSalesAmt1(location);
		return total2;
	}
	@GetMapping("/sale/report3")
	public ArrayList<String> genReport3() {
		ArrayList<String> list1=new ArrayList<>();
		String s1="Total Sales in ";
		int total3=genReport1()+genReport2();
		list1.add(s1+getLocationById(1)+" : "+String.valueOf(genReport1()));
		list1.add(s1+getLocationById(2)+" : "+String.valueOf(genReport2()));
		list1.add(s1+getLocationById(1)+" and "+getLocationById(2)+" : "+String.valueOf(total3));
		return list1;
	}
	@GetMapping("/location/distinct")
	public ArrayList<String> getLocations(){
		return sr.getDistinctLocations();
	}
	@GetMapping("/location/{id}")
	public String getLocationById(@PathVariable int id) {
		return getLocations().get(id-1);
		
	}
	

}
