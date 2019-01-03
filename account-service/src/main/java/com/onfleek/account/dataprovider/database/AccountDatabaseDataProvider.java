package com.onfleek.account.dataprovider.database;

import com.onfleek.account.core.usecase.CreateAccount;
import com.onfleek.account.core.usecase.GetAccount;
import com.onfleek.account.dataprovider.database.entity.Account;

import java.util.Optional;

public class AccountDatabaseDataProvider implements GetAccount, CreateAccount {

    private final AccountMongoRepository accountMongoRepository;

    public AccountDatabaseDataProvider(AccountMongoRepository accountMongoRepository) {
        this.accountMongoRepository = accountMongoRepository;
    }

    @Override
    public com.onfleek.account.core.entity.Account createAccount(com.onfleek.account.core.entity.Account account) {
        return mapAccount(accountMongoRepository.insert(mapAccount(account)));
    }

    @Override
    public Optional<com.onfleek.account.core.entity.Account> getAccount(String username) {
        Account result = accountMongoRepository.findByUsername(username);
        return result != null ? Optional.of(mapAccount(result)) : Optional.empty();

    }

    private com.onfleek.account.core.entity.Account mapAccount(Account account) {
        com.onfleek.account.core.entity.Account result = new com.onfleek.account.core.entity.Account();
        result.setId(account.getId());
        result.setUsername(account.getUsername());
        result.setGivenName(account.getGivenName());
        result.setSurName(account.getSurName());
        result.setRole(account.getRole());
        return result;
    }

    private Account mapAccount(com.onfleek.account.core.entity.Account account) {
        Account result = new Account();
        result.setId(account.getId());
        result.setUsername(account.getUsername());
        result.setGivenName(account.getGivenName());
        result.setSurName(account.getSurName());
        result.setRole(account.getRole());
        return result;
    }
}
