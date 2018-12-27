package com.onfleek.application.entrypoints;

import com.onfleek.application.core.usecase.AccountAlreadyExistsException;
import com.onfleek.application.core.usecase.AccountNotFoundException;
import com.onfleek.application.core.usecase.CreateAccountUseCase;
import com.onfleek.application.core.usecase.GetAccountUseCase;
import org.apache.commons.lang.StringUtils;
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
            if(StringUtils.isNotBlank(account.getId())) {
                account.setId(null);
            }
            return new ResponseEntity<>(map(createAccountUseCase.createAccount(map(account))), HttpStatus.CREATED);
        } catch (AccountAlreadyExistsException e) {
            throw new AlreadyExistsException(e.getMessage());
        }
    }

    public Account map(com.onfleek.application.core.entity.Account account) {
        Account result = new Account();
        result.setUsername(account.getUsername());
        result.setGivenName(account.getUsername());
        result.setRole(account.getRole());
        result.setSurName(account.getSurName());
        result.setId(account.getId());
        return result;
    }

    public com.onfleek.application.core.entity.Account map(Account account) {
        com.onfleek.application.core.entity.Account result = new com.onfleek.application.core.entity.Account();
        result.setUsername(account.getUsername());
        result.setGivenName(account.getUsername());
        result.setRole(account.getRole());
        result.setSurName(account.getSurName());
        result.setId(account.getId());
        return result;
    }
}
