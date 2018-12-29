package com.onfleek.account.core.usecase;

import com.onfleek.account.core.entity.Account;
import java.util.Optional;

public class GetAccountUseCase {

    private final GetAccount getAccount;

    public GetAccountUseCase(GetAccount getAccount) {
        this.getAccount = getAccount;
    }

    public Account getAccount(String username) {
        Optional<Account> account = getAccount.getAccount(username);
        if(!account.isPresent()) {
            throw new AccountNotFoundException("Account not found");
        }
        return account.get();
    }
}
