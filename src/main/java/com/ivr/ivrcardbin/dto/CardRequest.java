package com.ivr.ivrcardbin.dto;

public class CardRequest {

    private String cardNumber;
    private int pilihan;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPilihan(){
        return pilihan;
    }

    public void setPilihan(int pilihan) {
        this.pilihan = pilihan;
    }
}
