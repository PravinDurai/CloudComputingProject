package com.pravin.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RoleEntity {
	@Id
	private Long id;
	private String role;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
