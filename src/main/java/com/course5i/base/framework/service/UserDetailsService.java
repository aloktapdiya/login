package com.course5i.base.framework.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.course5i.base.framework.entity.UserDetailsEntity;
import com.course5i.base.framework.model.MyUserDetails;
import com.course5i.base.framework.repository.UserDetailsRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserDetailsEntity> user = userDetailsRepository.findByUsername(username);
		user.orElseThrow(() ->new UsernameNotFoundException("User not found "+username));
		
		return user.map(MyUserDetails::new).get();
	}
}
