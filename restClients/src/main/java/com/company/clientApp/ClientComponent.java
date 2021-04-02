package com.company.clientApp;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ClientComponent {

	public void invokeRestApi(String from,String to) {

		String endPointUrl = "http://localhost:8081/currency/{from}/to/{to}";

		WebClient webClient = WebClient.create();

		Student respoMono = webClient.get() 		// for get request
				.uri(endPointUrl,from,to)			// for 
				.retrieve()							// Retrieve Response 
				.bodyToMono(Student.class)			// Response At a time only in specific format
				.block();							// wait for Response (using lock )

		System.out.println("===============================================================");
		System.out.println(respoMono);
	}

	public void invokeRestApiAsych(String from,String to) {

		String endPointUrl = "http://localhost:8081/currency/{from}/to/{to}";

		WebClient webClient = WebClient.create();
		System.out.println("=========================START=====================================");

		webClient.get() 		// for get request
		.uri(endPointUrl,from,to)			// for 
		.retrieve()							// Retrieve Response 
		.bodyToMono(Student.class)			// Response At a time only in specific format
		.subscribe(ClientComponent::msg);// wait for Response (using lock )


		System.out.println("==========================END=====================================");
	}

	public static void msg(Student std) {
		System.out.println(std);
	}
}
