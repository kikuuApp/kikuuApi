package com.kikuu.api.utils.security;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.kikuu.api.kikuu_user.collection.KikuuUserDocument;


@Component
public class RestAuthenticationProvider  extends AbstractUserDetailsAuthenticationProvider{

	
	@Value("${kikuu.api.auth.url}")
	private String authenticationUri;

	public RestAuthenticationProvider(){}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken auth)
			throws AuthenticationException {
				String password = auth.getCredentials().toString();
		UserDetails loadedUser=null;

		try {

			ResponseEntity<Principal> authenticationResponse = authenticate(username, password);
			if (authenticationResponse.getStatusCode().value() == 401) {
				List<GrantedAuthority>newArrayList = new ArrayList<>();
				return new User("wrongUsername", "wrongPass", newArrayList);
			}
			Set<String> privilegesFromRest = new HashSet<>(); 
			Principal principalFromRest = authenticationResponse.getBody();
			KikuuUserDocument doc = (KikuuUserDocument)principalFromRest;
            doc.getRoles().stream().forEach(x -> privilegesFromRest.add(x));
			
			// fill in the privilegesFromRest from the Principal
			String[] authoritiesAsArray = 
				privilegesFromRest.toArray(new String[privilegesFromRest.size()]);
			List<GrantedAuthority> authorities = 
				AuthorityUtils.createAuthorityList(authoritiesAsArray);
			loadedUser = new User(username, password, authorities);
		} catch (Exception ex) {
			throw new AuthenticationServiceException(ex.getMessage());
		}
		return loadedUser;
	}

	public ResponseEntity<Principal> authenticate(String username, String pass) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Principal> entity = new HttpEntity<Principal>(createHeaders(username, pass));
		return restTemplate.exchange(authenticationUri, HttpMethod.POST, entity, Principal.class);
	 }

	 public HttpHeaders createHeaders(String username, String password) {
		HttpHeaders acceptHeaders = new HttpHeaders();
		acceptHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString());

		String authorization = username + ":" + password;
		String basic = new String(Base64.encodeBase64(authorization.getBytes(Charset.forName(StandardCharsets.UTF_8.toString()))));
		acceptHeaders.set("Authorization", "Basic " + basic);
	 
		return acceptHeaders;
	}
	  
}