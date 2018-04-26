package com.kikuu.api.kikuu_user.address;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.mongodb.core.mapping.Document;
@Document
@JsonIgnoreProperties(ignoreUnknown=true)
public class KikuuAddress implements Serializable{
    private static final long serialVersionUID=1L;

   
	private String firstAddress;
    private String secondAddress;
    private Double lng;
    private Double ltd;
    private String state;
    private String region;
    private String city;
    private String country;
    private String postCode;

    
    
	/**
	 * 
	 * @param firstAddress
	 * @param secondAddress
	 * @param lng
	 * @param ltd
	 * @param state
	 * @param region
	 * @param city
	 * @param country
	 * @param postCode
	 */
    public KikuuAddress(String firstAddress,
    		            String secondAddress, 
    		            Double lng, 
    		            Double ltd, 
    		            String state, 
    		            String region,
			            String city, 
			            String country, 
			            String postCode) {
		super();
		this.firstAddress = firstAddress;
		this.secondAddress = secondAddress;
		this.lng = lng;
		this.ltd = ltd;
		this.state = state;
		this.region = region;
		this.city = city;
		this.country = country;
		this.postCode = postCode;
	}

	/**
	 * 
	 * @param firstAddress
	 * @param secondAddress
	 * @param state
	 * @param region
	 * @param city
	 * @param country
	 * @param postCode
	 */
    public KikuuAddress(String firstAddress, 
    		            String secondAddress, 
    		            String state, 
    		            String region,
			            String city, 
			            String country, 
			            String postCode) {
		super();
		this.firstAddress = firstAddress;
		this.secondAddress = secondAddress;
		this.state = state;
		this.region = region;
		this.city = city;
		this.country = country;
		this.postCode = postCode;
	}

   
    
    public KikuuAddress(){}
    
    /***
     * 
     * @param firstAddress
     * @param city
     * @param country
     * @param postCode
     */
	public KikuuAddress(String firstAddress, 
						String city, 
						String country, 
						String postCode) {
		this.firstAddress=firstAddress;
		this.city = city;
		this.country=country;
		this.postCode = postCode;
		
	}


    /**
     * @param firstAddress the firstAddress to set
     */
    public void setFirstAddress(String firstAddress) {
        this.firstAddress = firstAddress;
    }
    /**
     * @return the firstAddress
     */
    public String getFirstAddress() {
        return firstAddress;
    }
    
    /**
     * @return the secondAddress
     */
    public String getSecondAddress() {
        return secondAddress;
    }
    /**
     * @param secondAddress the secondAddress to set
     */
    public void setSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
    }

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getLtd() {
		return ltd;
	}

	public void setLtd(Double ltd) {
		this.ltd = ltd;
	}

	/**
     * @return the state
     */
    public String getState() {
        return state;
    }
    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }
    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }
    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }
    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }
    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }
    /**
     * @return the postCode
     */
    public String getPostCode() {
        return postCode;
    }
    /**
     * @param postCode the postCode to set
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}