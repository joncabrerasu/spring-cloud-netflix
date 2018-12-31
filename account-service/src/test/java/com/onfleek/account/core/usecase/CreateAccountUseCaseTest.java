package com.onfleek.account.core.usecase;

import com.onfleek.account.core.entity.Account;
import com.onfleek.account.core.usecase.exception.AccountAlreadyExistsException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateAccountUseCaseTest {

    @Mock
    private GetAccount getAccount;

    @Mock
    private CreateAccount createAccount;

    @InjectMocks
    private CreateAccountUseCase createAccountUseCase;

    @Test
    public void createAccount() {
        Optional<Account> expectedAccount = getExpectedAccount();
        when(getAccount.getAccount("joncabrerasu@gmail.com")).thenReturn(Optional.empty());
        when(createAccount.createAccount(expectedAccount.get())).thenReturn(expectedAccount.get());
        Account account = createAccountUseCase.createAccount(expectedAccount.get());
        assertThat(account).isEqualTo(expectedAccount.get());
    }

    @Test(expected = AccountAlreadyExistsException.class)
    public void createAccountAlreadyExists() {
        Optional<Account> expectedAccount = getExpectedAccount();
        when(getAccount.getAccount("joncabrerasu@gmail.com")).thenReturn(expectedAccount);
        createAccountUseCase.createAccount(expectedAccount.get());
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