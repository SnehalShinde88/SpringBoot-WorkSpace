package com.api.redis.model;

import java.io.Serializable;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Users implements Serializable{
	
	private String userId;
	private String name;
	private String phone;
	private String email;
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
