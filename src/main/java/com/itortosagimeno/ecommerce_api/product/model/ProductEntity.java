package com.itortosagimeno.ecommerce_api.product.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity()
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private Double price;

    private String image;

    private Integer stock;

    @Enumerated(EnumType.STRING)
    private Category category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity entity = (ProductEntity) o;
        return Objects.equals(id, entity.id) && Objects.equals(name, entity.name) && Objects.equals(description, entity.description) && Objects.equals(price, entity.price) && Objects.equals(image, entity.image) && Objects.equals(stock, entity.stock) && category == entity.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, image, stock, category);
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", stock=" + stock +
                ", category=" + category +
                '}';
    }
}
