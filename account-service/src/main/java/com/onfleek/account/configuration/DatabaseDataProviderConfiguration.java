package com.onfleek.account.configuration;

import com.onfleek.account.dataprovider.AccountDatabaseDataProvider;
import com.onfleek.account.dataprovider.AccountMongoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseDataProviderConfiguration {

    @Bean
    public AccountDatabaseDataProvider accountDatabaseDataProvider(AccountMongoRepository accountMongoRepository) {
        return new AccountDatabaseDataProvider(accountMongoRepository);
    }
}
