package com.raincloud.wash_and_wow.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetail extends CommonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_header_id", nullable = false)
    private OrderHeader orderHeader;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "sub_category", nullable = false)
    private String subCategory;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "amount", columnDefinition = "BIGINT")
    private long amount;

    public OrderDetail() {
    }

    public OrderDetail(OrderHeader orderHeader, String category, String subCategory, int quantity, long amount) {
        this.orderHeader = orderHeader;
        this.category = category;
        this.subCategory = subCategory;
        this.quantity = quantity;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", orderHeader=" + orderHeader +
                ", category='" + category + '\'' +
                ", subCategory='" + subCategory + '\'' +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderHeader getOrderHeader() {
        return orderHeader;
    }

    public void setOrderHeader(OrderHeader orderHeader) {
        this.orderHeader = orderHeader;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}