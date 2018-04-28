package com.kikuu.api.utils.json;

import java.io.Serializable;

public class KikuuPayload<T> implements Serializable{
    private static final long serialVersionUID = 1L;


    public KikuuPayload(){}

    public KikuuPayload( final int successCode, final Boolean success, final String successMsg, final T data){
        this.successCode = successCode;
        this.success = success;
        this.successMsg = successMsg;
        this.data = data;
    }
    private T data;
    private int successCode;
    private String successMsg;
    private Boolean success;


	/**
	 * @return the success
	 */
	public Boolean getSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	/**
	 * @return the successMsg
	 */
	public String getSuccessMsg() {
		return successMsg;
	}
	/**
	 * @param successMsg the successMsg to set
	 */
	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}
	/**
	 * @return the successCode
	 */
	public int getSuccessCode() {
		return successCode;
	}
	/**
	 * @param successCode the successCode to set
	 */
	public void setSuccessCode(int successCode) {
		this.successCode = successCode;
	}
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

}