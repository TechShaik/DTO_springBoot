package com.example.demo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
 

@Data 
public class UserRequestDto {
	@NotEmpty
	@Pattern(regexp="[A-Z]{1}[a-z]{2,50}",message = "Pattern mismatched")
	private String name;
     
 	@NotNull
	private long mobile;
	
	@NotEmpty
	@Pattern(regexp="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).*$",message = "Pattern mismatched")
	private String password;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
      
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	


}
