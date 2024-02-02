package com.example.demo.model;

import com.example.demo.model.state.OrderEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "type_presta")
    private String presta;
    private String designation;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Column(name = "nb_days")
    private short days;
    @Column(name = "unit_price")
    private int price;
    @Column(name = "total_exclude_taxe")
    private int totalNoTaxe;
    @Column(name = "total_with_taxe")
    private int totalTaxe;
    private short state;

    public Order() {
    }

    public Order(String presta, String designation, Client client, short days, int price, int totalNoTaxe, int totalTaxe, short state) {
        this.presta = presta;
        this.designation = designation;
        this.client = client;
        this.days = days;
        this.price = price;
        this.totalNoTaxe = totalNoTaxe;
        this.totalTaxe = totalTaxe;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPresta() {
        return presta;
    }

    public void setPresta(String presta) {
        this.presta = presta;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public short getDays() {
        return days;
    }

    public void setDays(short days) {
        this.days = days;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalNoTaxe() {
        return totalNoTaxe;
    }

    public void setTotalNoTaxe(int totalNoTaxe) {
        this.totalNoTaxe = totalNoTaxe;
    }

    public int getTotalTaxe() {
        return totalTaxe;
    }

    public void setTotalTaxe(int totalTaxe) {
        this.totalTaxe = totalTaxe;
    }

    public short getState() {
        return state;
    }

    public OrderEnum getStateEnum() {
        return OrderEnum.values()[state];
    }

    public void setState(short state) {
        this.state = state;
    }
}
