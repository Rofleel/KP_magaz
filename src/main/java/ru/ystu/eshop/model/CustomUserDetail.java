package ru.ystu.eshop.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetail extends User implements UserDetails { // класс из Spring Security
    public CustomUserDetail(User user) {
        super(user);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    } // методы состояния аккаунта (не истек)

    @Override
    public boolean isAccountNonLocked() {
        return true;
    } // аккаунт не заблокирован

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    } // аккаунт не истек

    @Override
    public boolean isEnabled() {
        return true;
    } // аккаунт активен

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {  // использует эти роли для контроля доступа
        List<GrantedAuthority> authorityList = new ArrayList<>();
        super.getRoles().forEach(role ->
                authorityList.add(new SimpleGrantedAuthority(role.getName())));
        return authorityList;
    }

    @Override
    public String getUsername() {
        return super.getEmail();
    } // почта заместо логина

    @Override
    public String getPassword() {
        return super.getPassword();
    }
}
