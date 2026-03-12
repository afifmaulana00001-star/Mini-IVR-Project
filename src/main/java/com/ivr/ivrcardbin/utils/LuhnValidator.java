package com.ivr.ivrcardbin.utils;

public class LuhnValidator {

    public static boolean isValid(String cardNumber){
        int sum = 0;
        boolean alternate = false;

        for (int i =cardNumber.length() -1; i>=0; i--){

            int n = Integer.parseInt(cardNumber.substring(i,i + i));

            if (alternate){
                n *= 2;
                if (n>9){
                    n = (n % 10)+1;

                }

        }
            sum += n;
            alternate = !alternate;

        }
        return (sum % 10 == 0);
    }

}
