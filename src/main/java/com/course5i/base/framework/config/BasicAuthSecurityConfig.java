package com.course5i.base.framework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.course5i.base.framework.service.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicAuthSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired private UserDetailsService userDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().
		antMatchers("/admin").hasRole("ADMIN").
		antMatchers("/user").hasAnyRole("ADMIN","USER").
		antMatchers("/").permitAll().and().formLogin();
	}

	@Bean
	public PasswordEncoder getPasswordEncoder(){
		
//		String idForEncode = "bcrypt";
//		Map encoders = new HashMap<>();
//		encoders.put(idForEncode, new BCryptPasswordEncoder());
//		encoders.put("noop", NoOpPasswordEncoder.getInstance());
//		encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
//		encoders.put("scrypt", new SCryptPasswordEncoder());
//		encoders.put("sha256", new StandardPasswordEncoder());
//
//		
//		PasswordEncoder passwordEncoder =
//		    new DelegatingPasswordEncoder(idForEncode, encoders);
//		return passwordEncoder;
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return encoder;
//		return NoOpPasswordEncoder.getInstance();
		

	}


}
