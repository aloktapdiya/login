package com.course5i.base.framework.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserRolesEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
    public UserRolesEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public UserRolesEntity(String name) {
        super();
        this.name = name;
    }
    public UserRolesEntity() { 
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
