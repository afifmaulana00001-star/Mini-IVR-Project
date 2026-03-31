package com.ivr.ivrcardbin.Service;


import com.ivr.ivrcardbin.dto.CardResponse;
import com.ivr.ivrcardbin.entity.CardBin;
import com.ivr.ivrcardbin.repository.CardBinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Service
public class CardService {

    @Autowired
    private CardBinRepository repository;
    public CardResponse checkbin (String cardNumber){
        String bin = cardNumber.substring(0,6);

        CardBin card = (CardBin) repository.findBybin(bin).orElse(null);

        CardBin cardBin = repository.findBybin(bin).orElseThrow(
                () -> new RuntimeException("Card not found")
        );
        CardResponse response = new CardResponse();

        if (card != null){
            response.setCardType(card.getCardType());
            response.setNetwork(card.getNetwork());
            response.setBank(card.getBank());
            response.setIvrMenu(getMenu(card.getCardType()));
        }
        return response;
    }

    public CardResponse checkBinByBin (String bin){

        if (bin == null || bin.length() != 6){
            throw new RuntimeException("INVALID BIN");
        }

        CardBin card = (CardBin) repository.findBybin(bin).orElse(null);
        CardResponse response = new CardResponse();

        if (card != null){
            response.setCardType(card.getCardType());
            response.setNetwork(card.getNetwork());
            response.setBank(card.getBank());
            response.setIvrMenu(getMenu(card.getCardType()));
        }else {
            response.setCardType("UNKNOWN");
            response.setNetwork("UNKNOWN");
            response.setBank("UNKNOWN");
        }
        return response;
    }

    public String getMenu(String cardType){

        if(cardType.equalsIgnoreCase("CREDIT")){
            return """
               Menu Kartu Kredit
               1 Cek Tagihan
               2 Cek Limit
               3 Aktivasi Kartu
               """;

        }else if(cardType.equalsIgnoreCase("DEBIT")){
            return """
               Menu Kartu Debit
               1 Cek Saldo
               2 Transfer
               3 Ganti PIN
               """;
        }else{
            return """
               Menu Customer Service
               1 Hubungi CS
               2 Informasi Produk
               """;
        }
    }

    public String prosesMenu(String cardType, int pilihan){
        if (cardType == null){
            return "Jenis Kartu Tidak Diketahui";
        }
        if (cardType.equalsIgnoreCase("CREDIT")){
            switch (pilihan){
                case 1:
                    return "Tagihan kartu kredit anda adalah Rp 2.500.000";

                case 2:
                    return "Limit kartu kredit anda adalah Rp 10.000.000";

                case 3:
                    return "Proses aktivasi kartu dipilih. OTP akan dikirim.";

                default:
                    return "Pilihan tidak valid";
            }
        }
        if (cardType.equalsIgnoreCase("DEBIT")){
            switch (pilihan){

                case 1:
                    return "Saldo rekening anda Rp 5.000.000";

                case 2:
                    return "Menu transfer dipilih";

                case 3:
                    return "Silahkan masukkan PIN baru";

                default:
                    return "Pilihan tidak valid";
            }
        }

        return "Menu tidak tersedia";
        }
    }

