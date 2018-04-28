package com.kikuu.api.kikuu_user.controller;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	KikuuService ks;

	@Autowired
	PasswordEncoder encoder;
	
	@RequestMapping
	public KikuuUserDocument save() {
        ks.deleteAll();
        Set<String>roles = new HashSet<>();
        roles.addAll(Arrays.asList("ROLE_USER","ROLE_ADMIN"));
		KikuuUserDocument kd = new KikuuUserDocument();
		kd.setUsername("richard");
		kd.setPasscode("9000");
		kd.setRoles(roles);
		//kd.setPasscode("richard");
		String pwd =encoder.encode("richard");
		kd.setPassword(pwd);
		Integer result = ks.save(kd);
		if(result != null) return kd;
		return null;
	}
	
	@GetMapping("/doc")
	public List<KikuuUserDocument> getAll(){
		return ks.getAll();
	}


    @PostMapping(value = "/login")
    public String login(@RequestBody KikuuUserDocument doc, HttpServletRequest request, HttpServletResponse response) throws ServletException {
    	KikuuUserDocument user = ks.login(doc.getUsername());
    	String d = user.getPassword();
    	 if(encoder.matches("richard", d)){
    		 request.login(doc.getUsername(), doc.getPassword());
    	 }else {
    		return "User credentials error, Please check and try again";
    	 }
         return user.getUsername();
    }

	@PostMapping("/register")
	@Override
	public KikuuPayload<KikuuUserDocument> register(@RequestBody KikuuUserDocument doc, HttpServletRequest req,
			HttpServletResponse resp) {
		return null;
	}

    @PutMapping("/update")
	@Override
	public KikuuPayload<String> update(@RequestBody KikuuUserDocument doc, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}
    @DeleteMapping("/delete")
	@Override
	public KikuuPayload<String> delete(@RequestBody KikuuUserDocument doc, HttpServletRequest req, HttpServletResponse resp) {
		return null;
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
