package com.lib.main.dto;


public class UserRegistrationDto {
	private String name;
	private String email;
	private String phone_number;
	private String password;
	
	
	public UserRegistrationDto(){};
	
	public UserRegistrationDto(String name, String email, String phone_number, String password) {
		super();
		this.name = name;
		this.email = email;
		this.phone_number = phone_number;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
