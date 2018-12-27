package com.onfleek.application.core.usecase;

import com.onfleek.application.core.entity.Account;

import java.util.Optional;

public class CreateAccountUseCase {

    private final CreateAccount createAccount;

    private final GetAccount getAccount;

    public CreateAccountUseCase(CreateAccount createAccount, GetAccount getAccount) {
        this.createAccount = createAccount;
        this.getAccount = getAccount;
    }

    public Account createAccount(Account newAccount) {
        Optional<Account> account = getAccount.getAccount(newAccount.getUsername());
        if(account.isPresent()) {
            throw new AccountAlreadyExistsException("Account with username " + newAccount.getUsername() + " already exists");
        }
        return createAccount.createAccount(newAccount);
    }
}
