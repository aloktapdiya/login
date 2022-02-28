package com.course5i.base.framework.model;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.course5i.base.framework.entity.UserDetailsEntity;
import com.course5i.base.framework.entity.UserRolesEntity;

public class MyUserDetails implements UserDetails {
	
	private String username;
	private String password;
	
	private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	
	public MyUserDetails(String username) {
		this.username = username;
	}
	
	public MyUserDetails() {
	}

	public MyUserDetails(UserDetailsEntity userDetailsEntity) {
		this.username = userDetailsEntity.getUsername();
		this.password = userDetailsEntity.getPassword();
//		this.authorities = Arrays.stream(userDetailsEntity.getRoles().split(","))
//				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		
		for(UserRolesEntity userRolesEntity : userDetailsEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(userRolesEntity.getName()));
		}
	}

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