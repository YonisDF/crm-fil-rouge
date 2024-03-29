package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "type_presta")
    private String typePresta;
    private String designation;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Column(name = "nb_days")
    private short nbDays;
    @Column(name = "unit_price")
    private int unitPrice;
    @Column(name = "total_exclude_taxe")
    private int totalNoTaxe;
    @Column(name = "total_with_taxe")
    private int totalTaxe;
    private short state;

    public Order() {
    }

    public Order(String typePresta, String designation, Client client, short nbDays, int unitPrice, short state) {
        this.typePresta = typePresta;
        this.designation = designation;
        this.client = client;
        this.nbDays = nbDays;
        this.unitPrice = unitPrice;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypePresta() {
        return typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
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

    public short getNbDays() {
        return nbDays;
    }

    public void setNbDays(short nbDays) {
        this.nbDays = nbDays;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
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

    public void setState(short state) {
        this.state = state;
    }
}
