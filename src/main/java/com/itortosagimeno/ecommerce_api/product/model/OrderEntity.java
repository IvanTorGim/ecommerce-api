package com.itortosagimeno.ecommerce_api.product.model;

import com.itortosagimeno.ecommerce_api.user.model.AddressEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @Column(name = "datetime")
    private LocalDateTime datetime;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderProductEntity> orderProductList;

    public OrderEntity() {
    }

    public OrderEntity(AddressEntity address, LocalDateTime datetime, List<OrderProductEntity> orderProductList) {
        this.address = address;
        this.datetime = datetime;
        this.orderProductList = orderProductList;
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
