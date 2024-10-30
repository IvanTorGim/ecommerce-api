package com.itortosagimeno.ecommerce_api.user.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "addresses")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String street;

    private String city;

    private String country;

    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public AddressEntity() {
    }

    public AddressEntity(String street, String city, String country, String zipCode, UserEntity user) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
        this.user = user;
    }

    public AddressEntity(Integer id, String street, String city, String country, String zipCode, UserEntity user) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(street, that.street) && Objects.equals(city, that.city) && Objects.equals(country, that.country) && Objects.equals(zipCode, that.zipCode) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, city, country, zipCode, user);
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", user=" + user +
                '}';
    }
}