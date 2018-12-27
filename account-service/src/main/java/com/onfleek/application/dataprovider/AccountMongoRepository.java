package com.onfleek.application.dataprovider;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountMongoRepository extends MongoRepository<Account, String> {

    Account findByUsername(String username);
}
