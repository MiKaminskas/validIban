package com.example.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@ComponentScan
@Component
public class IbanValid implements IbanValidator {
    private Map<String, Integer> countriesChars;

    IbanValid() {
        countriesChars = new HashMap<>();
        countriesChars.put("AL", 28);
        countriesChars.put("AD", 24);
        countriesChars.put("AT", 20);
        countriesChars.put("AZ", 28);
        countriesChars.put("BH", 22);
        countriesChars.put("BY", 28);
        countriesChars.put("BE", 16);
        countriesChars.put("BA", 20);
        countriesChars.put("BR", 29);
        countriesChars.put("BU", 22);
        countriesChars.put("CR", 22);
        countriesChars.put("HR", 21);
        countriesChars.put("CY", 28);
        countriesChars.put("CZ", 24);
        countriesChars.put("DK", 18);
        countriesChars.put("DO", 28);
        countriesChars.put("TL", 23);
        countriesChars.put("EE", 20);
        countriesChars.put("FO", 18);
        countriesChars.put("FI", 18);
        countriesChars.put("FR", 27);
        countriesChars.put("GE", 22);
        countriesChars.put("DE", 22);
        countriesChars.put("GI", 23);
        countriesChars.put("GR", 27);
        countriesChars.put("GL", 18);
        countriesChars.put("GT", 28);
        countriesChars.put("HU", 28);
        countriesChars.put("IS", 26);
        countriesChars.put("IE", 22);
        countriesChars.put("IL", 23);
        countriesChars.put("IT", 27);
        countriesChars.put("JO", 30);
        countriesChars.put("KZ", 20);
        countriesChars.put("XK", 20);
        countriesChars.put("KW", 30);
        countriesChars.put("LV", 21);
        countriesChars.put("LB", 28);
        countriesChars.put("LI", 21);
        countriesChars.put("LT", 20);
        countriesChars.put("LU", 20);
        countriesChars.put("MK", 19);
        countriesChars.put("MT", 31);
        countriesChars.put("MR", 27);
        countriesChars.put("MU", 30);
        countriesChars.put("MC", 27);
        countriesChars.put("MO", 24);
        countriesChars.put("ME", 22);
        countriesChars.put("NL", 18);
        countriesChars.put("NO", 15);
        countriesChars.put("PK", 24);
        countriesChars.put("PS", 29);
        countriesChars.put("PO", 28);
        countriesChars.put("PT", 25);
        countriesChars.put("QA", 29);
        countriesChars.put("RO", 24);
        countriesChars.put("SM", 27);
        countriesChars.put("SA", 24);
        countriesChars.put("RS", 22);
        countriesChars.put("SK", 24);
        countriesChars.put("SI", 19);
        countriesChars.put("ES", 24);
        countriesChars.put("SE", 24);
        countriesChars.put("CH", 21);
        countriesChars.put("TN", 24);
        countriesChars.put("TR", 26);
        countriesChars.put("AE", 23);
        countriesChars.put("GB", 22);
        countriesChars.put("VA", 22);
        countriesChars.put("VG", 24);


    }

    public boolean ibanValid(String iban) {

        String countryCode = iban.substring(0, 2);

        if (countriesChars.get(countryCode) == null) {
            return false;
        }

        if (iban.length() != countriesChars.get(countryCode)) {
            return false;
        }

        StringBuilder reIban = new StringBuilder()
                .append(convertStringToInt(iban.substring(4, iban.length())))
                .append(convertStringToInt(iban.substring(0, 4)));

        return mod97(reIban.toString());
    }

    private String convertStringToInt(String str) {

        str = str.toUpperCase();

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if ((int) curr >= 65 && (int) curr <= 90) {
                out.append((int) curr - 55);
                continue;
            }
            if ((int) curr >= 48 && (int) curr <= 57) {
                out.append(curr);
            } else {
                try {
                    throw new Exception("Wrong symbol in Iban");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return out.toString();
    }

    private boolean mod97(String iban) {

        BigInteger ibanBi = new BigInteger(iban);
        BigInteger ibanMod = ibanBi.mod(new BigInteger("97"));

        return ibanMod.toString().equals("1");
    }

}
