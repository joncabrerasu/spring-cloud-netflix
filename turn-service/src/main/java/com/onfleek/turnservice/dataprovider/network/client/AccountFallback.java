package com.onfleek.turnservice.dataprovider.network.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AccountFallback implements AccountClient{
    @Override
    public Object getAccount(String userName) {
        log.error("Error retrieving account with username {} from account-service", userName);
        return null;
    }
}
