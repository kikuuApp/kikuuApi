package com.kikuu.api.kikuu_user.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.kikuu.api.kikuu_user.collection.KikuuUserDocument;
import com.kikuu.api.kikuu_user.repository.KikuuRepository;

@Component
public class KikuuUserDetailsService implements UserDetailsService {
     
	@Autowired
	KikuuRepository repo;
	
	public KikuuUserDetailsService() {}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          KikuuUserDocument user = repo.findByUsername(username);
          if(user == null) throw new UsernameNotFoundException("Username not found "+username);
          Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

  		// Get user roles and set granted authorities up
  		for (String role : user.getRoles()){
  			grantedAuthorities.add(new SimpleGrantedAuthority(role));
  		}

  		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);

	}

}

