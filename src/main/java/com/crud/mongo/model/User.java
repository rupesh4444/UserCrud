package com.crud.mongo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {
	
	@Transient
	public static final String SEQUENCE_NAME = "user_id_sequence";
	
	@Id
	private Long id;	
	
	@NotNull(message="Firstname cannot be null")
	@NotEmpty(message="Firstname cannot be empty")
	@NotBlank(message="Firstname cannot be blank")
	private String firstName;
	
	private String lastName;
	private String contactNo;
	private String address;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNo=" + contactNo
				+ ", address=" + address + "]";
	}
	
	

}
