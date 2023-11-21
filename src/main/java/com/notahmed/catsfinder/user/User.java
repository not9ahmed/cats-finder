package com.notahmed.catsfinder.user;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

// TODO make this class use UserDetails
// will be the user entity
// I will create my own and extend UserDetails as it's more logical
@Table("User")
public class User implements UserDetails {

    // most required fields
    private String username;
    private String password;
    private Set<GrantedAuthority> authorities;

/*
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private String first_name;
    private String last_name;
    private String mobile;
    private Character gender;
    private Date birth_date;
    private LocalDateTime details_updated;
    private Character user_role;
    private String profile_image;


 */
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Set<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(authorities, user.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
