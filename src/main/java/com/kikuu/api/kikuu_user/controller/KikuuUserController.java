package com.kikuu.api.kikuu_user.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kikuu.api.kikuu_user.collection.KikuuUserDocument;
import com.kikuu.api.kikuu_user.service.KikuuService;
import com.kikuu.api.kikuu_user.address.KikuuAddress;
import com.kikuu.api.kikuu_user.email.KikuuEmail;

@RestController
@RequestMapping("/")
public class KikuuUserController {

	@Autowired
	KikuuService ks;
	
	@GetMapping
	public KikuuUserDocument save() {
		List<KikuuEmail> list = new ArrayList<>();
		list.add(new KikuuEmail("richard@king.com"));
		KikuuUserDocument kd = new KikuuUserDocument(null,"Richard King"+ new Random(), "123456bdfd","654964646464",
				                                   new KikuuAddress("Address 1","my City", "My Country","my PostCode"),
				                                   list
				                                   );
		Integer result = ks.save(kd);
		if(result != null) return kd;
		return null;
	}
	
	@GetMapping("/all")
	public List<KikuuUserDocument> getAll(){
		return ks.getAll();
	}
	
	@GetMapping("/error")
	public List<KikuuUserDocument> error(){
		return ks.getAll();
	}
}
