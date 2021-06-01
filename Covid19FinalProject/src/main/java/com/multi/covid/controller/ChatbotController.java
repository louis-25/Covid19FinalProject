package com.multi.covid.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.multi.covid.service.ChatbotService;

@Controller
@RequestMapping("/chatbot")
public class ChatbotController {
	@Autowired
	private ChatbotService service;
	/*http://61.102.5.133:9091/*/
	/*http://49.142.68.213:9091*/
	
	//누적 확진자 전체 조회
	@RequestMapping(value="/resultall", method=RequestMethod.POST)
	@ResponseBody
	public String getAllResult() {
		return service.getAllResult();
	}
	
	//누적 확진자 조회 (지역별)
	@RequestMapping(value="/result", method=RequestMethod.POST)
	@ResponseBody
	public String getOneResult(@RequestBody String location) {
		System.out.println(service.getOneResult(location));
		return service.getOneResult(location);	
	}
	
	//실시간 확진자 조회 (전체)
	@RequestMapping(value="/liveall", method=RequestMethod.POST)
	@ResponseBody
	public String getAllLive() {
		return service.getAllLive();
	}
	
	//실시간 확진자 조회 (지역별)
	@RequestMapping(value="/liveone", method=RequestMethod.POST)
	@ResponseBody
	public String getLocLive(@RequestBody String location) {
		return service.getLocLive(location);
	}
	
	
	//백신 센터 조회(지역별)
	@RequestMapping(value="/vaccineloc", method=RequestMethod.POST)
	@ResponseBody
	public String getLocCenter(@RequestBody String location) {	
		return service.getLocCenter(location);
	}
	
	//백신 센터 선택지 return 
	@RequestMapping(value="/selectaddrtwo", method=RequestMethod.POST)
	@ResponseBody
	public String selectAddTwo(@RequestBody String location) {
		return service.selectAddrTwo(location);		
	}
	

	//백신 센터 선택지 return 
	@RequestMapping(value="/selectaddrthree", method=RequestMethod.POST)
	@ResponseBody
	public String selectAddThree(@RequestBody String location) {
		return service.selectAddrThree(location);		
	}
	
	//백신 센터 나머지 선택지 return 
	@RequestMapping(value="/selectremainder", method=RequestMethod.POST)
	@ResponseBody
	public String selectAddrRemainder(@RequestBody String location) {
		return service.selectAddrRemainder(location);		
	}	
				
	//백신 센터 조회(지역 - 시/군별) + 링크
	@RequestMapping(value="/vaccineaddr", method=RequestMethod.POST)
	@ResponseBody
	public String getAddrCenter(@RequestBody String location) {
		return service.getAddrCenter(location, 1);		
	}
	
	//백신 센터 조회(지역 - 시/군별) + 링크 (5 초과 10 이하)
	@RequestMapping(value="/vaccineaddr2", method=RequestMethod.POST)
	@ResponseBody
	public String getAddrCenter2(@RequestBody String location) {
		return service.getAddrCenter_2(location);	
	}
	
	//백신 센터 조회(지역 - 시/군별) + 링크 (15 이상)
	@RequestMapping(value="/vaccineaddr3", method=RequestMethod.POST)
	@ResponseBody
	public String getAddrCenter3(@RequestBody String location) {
		return service.getAddrCenter_3(location);	
	}
	
	
	@RequestMapping(value="/facility", method=RequestMethod.POST)
	@ResponseBody
	public String facilityCheck(@RequestBody String facility_name) {
		return service.facilityCheck(facility_name);	
	}
	  
}