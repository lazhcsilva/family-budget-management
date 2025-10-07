package com.fbm.account.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private AccountType accountType;

    @Column(nullable = false)
    private BigDecimal initialBalance;

    @Column(nullable = false)
    private BigDecimal balance;

    public Account() {
    }

    public Account(Long id, String name, AccountType accountType, BigDecimal initialBalance, BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.accountType = accountType;
        this.initialBalance = initialBalance;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
