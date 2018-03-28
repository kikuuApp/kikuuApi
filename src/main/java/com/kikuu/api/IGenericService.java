package com.kikuu.api;

import java.util.List;

import com.mongodb.MongoException;

public interface IGenericService <TC, TN>{
	
	TN save(TC c) throws MongoException;
	TC update(TC c) throws MongoException;
	TN delete(TC c) throws MongoException;
	TN deleteAll(List<TC> tcs) throws MongoException;
	List<TC> getByPagination(Integer limit, Integer offset);
	List<TC> getAll();
	TC get(TC c);
}
