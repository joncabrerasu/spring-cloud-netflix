package com.onfleek.application.core.usecase;

import com.onfleek.application.core.entity.Account;
import java.util.Optional;

public class GetAccountUseCase {

    private final GetAccount getAccount;

    public GetAccountUseCase(GetAccount getAccount) {
        this.getAccount = getAccount;
    }

    public Account getAccount(String username) throws Exception {
        Optional<Account> account = getAccount.getAccount(username);
        if(!account.isPresent()) {
            throw new AccountNotFoundException("Account not found");
        }
        return account.get();
    }
}
