package com.axonactive.simple_meta.service.implement;

import com.axonactive.simple_meta.enity.Account;
import com.axonactive.simple_meta.repository.AccountRepository;
import com.axonactive.simple_meta.service.AccountService;
import com.axonactive.simple_meta.service.dto.AccountDTO;
import com.axonactive.simple_meta.storage.UserStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImplement implements AccountService {

    private final AccountRepository userRepository;

    @Override
    public Account login(AccountDTO accountDTO) {
        Optional<Account> accountOptional = userRepository.findAccountByUserNameAndPassword(
                accountDTO.getUserName(), accountDTO.getPassword()
        );
        if (accountOptional.isEmpty()) {
            return null;
        }
        Account account = accountOptional.get();
        UserStorage.getInstance().addUser(account);
        return account;
    }

}
