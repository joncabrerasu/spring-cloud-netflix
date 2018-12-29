package com.onfleek.turnservice.dataprovider.network;

import com.onfleek.turnservice.core.usecase.ExistsAccount;
import com.onfleek.turnservice.dataprovider.network.client.AccountClient;

public class AccountNetworkDataProvider implements ExistsAccount {

    private final AccountClient accountClient;

    public AccountNetworkDataProvider(AccountClient accountClient) {
        this.accountClient = accountClient;
    }

    @Override
    public boolean exists(String username) {
        return accountClient.getAccount(username) != null;
    }
}
