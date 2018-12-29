package com.onfleek.turnservice.dataprovider;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TurnMongoRepository extends MongoRepository<Turn, String> {
}
