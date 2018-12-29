package com.onfleek.account.core.usecase;

import com.onfleek.account.core.entity.Account;

import java.util.Optional;

public interface GetAccount {

    Optional<Account> getAccount(String username);
}
