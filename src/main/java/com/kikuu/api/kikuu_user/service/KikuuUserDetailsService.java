package com.kikuu.api.kikuu_user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.kikuu.api.kikuu_user.collection.KikuuUserDocument;
import com.kikuu.api.kikuu_user.collection.KiukuuUserDetails;
import com.kikuu.api.kikuu_user.repository.KikuuRepository;

@Component
public class KikuuUserDetailsService implements UserDetailsService {
     
	@Autowired
	KikuuRepository repo;
	
	public KikuuUserDetailsService() {}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          KikuuUserDocument user = repo.findByUsername(username);
          if(user == null) {
        	  throw new UsernameNotFoundException(username);
          }
          return new KiukuuUserDetails(user);
	}

}
