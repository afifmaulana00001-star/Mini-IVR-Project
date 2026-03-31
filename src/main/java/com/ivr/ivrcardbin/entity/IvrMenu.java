package com.ivr.ivrcardbin.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class IvrMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String cardType;
    private int optionNumber;
    private String description;

    public long getId() {
        return id;
    }
    public String getCardType(){
        return cardType;
    }

    public int getOptionNumber() {
        return optionNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setOptionNumber(int optionNumber) {
        this.optionNumber = optionNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
