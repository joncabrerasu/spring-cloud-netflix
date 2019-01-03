package com.onfleek.account.entrypoints.rest;

import com.onfleek.account.core.usecase.CreateAccountUseCase;
import com.onfleek.account.core.usecase.GetAccountUseCase;
import com.onfleek.account.entrypoints.rest.entity.Account;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {

    @Mock
    private GetAccountUseCase getAccountUseCase;

    @Mock
    private CreateAccountUseCase createAccountUseCase;

    @InjectMocks
    private AccountController accountController;

    @Test
    public void get() {
        Account account = mockAccount();
        when(getAccountUseCase.getAccount("joncabrerasu@gmail.com")).thenReturn(mockEntity());
        ResponseEntity<Account> accountResponseEntity = accountController.get("joncabrerasu@gmail.com");
        Assert.assertThat(accountResponseEntity.getBody(), allOf(hasProperty("id", equalTo(account.getId())),
                hasProperty("username", equalTo(account.getUsername())),
                hasProperty("givenName", equalTo(account.getGivenName())),
                hasProperty("surName", equalTo(account.getSurName())),
                hasProperty("role", equalTo(account.getRole()))));
    }

    @Test
    public void create() {
        Account account = mockAccount();
        when(createAccountUseCase.createAccount(any(com.onfleek.account.core.entity.Account.class))).thenReturn(mockEntity());
        ResponseEntity<Account> accountResponseEntity = accountController.create(account);
        Assert.assertThat(accountResponseEntity.getBody(), allOf(hasProperty("id", equalTo(account.getId())),
                hasProperty("username", equalTo(account.getUsername())),
                hasProperty("givenName", equalTo(account.getGivenName())),
                hasProperty("surName", equalTo(account.getSurName())),
                hasProperty("role", equalTo(account.getRole()))));
    }

    private Account mockAccount() {
        Account account = new Account();
        account.setId("id");
        account.setUsername("joncabrerasu@gmail.com");
        account.setGivenName("Jon");
        account.setSurName("Cabrera");
        account.setRole("Software Developer");
        return account;
    }

    private com.onfleek.account.core.entity.Account mockEntity() {
        com.onfleek.account.core.entity.Account account = new com.onfleek.account.core.entity.Account();
        account.setId("id");
        account.setUsername("joncabrerasu@gmail.com");
        account.setGivenName("Jon");
        account.setSurName("Cabrera");
        account.setRole("Software Developer");
        return account;
    }
}