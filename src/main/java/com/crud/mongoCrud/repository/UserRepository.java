package com.crud.mongoCrud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.crud.mongoCrud.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

}
