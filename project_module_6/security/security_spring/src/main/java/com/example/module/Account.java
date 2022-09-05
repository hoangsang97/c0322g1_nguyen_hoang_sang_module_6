package com.example.module;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    private String userName;
    private String encryptPw;
    private Boolean isEnabled;
    private String verificationCode;
    private String email;

    @OneToMany(mappedBy = "account")
    @JsonBackReference
    private Set<AccountRole> accountRoles;

    public Account() {
    }

    public Account(Integer accountId, String userName, String encryptPw, Boolean isEnabled, String verificationCode, String email, Set<AccountRole> accountRoles) {
        this.accountId = accountId;
        this.userName = userName;
        this.encryptPw = encryptPw;
        this.isEnabled = isEnabled;
        this.verificationCode = verificationCode;
        this.email = email;
        this.accountRoles = accountRoles;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncryptPw() {
        return encryptPw;
    }

    public void setEncryptPw(String encryptPw) {
        this.encryptPw = encryptPw;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<AccountRole> getAccountRoles() {
        return accountRoles;
    }

    public void setAccountRoles(Set<AccountRole> accountRoles) {
        this.accountRoles = accountRoles;
    }
}
