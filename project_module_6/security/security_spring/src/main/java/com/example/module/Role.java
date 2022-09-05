package com.example.module;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    private String name;

    @OneToMany(mappedBy = "role")
    @JsonBackReference
    private Set<AccountRole> accountRoles;

    public Role() {
    }

    public Role(Integer roleId, String name, Set<AccountRole> accountRoles) {
        this.roleId = roleId;
        this.name = name;
        this.accountRoles = accountRoles;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AccountRole> getAccountRoles() {
        return accountRoles;
    }

    public void setAccountRoles(Set<AccountRole> accountRoles) {
        this.accountRoles = accountRoles;
    }
}
