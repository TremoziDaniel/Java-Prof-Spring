package org.telran.validationExample.com.entity;

//import org.springframework.data.annotation.Id;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_base")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Field name is mandatory")
    private String name;


    @NotBlank
    private String email;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    @Transient
    private UserProfile userProfile;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Account> accounts = new ArrayList<>();

    public User() {
        //
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userProfile=" + userProfile +
                ", accounts=" + accounts +
                '}';
    }
}
