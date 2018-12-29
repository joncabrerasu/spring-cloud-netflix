package com.onfleek.turnservice.configuration;

import com.onfleek.turnservice.dataprovider.database.TurnDatabaseDataProvider;
import com.onfleek.turnservice.dataprovider.database.repository.TurnMongoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseDataProviderConfiguration {

    @Bean
    public TurnDatabaseDataProvider turnDatabaseDataProvider(TurnMongoRepository turnMongoRepository) {
        return new TurnDatabaseDataProvider(turnMongoRepository);
    }
}
