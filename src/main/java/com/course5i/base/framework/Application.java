package com.course5i.base.framework;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

import com.course5i.base.framework.repository.UserDetailsRepository;


import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserDetailsRepository.class)
@EnableSwagger2
public class Application {

	
	public static void main(String[] args) throws NoSuchAlgorithmException {

		SpringApplication.run(Application.class, args);
//		BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder(5,new SecureRandom().getInstanceStrong());
//		
//		System.out.println(bCryptPasswordEncoder.encode("test"));
	}
	
	@Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
	}
}
