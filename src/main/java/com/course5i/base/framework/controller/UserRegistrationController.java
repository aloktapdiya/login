package com.course5i.base.framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.course5i.base.framework.entity.UserRegistration;
import com.course5i.base.framework.entity.UserRolesEntity;
import com.course5i.base.framework.model.MessageResponse;
import com.course5i.base.framework.model.MyUserDetails;
import com.course5i.base.framework.model.UserRole;
import com.course5i.base.framework.model.UserRole.EnumRole;
import com.course5i.base.framework.repository.UserDetailsRepository;
import com.course5i.base.framework.repository.UserRolesRepository;

public class UserRegistrationController {
	
	@Autowired
	UserRegistration userRegistration;
	@Autowired
	MessageResponse messageResponse;
	@Autowired
	UserDetailsRepository userDetailsRepository;
	@Autowired
	UserRolesRepository userRolesRepository;
	@Autowired
	MyUserDetails myUserDetails;
	@Autowired
	UserRolesEntity userRolesEntity;
	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("/registration")
	  public ResponseEntity<?> registerUser(@RequestBody UserRegistration userRegistration) {
	
	    if (userDetailsRepository.existsByUsername(userRegistration.getUsername())) {
	      return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
	    }
	    if (userDetailsRepository.existsByEmail(userRegistration.getEmail())) {
	      return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
	    }
	    // Create new user's account
	    MyUserDetails user = new MyUserDetails(userRegistration.getUsername(),
	    		userRegistration.getEmail(),
	                         encoder.encode(userRegistration.getPassword()));
	    Set<String> strRoles = userRegistration.getRole();
	    Set<UserRolesEntity> roles = new HashSet<>();
	    if (strRoles == null) {
	      UserRole userRole = roleRepository.findByName(EnumRole.ROLE_USER)
	          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	      roles.add(userRole);
	    } else {
	      strRoles.forEach(role -> {
	        switch (role) {
	        case "admin":
	          Role adminRole = roleRepository.findByName(EnumRole.ROLE_ADMIN)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(adminRole);
	          break;
	        case "mod":
	          Role modRole = roleRepository.findByName(EnumRole.ROLE_MODERATOR)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(modRole);
	          break;
	        default:
	          Role userRole = roleRepository.findByName(EnumRole.ROLE_USER)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(userRole);
	        }
	      });
	    }
	    user.setRoles(roles);
	    userRepository.save(user);
	    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	  }
}


