package com.course5i.base.framework.entity;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class UserDetailsEntity {

	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    Integer id;
	 private String username;
	 private String password;
		private String email;
		private String city;
		private String zipcode;
		private String firstName;
		private String lastName;

	    public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}


	    public String getZipcode() {
			return zipcode;
		}
		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
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


	    @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	    private Collection<UserRolesEntity> roles;
	    public UserDetailsEntity() {
	    }
	    public UserDetailsEntity(String username, String password, Collection<UserRolesEntity> roles) {
	        this.username = username;
	        this.password = password;
	        this.roles = roles;
	    }
	    public String getUsername() {
	        return username;
	    }
	    public void setUsername(String username) {
	        this.username = username;
	    }
	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    public Collection<UserRolesEntity> getRoles() {
	        return roles;
	    }
	    public void setRoles(Collection<UserRolesEntity> roles) {
	        this.roles = roles;
	    }
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
}
