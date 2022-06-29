package uz.pdp.spring_boot.configs.security;


import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import uz.pdp.spring_boot.entity.auth.AuthPermission;
import uz.pdp.spring_boot.entity.auth.AuthRole;
import uz.pdp.spring_boot.entity.auth.AuthUser;

import java.util.*;
import java.util.stream.Collectors;


@Getter
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {
    public    AuthUser user;
    public Long id;


    public UserDetails(AuthUser user) {
        this.user = user;
        this.id = user.getId();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<GrantedAuthority> authorities = new HashSet<>();

        AuthRole role = user.getRole();

        if (Objects.isNull(role)) {
            return authorities;
        }

        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getCode()));

        List<AuthPermission> permissions = role.getPermissions();

        if (Objects.isNull(permissions)) {
            return authorities;
        }

        authorities.addAll(
                permissions.stream()
                        .map(permission -> new SimpleGrantedAuthority(permission.getCode()))
                        .collect(Collectors.toSet())
        );
        return authorities;
    }

    public  AuthUser getUser() {
        return user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.isBlocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isActive();
    }

    public Long getId() {
        return id;
    }
}
