package com.raincloud.wash_and_wow.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_codes")
public class UserCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "role", unique = true, nullable = false)
    private String role;

    @Column(name = "code_prefix", unique = true, nullable = false)
    private String codePrefix;

    @Column(name = "total_users", nullable = false)
    private int totalUsers;

    public UserCode() {
    }

    public UserCode(String role, String codePrefix, int totalUsers) {
        this.role = role;
        this.codePrefix = codePrefix;
        this.totalUsers = totalUsers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCodePrefix() {
        return codePrefix;
    }

    public void setCodePrefix(String codePrefix) {
        this.codePrefix = codePrefix;
    }

    public int getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(int totalUsers) {
        this.totalUsers = totalUsers;
    }

    @Override
    public String toString() {
        return "UserCode{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", codePrefix='" + codePrefix + '\'' +
                ", totalUsers=" + totalUsers +
                '}';
    }
}
