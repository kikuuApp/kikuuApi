package com.kikuu.api.kikuu_user.controller;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kikuu.api.kikuu_user.collection.KikuuUserDocument;
import com.kikuu.api.kikuu_user.service.KikuuService;



@RestController
public class KikuuUserController {

	@Autowired
	KikuuService ks;
	@Autowired
	PasswordEncoder encoder;
	@RequestMapping("/api")
	public KikuuUserDocument save() {
        ks.deleteAll();
        Set<String>roles = new HashSet<>();
        roles.addAll(Arrays.asList("ROLE_USER","ROLE_ADMIN"));
		KikuuUserDocument kd = new KikuuUserDocument();
		kd.setUsername("richard");
		kd.setPasscode("9000");
		kd.setRoles(roles);
		//kd.setPasscode("richard");
		kd.setPassword(encoder.encode("richard"));
		Integer result = ks.save(kd);
		if(result != null) return kd;
		return null;
	}
	
	@GetMapping("/doc")
	public List<KikuuUserDocument> getAll(){
		return ks.getAll();
	}
	
	@GetMapping("/register/{username}/{password}")
	public KikuuUserDocument login(@PathVariable(name="username",required=false) String username, @PathVariable(name="password",required=false) String password) {
        	System.out.println(username + " "+ password);
			return  ks.login(username, password);

	}

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
}
