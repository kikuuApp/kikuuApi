package com.kikuu.api.kikuu_user.collection;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import com.kikuu.api.kikuu_user.address.*;
import com.kikuu.api.kikuu_user.email.KikuuEmail;

/***
 * 
 * @author richie
 *
 */
@Document(collection="kikuuUser")
public class KikuuUserDocument implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@Indexed(unique=true)
	private String username;
	
	private String password;
	private String telephone;
	private KikuuAddress address;
	private List<KikuuEmail> emails;
	
	private Collection<? extends GrantedAuthority> authority;
	

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
							 String telephone,
							 KikuuAddress address,
							 List<KikuuEmail> emails, 
							 Collection<? extends GrantedAuthority> authority) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.telephone = telephone;
		this.address = address;
		this.emails = emails;
		this.authority = authority;
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
								 String telephone,
								 KikuuAddress address,
								 List<KikuuEmail> emails
								 ) {
			this.id = id;
			this.username = username;
			this.password = password;
			this.telephone = telephone;
			this.address = address;
			this.emails = emails;
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
	 */
	public Collection<? extends GrantedAuthority> getAuthority() {
		return authority;
	}
	
	/**
	 * 
	 * @param authority
	 */
	public void setAuthority(Collection<? extends GrantedAuthority> authority) {
		this.authority = authority;
	}
	
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
	
	/**
	 * 
	 * @return List<email>emails
	 */
	public List<KikuuEmail> getEmails() {
		return emails;
	}
	
	/**
	 * 
	 * @param List<email>
	 */
	public void setEmails(List<KikuuEmail> emails) {
		this.emails = emails;
	}
	
}
