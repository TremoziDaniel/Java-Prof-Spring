package org.telran.validationExample.com.entity;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String iban;

    private int Amount;

//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @Transient
    private User user;

    public Account() {
    }

    public User getUser() {
        return user;
    }

    public int getAmount() {
        return Amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", iban='" + iban + '\'' +
                '}';
    }
}
