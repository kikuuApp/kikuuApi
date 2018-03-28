package com.kikuu.api.kikuu_user.email;

import java.io.Serializable;

public class KikuuEmail implements Serializable{
    private static final long serialVersionUID=1L;

   private String email;
   private Boolean isActive=false;
   private Boolean isVerified = false;
   private Boolean isDefault = false;

   
   /***
    * 
    * @param email
    * @param isActive
    * @param isVerified
    * @param isDefault
    */
   public KikuuEmail(String email, 
		             Boolean isActive, 
		             Boolean isVerified,
		             Boolean isDefault) {
	this.email = email;
	this.isActive = isActive;
	this.isVerified = isVerified;
	this.isDefault = isDefault;
}
   /***
    * 
    * @param email
    */
   public KikuuEmail(String email) {this.email = email;}
   public KikuuEmail() {}
   
/**
    * @param email the email to set
    */
   public void setEmail(String email) {
       this.email = email;
   }
   /**
    * @return the email
    */
   public String getEmail() {
       return email;
   }
   /**
    * @param isActive the isActive to set
    */
   public void setIsActive(Boolean isActive) {
       this.isActive = isActive;
   }
   /**
    * @return the isActive
    */
   public Boolean getIsActive() {
       return isActive;
   }/**
    * @param isDefault the isDefault to set
    */
   public void setIsDefault(Boolean isDefault) {
       this.isDefault = isDefault;
   }/**
    * @return the isDefault
    */
   public Boolean getIsDefault() {
       return isDefault;
   }/**
    * @param isVerified the isVerified to set
    */
   public void setIsVerified(Boolean isVerified) {
       this.isVerified = isVerified;
   }/**
    * @return the isVerified
    */
   public Boolean getIsVerified() {
       return isVerified;
   }

}