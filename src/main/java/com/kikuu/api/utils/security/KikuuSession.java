package com.kikuu.api.utils.security;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class KikuuSession{
	
	private static HttpSession session;
	
	public KikuuSession() {}
	
	/**
	 * 
	 * @param sessionName
	 * @param obj
	 */
	public static void saveSession(String sessionName, Object obj){
		session.setAttribute(sessionName, obj);
	}
	
	/**
	 * 
	 * @param sessionName
	 * @return
	 */
	public static Object getSession(String sessionName) {
		return session.getAttribute(sessionName);
	}

}
