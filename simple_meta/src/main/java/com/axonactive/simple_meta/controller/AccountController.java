package com.axonactive.simple_meta.controller;

import com.axonactive.simple_meta.enity.Account;
import com.axonactive.simple_meta.service.dto.AccountDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/user")
public interface AccountController {

    @PostMapping
    Account login(@RequestBody AccountDTO accountDTO);

}
