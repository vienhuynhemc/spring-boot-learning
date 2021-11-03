package com.axonactive.simple_meta.repository;

import com.axonactive.simple_meta.enity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {

    Optional<Account> findAccountByUserNameAndPassword(String userName,String password);

}
