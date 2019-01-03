package com.onfleek.account.dataprovider.database;

import com.onfleek.account.dataprovider.database.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountMongoRepository extends MongoRepository<Account, String> {

    Account findByUsername(String username);
}
