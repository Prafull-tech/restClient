package com.company.clientApp;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
@XmlRootElement
public class Student {
	@JsonProperty("roll-no")
	private int rollno;
	@JsonProperty("student-name")
	private String name;
	@JsonProperty("student-std")
	private String std;
}
