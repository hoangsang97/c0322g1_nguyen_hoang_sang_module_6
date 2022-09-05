package com.example.service;

import com.example.module.Account;

public interface IAccountService {

    Account findAccountByUserName(String username);

    Integer findIdUserByUserName(String username);
}
