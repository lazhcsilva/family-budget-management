package com.fbm.account.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_account_type")
public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String description;

    public AccountType() {
    }

    public AccountType(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
