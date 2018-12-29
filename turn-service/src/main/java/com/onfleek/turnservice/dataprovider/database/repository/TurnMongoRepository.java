package com.onfleek.turnservice.dataprovider.database.repository;

import com.onfleek.turnservice.dataprovider.database.entity.Turn;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TurnMongoRepository extends MongoRepository<Turn, String> {
}
