package com.onfleek.account.core.usecase;

import com.onfleek.account.core.entity.Account;
import org.apache.commons.lang.StringUtils;

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

        if(StringUtils.isNotBlank(newAccount.getId())) {
            newAccount.setId(null);
        }

        return createAccount.createAccount(newAccount);
    }
}
