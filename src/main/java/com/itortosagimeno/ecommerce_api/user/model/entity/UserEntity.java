package com.itortosagimeno.ecommerce_api.user.model.entity;

import com.itortosagimeno.ecommerce_api.user.model.common.Role;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "token")
    private String token;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;

    public UserEntity() {
    }

    public UserEntity(Integer id) {
        this.id = id;
    }

    public UserEntity(String email, String password, String name, String token, Role role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.token = token;
        this.role = role;
    }

    public UserEntity(Integer id, String email, String password, String name, String token, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.token = token;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity entity = (UserEntity) o;
        return Objects.equals(id, entity.id) && Objects.equals(email, entity.email) && Objects.equals(password, entity.password) && Objects.equals(name, entity.name) && Objects.equals(token, entity.token) && role == entity.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, name, token, role);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                ", role=" + role +
                '}';
    }
}
