package com.ivr.ivrcardbin.dto;

public class CardResponse {

    private String cardType;
    private String network;
    private String bank;
    private String ivrMenu;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getIvrMenu() {
        return ivrMenu;
    }

    public void setIvrMenu(String ivrMenu) {
        this.ivrMenu = ivrMenu;
    }
}
