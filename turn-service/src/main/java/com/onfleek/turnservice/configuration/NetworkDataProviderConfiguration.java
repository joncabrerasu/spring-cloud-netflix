package com.onfleek.turnservice.configuration;

import com.onfleek.turnservice.dataprovider.network.AccountNetworkDataProvider;
import com.onfleek.turnservice.dataprovider.network.client.AccountClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NetworkDataProviderConfiguration {

    @Bean
    public AccountNetworkDataProvider accountNetworkDataProvider(AccountClient accountClient) {
        return new AccountNetworkDataProvider(accountClient);
    }
}
