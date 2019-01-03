package com.onfleek.account.entrypoints.rest;

import com.onfleek.account.core.usecase.exception.AccountAlreadyExistsException;
import com.onfleek.account.core.usecase.exception.AccountNotFoundException;
import com.onfleek.account.core.usecase.CreateAccountUseCase;
import com.onfleek.account.core.usecase.GetAccountUseCase;
import com.onfleek.account.entrypoints.rest.entity.Account;
import com.onfleek.account.entrypoints.rest.exception.AlreadyExistsException;
import com.onfleek.account.entrypoints.rest.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final GetAccountUseCase getAccountUseCase;

    private final CreateAccountUseCase createAccountUseCase;

    public AccountController(GetAccountUseCase getAccountUseCase, CreateAccountUseCase createAccountUseCase) {
        this.getAccountUseCase = getAccountUseCase;
        this.createAccountUseCase = createAccountUseCase;
    }

    @GetMapping("/accounts/{username}")
    public ResponseEntity<Account> get(@PathVariable String username) {
        try {
            return new ResponseEntity<>(map(getAccountUseCase.getAccount(username)), HttpStatus.OK);
        } catch (AccountNotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    @PostMapping("/accounts")
    public ResponseEntity<Account> create(@RequestBody Account account) {
        try {
            return new ResponseEntity<>(map(createAccountUseCase.createAccount(map(account))), HttpStatus.CREATED);
        } catch (AccountAlreadyExistsException e) {
            throw new AlreadyExistsException(e.getMessage());
        }
    }

    private Account map(com.onfleek.account.core.entity.Account account) {
        Account result = new Account();
        result.setUsername(account.getUsername());
        result.setGivenName(account.getGivenName());
        result.setRole(account.getRole());
        result.setSurName(account.getSurName());
        result.setId(account.getId());
        return result;
    }

    private com.onfleek.account.core.entity.Account map(Account account) {
        com.onfleek.account.core.entity.Account result = new com.onfleek.account.core.entity.Account();
        result.setUsername(account.getUsername());
        result.setGivenName(account.getUsername());
        result.setRole(account.getRole());
        result.setSurName(account.getSurName());
        result.setId(account.getId());
        return result;
    }
}
