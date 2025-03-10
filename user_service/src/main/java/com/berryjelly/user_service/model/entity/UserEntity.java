package com.berryjelly.user_service.model.entity;

import com.berryjelly.user_service.model.businessobject.constants.UserRole;
import jakarta.persistence.*;
import model.entity.BaseEntity;

@Entity
@Table(name = "APP_USER")
public class UserEntity extends BaseEntity {

    private String firstName;

    private String lastName;

    private String email;

    private String companyCode;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
