package com.kikuu.api.kikuu_user.collection;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kikuu.api.kikuu_user.address.*;
import com.kikuu.api.kikuu_user.email.KikuuEmail;

/***
 * 
 * @author richie
 *
 */

@JsonIgnoreProperties(ignoreUnknown=true)
@Document(collection="kikuuUser")
public class KikuuUserDocument implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@Indexed(unique=true)
	private String username;
	private String email;
	private String password;
	private String telephone;
	private KikuuAddress address;
	private List<KikuuEmail> emails;
	private Set<String> roles;
	private String passcode;
	
	//private Collection<? extends GrantedAuthority> authority;
	

   /***
    * 
    * @param id
    * @param username
    * @param password
    * @param telephone
    * @param address
    * @param emails
    * @param authority
    */
	public KikuuUserDocument(String id, 
							 String username, 
							 String password, 
							 String email,
							 String telephone,
							 KikuuAddress address,
							 List<KikuuEmail> emails, 
							 Set<String> roles,
							 String passcode
							 ) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.telephone = telephone;
		this.address = address;
	    this.emails = emails;
		this.email = email;
		this.roles = roles;
		this.passcode = passcode;
	}
	
	
	   /***
	    * 
	    * @param id
	    * @param username
	    * @param password
	    * @param telephone
	    * @param address
	    * @param emails
	    * @param authority
	    */
		public KikuuUserDocument(String id, 
								 String username, 
								 String password, 
								 String email,
								 String telephone,
								 KikuuAddress address,
								 String passcode,
								 Set<String> roles
								 //List<KikuuEmail> emails
								
								 ) {
			this.id = id;
			this.username = username;
			this.password = password;
			this.telephone = telephone;
			this.address = address;
			this.email = email;
			this.passcode = passcode;
			this.roles = roles;
			//this.emails = emails;
		}
		
	public KikuuUserDocument() {}
   
	/**
	 * 
	 * @return id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 
	 * @return telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	
	/**
	 * 
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	/**
	 * 
	 * @return Collection<GrantedAuthority>
	 *//*
	public Collection<? extends GrantedAuthority> getAuthority() {
		return authority;
	}
	
	*//**
	 * 
	 * @param authority
	 *//*
	public void setAuthority(Collection<? extends GrantedAuthority> authority) {
		this.authority = authority;
	}*/
	
	/**
	 * 
	 * @return address
	 */
	public KikuuAddress getAddress() {
		return address;
	}
	
	/**
	 * 
	 * @param address
	 */
	public void setAddress(KikuuAddress address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Set<String> getRoles() {
		return roles;
	}


	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	
	/**
	 * @return the passcode
	 */
	public String getPasscode() {
		return passcode;
	}

	/**
	 * @param passcode the passcode to set
	 */
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
/*	*//**
	 * 
	 * @return List<email>emails
	 *//*
	public List<KikuuEmail> getEmails() {
		return emails;
	}
	
	*//**
	 * 
	 * @param List<email>
	 *//*
	public void setEmails(List<KikuuEmail> emails) {
		this.emails = emails;
	}*/
	
}
