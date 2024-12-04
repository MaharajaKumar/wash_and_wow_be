package com.raincloud.wash_and_wow.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clothes_sub_categories")
public class ClothesSubCategory extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "clothes_category_id", nullable = false)
    private ClothesCategory clothesCategory;

    public ClothesSubCategory() {
    }

    public ClothesSubCategory(String name, Boolean status, ClothesCategory clothesCategory) {
        this.name = name;
        this.status = status;
        this.clothesCategory = clothesCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ClothesCategory getCategory() {
        return clothesCategory;
    }

    public void setCategory(ClothesCategory clothesCategory) {
        this.clothesCategory = clothesCategory;
    }

    @Override
    public String toString() {
        return "ClothesSubCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", clothesCategory=" + clothesCategory +
                '}';
    }
}