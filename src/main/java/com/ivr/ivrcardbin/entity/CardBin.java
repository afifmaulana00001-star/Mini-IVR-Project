package com.ivr.ivrcardbin.entity;

import jakarta.persistence.*;

@Entity
public class CardBin {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)

    private Long id;
    private String bin;
    private String cardType;
    private String network;
    private String bank;


    public String getBin(){
        return bin;
    }

    public void setBin(String bin){
        this.bin = bin;
    }

    public String getCardType(){
        return cardType;
    }

    public void setCardType(String cardType){
        this.cardType = cardType;
    }

    public String getNetwork(){
        return network;

    }

    public void setNetwork(String network){
        this.network = network;

    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}
