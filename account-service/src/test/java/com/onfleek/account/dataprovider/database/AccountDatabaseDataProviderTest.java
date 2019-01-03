package com.onfleek.account.dataprovider.database;

import com.onfleek.account.dataprovider.database.entity.Account;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountDatabaseDataProviderTest {

    @Mock
    AccountMongoRepository accountMongoRepository;

    @InjectMocks
    AccountDatabaseDataProvider accountDatabaseDataProvider;


    @Test
    public void createAccount() {
        com.onfleek.account.core.entity.Account account = mockAccount();
        when(accountMongoRepository.insert(any(Account.class))).thenReturn(mockEntity());
        com.onfleek.account.core.entity.Account actualAccount = accountDatabaseDataProvider.createAccount(account);
        Assert.assertThat(actualAccount, allOf(hasProperty("id", equalTo(account.getId())),
                hasProperty("username", equalTo(account.getUsername())),
                hasProperty("givenName", equalTo(account.getGivenName())),
                hasProperty("surName", equalTo(account.getSurName())),
                hasProperty("role", equalTo(account.getRole()))));
    }

    @Test
    public void getAccount() {
        com.onfleek.account.core.entity.Account account = mockAccount();
        when(accountMongoRepository.findByUsername("joncabrerasu@gmail.com")).thenReturn(mockEntity());
        Optional<com.onfleek.account.core.entity.Account> actualAccount = accountDatabaseDataProvider.getAccount("joncabrerasu@gmail.com");
        Assert.assertThat(actualAccount.get(), allOf(hasProperty("id", equalTo(account.getId())),
                hasProperty("username", equalTo(account.getUsername())),
                hasProperty("givenName", equalTo(account.getGivenName())),
                hasProperty("surName", equalTo(account.getSurName())),
                hasProperty("role", equalTo(account.getRole()))));
    }

    @Test
    public void getAccountEmpty() {
        when(accountMongoRepository.findByUsername("joncabrerasu@gmail.com")).thenReturn(null);
        Optional<com.onfleek.account.core.entity.Account> actualAccount = accountDatabaseDataProvider.getAccount("joncabrerasu@gmail.com");
        assertFalse(actualAccount.isPresent());
    }

    private com.onfleek.account.core.entity.Account mockAccount() {
        com.onfleek.account.core.entity.Account account = new com.onfleek.account.core.entity.Account();
        account.setId("id");
        account.setUsername("joncabrerasu@gmail.com");
        account.setGivenName("Jon");
        account.setSurName("Cabrera");
        account.setRole("Software Developer");
        return account;
    }

    private Account mockEntity() {
        Account account = new Account();
        account.setId("id");
        account.setUsername("joncabrerasu@gmail.com");
        account.setGivenName("Jon");
        account.setSurName("Cabrera");
        account.setRole("Software Developer");
        return account;
    }
}