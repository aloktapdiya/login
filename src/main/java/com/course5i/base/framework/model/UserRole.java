package com.course5i.base.framework.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String rolename;

	
	public enum EnumRole {
		  ROLE_USER,
		  ROLE_MODERATOR,
		  ROLE_ADMIN
		}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return rolename;
	}

	public void setRoleName(String rolename) {
		this.rolename = rolename;
	}
}
