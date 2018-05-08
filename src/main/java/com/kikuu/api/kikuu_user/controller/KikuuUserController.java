package com.kikuu.api.kikuu_user.controller;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kikuu.api.kikuu_user.collection.KikuuUserDocument;
import com.kikuu.api.kikuu_user.service.KikuuService;
import com.kikuu.api.utils.generics.controller.IGenericKikuuController;
import com.kikuu.api.utils.json.KikuuPayload;

@RequestMapping("/api/user/")
@RestController
public class KikuuUserController implements IGenericKikuuController<KikuuUserDocument,String,Integer> {

	@Autowired
	KikuuService kikuuService;

    Logger logger = LoggerFactory.getLogger(KikuuUserController.class);
	@Autowired
	PasswordEncoder encoder;
	

    @PostMapping(value = "/login")
    public String login(@RequestBody KikuuUserDocument doc, HttpServletRequest request, HttpServletResponse response) throws ServletException {
    	KikuuUserDocument user = kikuuService.login(doc.getUsername());
    	String d = user.getPassword();
    	 if(encoder.matches(doc.getPassword(), d)){
    		 request.login(doc.getUsername(), doc.getPassword());
    	 }else {
    		return "User credentials error, Please check and try again";
    	 }
         return user.getUsername();
    }

	@PostMapping(value="/register")
	@Override
	public KikuuPayload<KikuuUserDocument> register(@RequestBody KikuuUserDocument doc, HttpServletRequest req,
			HttpServletResponse resp) throws Exception{
				KikuuUserDocument userDoc;
			try{	
				//@TODO just for developmet
				kikuuService.deleteAll();

				userDoc =	kikuuService.save(doc);
				logger.debug("telephone %s registed @ %s",doc.getUsername(),new Date(System.currentTimeMillis()) );
			}catch(Exception e){
               throw e;
			}
		return new KikuuPayload<KikuuUserDocument>(200,true,"suscess",userDoc);
		
	}

    @PutMapping("/update")
	@Override
	public KikuuPayload<String> update(@RequestBody KikuuUserDocument doc, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}
    @DeleteMapping("/delete")
	@Override
	public KikuuPayload<String> delete(@RequestBody KikuuUserDocument doc, 
							HttpServletRequest req, HttpServletResponse resp)throws Exception {
		//Delete user
		kikuuService.delete(doc);
		logger.debug("User Account %s is deleted @ %s",doc.getUsername(),new Date(System.currentTimeMillis()) );
		return new KikuuPayload<String>(200,true,"suscess","Account deleted");
	}
    @GetMapping("/delete/{id}")
	@Override
	public KikuuPayload<String> delete(@PathVariable String id) {
		return null;
	}
    @PostMapping("/find")
	@Override
	public KikuuPayload<KikuuUserDocument> find(@RequestBody KikuuUserDocument doc) {
		return null;
	}
    @GetMapping("/find/{id}")
	@Override
	public KikuuPayload<KikuuUserDocument> find(@PathVariable String id) {
		return null;
	}

    @GetMapping("/find")
	@Override
	public KikuuPayload<KikuuUserDocument> findAll(@RequestParam(value="from") Integer from, @RequestParam(value="to") Integer to) {
		return null;
	}
	@GetMapping("/count")
	@Override
	public KikuuPayload<Integer> count() {
		return null;
	}
    
}
