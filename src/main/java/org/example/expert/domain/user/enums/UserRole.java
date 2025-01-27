package org.example.expert.domain.user.enums;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collections;
import java.util.List;

public enum UserRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public List<GrantedAuthority> getAuthorities() {
        return Collections.singletonList(() -> role);
    }

    public static UserRole of(String role) {
        for (UserRole userRole : UserRole.values()) {
            if (userRole.name().equalsIgnoreCase(role)) {
                return userRole;
            }
        }
        throw new IllegalArgumentException("Invalid UserRole: " + role);
    }
}
