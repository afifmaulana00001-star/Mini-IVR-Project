package com.ivr.ivrcardbin.Service;


import org.springframework.stereotype.Service;

@Service
public class PinService {
    private String correctPin = "123456";
    public String verifyPin(String inputPin){

    //cek kosong apa tidak
        if (inputPin == null || inputPin.isEmpty()){
            return "Pin Tidak Boleh Kosong";
        }
        //panjang pin 6  digit
        if (inputPin.length() < 6){
            return "Pin Minimal 6 Digit";
        }
        //hanya angka
        if (!inputPin.matches("\\d+")){
            return "Pin Hanya Boleh Angka";

        }
        // cek apakah PIN benar
        if(correctPin.equals(inputPin)){
            return "PIN VALID";
        }else{
            return "PIN SALAH";
        }
    }
}

