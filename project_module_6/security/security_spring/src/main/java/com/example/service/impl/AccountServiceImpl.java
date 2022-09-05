package com.example.service.impl;

import com.example.module.Account;
import com.example.repository.IAccountRepository;
import com.example.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountRepository accountRepository;

    @Override
    public Account findAccountByUserName(String username) {
        return accountRepository.findAccountByUserName(username);
    }

    @Override
    public Integer findIdUserByUserName(String username) {
        return null;
    }
}
