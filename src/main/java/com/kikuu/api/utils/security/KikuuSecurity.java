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
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.kikuu.api.kikuu_user.service.KikuuUserDetailsService;


@Configuration
@EnableWebSecurity
public class KikuuSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	KikuuUserDetailsService kudService;
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
					.antMatchers("/api/**","/login").permitAll()
					.anyRequest()
	                .authenticated()
					.and().formLogin()
					.successForwardUrl("/doc")
	                .permitAll()
	                .and()
	                .logout()
	                .permitAll();
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
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	 }

}
