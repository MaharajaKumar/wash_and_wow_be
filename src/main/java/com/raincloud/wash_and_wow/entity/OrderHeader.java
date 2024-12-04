package com.raincloud.wash_and_wow.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "order_headers")
public class OrderHeader extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "order_id", unique = true, nullable = false)
    private String orderId;

    @OneToMany(mappedBy = "orderHeader", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetail> orderDetail;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "service", nullable = false)
    private String service;

    @Column(name = "clothes", nullable = false)
    private String clothes;

    @Column(name = "total_amount", nullable = false)
    private String totalAmount;

    @Column(name = "status", length = 100, columnDefinition = "VARCHAR(100)")
    private String status;

    public OrderHeader() {
    }

    public OrderHeader(String orderId, User user, String service, String clothes, String totalAmount, String status) {
        this.orderId = orderId;
        this.user = user;
        this.service = service;
        this.clothes = clothes;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getClothes() {
        return clothes;
    }

    public void setClothes(String clothes) {
        this.clothes = clothes;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderHeader{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", orderDetail=" + orderDetail +
                ", user=" + user +
                ", service='" + service + '\'' +
                ", clothes='" + clothes + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}