package com.berryjelly.user_service.model.businessobject;

import com.berryjelly.user_service.model.businessobject.constants.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import model.businessobject.AuditMetaDataBo;

public class UserBo extends PersonBo{

    private String resourceId;
    @JsonIgnore
    private UserRole userRole;
    private AuditMetaDataBo meta;

    @JsonIgnore
    private String password;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public AuditMetaDataBo getMeta() {
        return meta;
    }

    public void setMeta(AuditMetaDataBo meta) {
        this.meta = meta;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
