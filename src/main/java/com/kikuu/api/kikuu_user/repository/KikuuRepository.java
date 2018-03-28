package com.kikuu.api.kikuu_user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kikuu.api.kikuu_user.collection.KikuuUserDocument;

public interface KikuuRepository extends MongoRepository<KikuuUserDocument, String> {
	KikuuUserDocument findByUsername(String username);
}
