package com.itortosagimeno.ecommerce_api.product.model.entity;

import com.itortosagimeno.ecommerce_api.user.model.entity.AddressEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @Column(name = "datetime")
    private LocalDateTime datetime;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderProductEntity> orderProductList;

    public OrderEntity() {
    }

    public OrderEntity(Integer id) {
        this.id = id;
    }

    public OrderEntity(AddressEntity address, LocalDateTime datetime) {
        this.address = address;
        this.datetime = datetime;
    }

    public OrderEntity(Integer id, AddressEntity address, LocalDateTime datetime, List<OrderProductEntity> orderProductList) {
        this.id = id;
        this.address = address;
        this.datetime = datetime;
        this.orderProductList = orderProductList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public List<OrderProductEntity> getOrderProductList() {
        return orderProductList;
    }

    public void setOrderProductList(List<OrderProductEntity> orderProductList) {
        this.orderProductList = orderProductList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(address, that.address) && Objects.equals(datetime, that.datetime) && Objects.equals(orderProductList, that.orderProductList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, datetime, orderProductList);
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", address=" + address +
                ", datetime=" + datetime +
                ", orderProductList=" + orderProductList +
                '}';
    }
}
