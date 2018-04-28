package com.kikuu.api.utils.security;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kikuu.api.kikuu_user.service.KikuuService;

@RestController
@RequestMapping("/error")
public class KErrorController implements ErrorController {

	@Autowired
	KikuuService ks;
	private static String PATH="/error";
	
	@GetMapping
	public String error(HttpServletRequest req){
		return req.getAuthType();
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
}
