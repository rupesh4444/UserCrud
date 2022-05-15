package com.crud.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.crud.mongo.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

}
