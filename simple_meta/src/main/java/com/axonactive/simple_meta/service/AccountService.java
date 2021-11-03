package com.axonactive.simple_meta.service;

import com.axonactive.simple_meta.enity.Account;
import com.axonactive.simple_meta.service.dto.AccountDTO;

public interface AccountService {

    Account login(AccountDTO accountDTO);

}
