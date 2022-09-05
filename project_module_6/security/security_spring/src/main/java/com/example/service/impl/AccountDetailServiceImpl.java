package com.example.service.impl;

import com.example.module.Account;
import com.example.repository.IAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountDetailServiceImpl implements UserDetailsService {

    @Autowired
    IAccountRepository accountRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        Account account = accountRepository.findAccountByUserName(username);
        if (account == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        return AccountDetailsImpl.build(account);
    }
}
