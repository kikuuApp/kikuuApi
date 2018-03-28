package com.kikuu.api.utils.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.kikuu.api.kikuu_user.service.KikuuUserDetailsService;
import com.kikuu.api.utils.security.roles.KikuuRole;


@Configuration
@EnableWebSecurity
public class KikuuSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	KikuuUserDetailsService kudService;
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	                .antMatchers("/").permitAll()
	                .anyRequest().authenticated()
	                .antMatchers("/api", "/app").hasRole(KikuuRole.ROLE_USER);
	                
	                
	    }

	 @Bean
	 public DaoAuthenticationProvider authenticationProvider() {
	     DaoAuthenticationProvider authProvider
	       = new DaoAuthenticationProvider();
	     authProvider.setUserDetailsService(kudService);
	     authProvider.setPasswordEncoder(encoder());
	     return authProvider;
	 }
	  
	 @Bean
	 public PasswordEncoder encoder() {
	     return new BCryptPasswordEncoder(11);
	 }

}
