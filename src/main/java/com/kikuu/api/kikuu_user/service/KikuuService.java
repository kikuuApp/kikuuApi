package com.kikuu.api.kikuu_user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kikuu.api.IGenericService;
import com.kikuu.api.kikuu_user.collection.KikuuUserDocument;
import com.kikuu.api.kikuu_user.repository.KikuuRepository;
import com.mongodb.MongoException;

@Service
public class KikuuService implements IGenericService<KikuuUserDocument,Integer>{

	@Autowired
	KikuuRepository kikuurepo;
	
	@Override
	public Integer save(KikuuUserDocument c) throws MongoException {
		try {
			kikuurepo.save(c);
			return 1;
		}catch (Exception e) {
			throw new MongoException(e.getMessage());
		}
	}

	@Override
	public KikuuUserDocument update(KikuuUserDocument c) throws MongoException {
		return null;
	}

	@Override
	public Integer delete(KikuuUserDocument c) throws MongoException {
		return null;
	}

	@Override
	public Integer deleteAll(List<KikuuUserDocument> tcs) throws MongoException {
		return null;
	}

	@Override
	public List<KikuuUserDocument> getByPagination(Integer limit, Integer offset) {
		return null;
	}

	@Override
	public List<KikuuUserDocument> getAll() {
		return kikuurepo.findAll();
	}

	@Override
	public KikuuUserDocument get(KikuuUserDocument c) {
		return null;
	}

	public KikuuUserDocument login(String username) {
		return kikuurepo.findByUsername(username);
	}

	public void deleteAll(){
		kikuurepo.deleteAll();
	}
}
