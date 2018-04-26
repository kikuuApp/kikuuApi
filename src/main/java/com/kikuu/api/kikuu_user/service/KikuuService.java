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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(KikuuUserDocument c) throws MongoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteAll(List<KikuuUserDocument> tcs) throws MongoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KikuuUserDocument> getByPagination(Integer limit, Integer offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KikuuUserDocument> getAll() {
		// TODO Auto-generated method stub
		return kikuurepo.findAll();
	}

	@Override
	public KikuuUserDocument get(KikuuUserDocument c) {
		// TODO Auto-generated method stub
		return null;
	}

	public KikuuUserDocument login(String username, String password) {
		return kikuurepo.findByUsernameAndPassword(username, password);
	}

	public void deleteAll(){
		kikuurepo.deleteAll();
	}
}
