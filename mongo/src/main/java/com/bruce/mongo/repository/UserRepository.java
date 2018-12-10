package com.bruce.mongo.repository;

import com.bruce.mongo.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserInfo,Long> {
}
