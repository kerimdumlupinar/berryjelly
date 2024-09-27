package com.berryjelly.user_service.model.businessobject.constants;

import java.util.EnumSet;
import java.util.Set;

public enum UserRole {
    ADMIN(EnumSet.of(Permission.READ, Permission.WRITE, Permission.UPDATE, Permission.DELETE)),
    DEVELOPER(EnumSet.of(Permission.READ, Permission.WRITE, Permission.UPDATE)),
    CLIENT(EnumSet.of(Permission.READ, Permission.WRITE));

    private final Set<Permission> permissions;

    UserRole(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

}
