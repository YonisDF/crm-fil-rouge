package com.example.demo.controller.dto;

import com.example.demo.model.Client;


public class OrderDTO {

    private String typePresta;
    private String designation;
    private Client client;
    private short nbDays;
    private int unitPrice;
    private int totalNoTaxe;
    private int totalTaxe;
    private String state;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
