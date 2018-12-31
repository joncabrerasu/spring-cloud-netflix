package com.onfleek.account.core.usecase;

import com.onfleek.account.core.entity.Account;
import com.onfleek.account.core.usecase.exception.AccountNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetAccountUseCaseTest {

    @Mock
    GetAccount getAccount;

    @InjectMocks
    private GetAccountUseCase getAccountUseCase;

    @Test
    public void getAccount() {

        Optional<Account> expected = getExpectedAccount();

        when(getAccount.getAccount("joncabrerasu@gmail.com")).thenReturn(expected);
        Account actualAccount = getAccountUseCase.getAccount("joncabrerasu@gmail.com");

        assertThat(actualAccount).isEqualTo(expected.get());
    }

    @Test(expected = AccountNotFoundException.class)
    public void getAccountNotFound() {
        when(getAccount.getAccount(anyString())).thenReturn(Optional.empty());
        getAccountUseCase.getAccount("joncabrerasu@gmail.com");
    }

    private Optional<Account> getExpectedAccount() {
        Account expected = new Account();
        expected.setId("id");
        expected.setUsername("joncabrerasu@gmail.com");
        expected.setGivenName("Jon");
        expected.setSurName("Cabrera");
        expected.setRole("Software Developer");
        return Optional.of(expected);
    }
}