package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "INVOICE")
public class Invoice {
    private int id;
    private String number;
    private List<Item> items;

    public Invoice(int id, String number, List<Item> items) {
        this.id = id;
        this.number = number;
        this.items = items;
    }

    public Invoice() {

    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "INVOICE_ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "NUMBER")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @OneToMany(
            targetEntity = Item.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "ITEMS")
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
