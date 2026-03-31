package com.ivr.ivrcardbin.Controller;


import com.ivr.ivrcardbin.Service.CardService;
import com.ivr.ivrcardbin.Service.OtpService;
import com.ivr.ivrcardbin.dto.CardRequest;
import com.ivr.ivrcardbin.dto.CardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

@RestController
@RequestMapping("/ivr")
public class CardController {
    @Autowired
    private CardService service;
    @Autowired
    private OtpService otpService;

    @PostMapping("/otp")
    public String sendotp(){

        String otp = otpService.generateotp();
        return "OTP anda adalah  : " + otp;

    }
    @PostMapping("/cardbin")
    public CardResponse checkCardPost(@RequestBody CardRequest request){
        return service.checkbin(request.getCardNumber());
    }
    @PostMapping("/menu")
    public String menu(@RequestBody CardRequest request){

        CardResponse response = service.checkbin(request.getCardNumber());

        return service.prosesMenu(
                response.getCardType(),
                request.getPilihan()
        );
    }

    @GetMapping("/cardbin")
    public CardResponse checkCardGet(@RequestParam String cardNumber){
        return service.checkbin(cardNumber);
    }

    @GetMapping("/cardbin/{bin}")
    public  CardResponse getCardBin(@PathVariable String bin){
        return  service.checkBinByBin(bin);
    }
}
