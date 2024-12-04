package com.raincloud.wash_and_wow.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clothes_categories")
public class ClothesCategory extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "code", unique = true, nullable = false, updatable = false)
    private String code;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @OneToMany(mappedBy = "clothesCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClothesSubCategory> subCategories;

    public ClothesCategory() {
    }

    public ClothesCategory(String code, String name, Boolean status) {
        this.code = code;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<ClothesSubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<ClothesSubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    @Override
    public String toString() {
        return "ClothesCategory{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", subCategories=" + subCategories +
                '}';
    }
}