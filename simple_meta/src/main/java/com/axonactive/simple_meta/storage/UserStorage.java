package com.axonactive.simple_meta.storage;

import com.axonactive.simple_meta.enity.Account;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {

    private static UserStorage instance;
    private final List<Account> users;

    private UserStorage() {
        users = new ArrayList<>();
    }

    public static synchronized UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }
        return instance;
    }

    public boolean isExistUser(String userName) {
        for (Account account : users) {
            if (account.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public void addUser(Account account) {
        users.add(account);
    }
}
