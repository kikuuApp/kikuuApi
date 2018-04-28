package com.kikuu.api.utils.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.kikuu.api.kikuu_user.service.KikuuUserDetailsService;


@Configuration
@EnableWebSecurity
public class KikuuSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	KikuuUserDetailsService kudService;
	@Autowired
	RestAuthenticationProvider aup;
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
					.antMatchers("/api/user/","/api/user/login","/api/user/auth","/api/user/doc").permitAll()
					.antMatchers("/api/user/resgister","/api/user/find","/api/user/count").permitAll()
                    .anyRequest()
					.authenticated()
					.antMatchers("/api/user/delete/","/api/user/update/")
					.hasAnyRole("ROLE_USER","ROLE_USER_GRANTED")
                    .and()
                    .logout()
	                .permitAll();
	        
	        http.csrf().disable().cors().disable();
	                ///.antMatchers("/api", "/app").access("hasRole('USER')").anyRequest().authenticated();
	                
	                
	    }
	 
	 @Override
	 protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		 builder.authenticationProvider(authenticationProvider());
		}

	 @Bean
	 public AuthenticationProvider authenticationProvider() {
	     DaoAuthenticationProvider authProvider
	       = new DaoAuthenticationProvider();
	     authProvider.setUserDetailsService(kudService);
	     authProvider.setPasswordEncoder(encoder());
	     return authProvider;
	 }
	 
	 @Bean
	 public PasswordEncoder encoder() {
			PasswordEncoder encoder = new BCryptPasswordEncoder();
			return encoder;

	 }

}
