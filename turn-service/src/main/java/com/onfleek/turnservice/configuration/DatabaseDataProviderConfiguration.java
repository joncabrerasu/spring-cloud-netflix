package com.onfleek.turnservice.configuration;

import com.onfleek.turnservice.dataprovider.TurnDatabaseDataProvider;
import com.onfleek.turnservice.dataprovider.TurnMongoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseDataProviderConfiguration {

    @Bean
    public TurnDatabaseDataProvider turnDatabaseDataProvider(TurnMongoRepository turnMongoRepository) {
        return new TurnDatabaseDataProvider(turnMongoRepository);
    }
}
