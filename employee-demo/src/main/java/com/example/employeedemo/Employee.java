package com.example.employeedemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	public  String firstName;
	public  String lastName;
	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;

	}

	protected Employee() {}

	public Long getId() {
		return id;
	}
	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	@Override
	public String toString() {
		return String.format(
				"Employee[firstName='%s', lastName='%s']",
				firstName, lastName);
	}


}
