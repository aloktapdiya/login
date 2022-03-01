package com.course5i.base.framework.model;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.course5i.base.framework.entity.UserDetailsEntity;
import com.course5i.base.framework.entity.UserRolesEntity;

public class MyUserDetails implements UserDetails {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String email;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	
	public MyUserDetails(String username) {
		this.username = username;
	}
	
	public MyUserDetails() {
	}

	public MyUserDetails(UserDetailsEntity userDetailsEntity) {
		this.username = userDetailsEntity.getUsername();
		this.password = userDetailsEntity.getPassword();
		this.email = userDetailsEntity.getEmail();
//		this.authorities = Arrays.stream(userDetailsEntity.getRoles().split(","))
//				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		
		for(UserRolesEntity userRolesEntity : userDetailsEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(userRolesEntity.getName()));
		}
	}

	public MyUserDetails(String username, String email, String passwowrd) {
        this.username = username;
        this.password = password;
		this.email = email;

	}
	/*
	 * public MyUserDetailsRegistration(UserDetailsEntity userDetailsEntity) {
	 * this.username = userDetailsEntity.getUsername(); this.password =
	 * userDetailsEntity.getPassword(); // this.authorities =
	 * Arrays.stream(userDetailsEntity.getRoles().split(",")) //
	 * .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	 * 
	 * for(UserRolesEntity userRolesEntity : userDetailsEntity.getRoles()) {
	 * authorities.add(new SimpleGrantedAuthority(userRolesEntity.getName())); } }
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}