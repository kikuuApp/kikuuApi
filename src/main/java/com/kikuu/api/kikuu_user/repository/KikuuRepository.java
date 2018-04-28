package com.kikuu.api.kikuu_user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kikuu.api.kikuu_user.collection.KikuuUserDocument;

@Repository
public interface KikuuRepository extends MongoRepository<KikuuUserDocument, String> {
	KikuuUserDocument findByUsername(String username);
	KikuuUserDocument findByUsernameAndPassword(String username,String password);
}
