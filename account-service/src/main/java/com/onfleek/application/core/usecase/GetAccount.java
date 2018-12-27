package com.onfleek.application.core.usecase;

import com.onfleek.application.core.entity.Account;

import java.util.Optional;

public interface GetAccount {

    Optional<Account> getAccount(String username);
}
