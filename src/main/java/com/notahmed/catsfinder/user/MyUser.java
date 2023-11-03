package com.notahmed.catsfinder.user;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;


// User is sample implementation in spring boot
// TODO Make the required changes and see how i can use my schema and the spring boot schema
// will be deleted
// using class
@Table("User")
public class MyUser extends User {

        @Id
        private Long id;
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


        // TODO make the necessary changes
        // spring security
        public MyUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
                super(username, password, authorities);
        }

        public MyUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
                super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        }



        public MyUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Long id, String username1, String password1, String first_name, String last_name, String mobile, Character gender, Date birth_date, LocalDateTime details_updated, Character user_role, String profile_image) {
                super(username, password, authorities);
                this.id = id;
                this.username = username1;
                this.password = password1;
                this.first_name = first_name;
                this.last_name = last_name;
                this.mobile = mobile;
                this.gender = gender;
                this.birth_date = birth_date;
                this.details_updated = details_updated;
                this.user_role = user_role;
                this.profile_image = profile_image;
        }

        public MyUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Long id, String username1, String password1, String first_name, String last_name, String mobile, Character gender, Date birth_date, LocalDateTime details_updated, Character user_role, String profile_image) {
                super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
                this.id = id;
                this.username = username1;
                this.password = password1;
                this.first_name = first_name;
                this.last_name = last_name;
                this.mobile = mobile;
                this.gender = gender;
                this.birth_date = birth_date;
                this.details_updated = details_updated;
                this.user_role = user_role;
                this.profile_image = profile_image;
        }


        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        @Override
        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        @Override
        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getFirst_name() {
                return first_name;
        }

        public void setFirst_name(String first_name) {
                this.first_name = first_name;
        }

        public String getLast_name() {
                return last_name;
        }

        public void setLast_name(String last_name) {
                this.last_name = last_name;
        }

        public String getMobile() {
                return mobile;
        }

        public void setMobile(String mobile) {
                this.mobile = mobile;
        }

        public Character getGender() {
                return gender;
        }

        public void setGender(Character gender) {
                this.gender = gender;
        }

        public Date getBirth_date() {
                return birth_date;
        }

        public void setBirth_date(Date birth_date) {
                this.birth_date = birth_date;
        }

        public LocalDateTime getDetails_updated() {
                return details_updated;
        }

        public void setDetails_updated(LocalDateTime details_updated) {
                this.details_updated = details_updated;
        }

        public Character getUser_role() {
                return user_role;
        }

        public void setUser_role(Character user_role) {
                this.user_role = user_role;
        }

        public String getProfile_image() {
                return profile_image;
        }

        public void setProfile_image(String profile_image) {
                this.profile_image = profile_image;
        }


        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                if (!super.equals(o)) return false;
                MyUser myUser = (MyUser) o;
                return Objects.equals(id, myUser.id) && Objects.equals(username, myUser.username) && Objects.equals(password, myUser.password) && Objects.equals(first_name, myUser.first_name) && Objects.equals(last_name, myUser.last_name) && Objects.equals(mobile, myUser.mobile) && Objects.equals(gender, myUser.gender) && Objects.equals(birth_date, myUser.birth_date) && Objects.equals(details_updated, myUser.details_updated) && Objects.equals(user_role, myUser.user_role) && Objects.equals(profile_image, myUser.profile_image);
        }

        @Override
        public int hashCode() {
                return Objects.hash(super.hashCode(), id, username, password, first_name, last_name, mobile, gender, birth_date, details_updated, user_role, profile_image);
        }

        @Override
        public String toString() {
                return "MyUser{" +
                        "id=" + id +
                        ", username='" + username + '\'' +
                        ", password='" + password + '\'' +
                        ", first_name='" + first_name + '\'' +
                        ", last_name='" + last_name + '\'' +
                        ", mobile='" + mobile + '\'' +
                        ", gender=" + gender +
                        ", birth_date=" + birth_date +
                        ", details_updated=" + details_updated +
                        ", user_role=" + user_role +
                        ", profile_image='" + profile_image + '\'' +
                        '}';
        }
}
