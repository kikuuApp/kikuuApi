package com.kikuu.api.kikuu_user.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


/***
 * 
 * @author richie
 *
 */
@Component
public class KiukuuUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;

	private KikuuUserDocument user;
	
	public KiukuuUserDetails() {}
	
	/**
	 * 
	 * @param user
	 */
	public KiukuuUserDetails(KikuuUserDocument user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<SimpleGrantedAuthority> auths = new HashSet<>();
		user.getRoles().stream().forEach(x -> auths.add( new SimpleGrantedAuthority(x)));
		return auths;
	}

	@Override
	public String getPassword() {
		return user.getPasscode();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
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
