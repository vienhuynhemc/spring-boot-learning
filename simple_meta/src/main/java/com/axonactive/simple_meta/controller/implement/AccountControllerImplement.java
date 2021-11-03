package com.axonactive.simple_meta.controller.implement;

import com.axonactive.simple_meta.controller.AccountController;
import com.axonactive.simple_meta.enity.Account;
import com.axonactive.simple_meta.service.AccountService;
import com.axonactive.simple_meta.service.dto.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountControllerImplement implements AccountController {

    private final AccountService accountService;

    @Override
    public Account login(AccountDTO accountDTO) {
        return accountService.login(accountDTO);
    }

}
