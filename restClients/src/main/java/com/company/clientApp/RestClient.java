package com.company.clientApp;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClient {

	String endPointUrl = "http://localhost:8081/currency/USD/to/INR";
	String endPointForPostReq = "http://localhost:8081/save";

	RestTemplate rt = new RestTemplate();

	public Student getCurrencyCost(String from,String to) {

		ResponseEntity<Student> responseEntity = rt.getForEntity(endPointUrl, Student.class,from,to);
		if (responseEntity!=null && responseEntity.getStatusCode().value()==200) {
			return responseEntity.getBody();
		}
		return null;
	}

	/**
	 * Rest Template For Post Request 
	 */
	@PostMapping("/studentSave")
	public ResponseEntity<Student> postStudent(@RequestBody Student std) {

		HttpHeaders header = new HttpHeaders();
		header.add("Accept", "application/json");
		header.add("ContentType", "application/json");

		
		HttpEntity<Student> reqEntity = new HttpEntity<>(new Student(std.getRollno(),std.getName().toUpperCase(),std.getStd().toUpperCase()),header);
		ResponseEntity<Student> postForEntity = rt.postForEntity(endPointForPostReq, reqEntity, Student.class);
		return (ResponseEntity<Student>) postForEntity;
	}
	
	
}
