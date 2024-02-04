package com.kostin.first.settings.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kostin.first.entities.User;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
<<<<<<< HEAD
import lombok.NoArgsConstructor;
=======
>>>>>>> ac823d32a045b570eee0782fa5ee75bb561a6805
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@AllArgsConstructor
<<<<<<< HEAD
@NoArgsConstructor
=======
>>>>>>> ac823d32a045b570eee0782fa5ee75bb561a6805
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    private GrantedAuthority authority;

    public static UserDetailsImpl build(User user) {
<<<<<<< HEAD
        //TODO
        GrantedAuthority authorities = new SimpleGrantedAuthority(user.getRole().getAuthority());
        return new UserDetailsImpl(
            user.getId().longValue(),
=======
        GrantedAuthority authorities = new SimpleGrantedAuthority(user.getRole().getAuthority());
        return new UserDetailsImpl(
            user.getId(),
>>>>>>> ac823d32a045b570eee0782fa5ee75bb561a6805
            user.getUsername(),
            user.getEmail(),
            user.getPassword(),
            authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(authority);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}
