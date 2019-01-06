package com.example.demo;

import org.junit.Test;

import static org.junit.Assert.*;

public class IbanValidTest {

    @Test
    public void ibanValid() {
        IbanValid obj = new IbanValid();
        String aa = "AA051245445454552117989"; // false
        String gb = "GB82WEST12345698765432";
        String lt1 = "LT647044001231465456";
        String lt2 = "LT517044077788877777";
        String lt3 = "LT227044077788877777"; // false
        String cc = "CC051245445454552117989"; // false
        assertFalse(obj.ibanValid(aa));
        assertTrue(obj.ibanValid(gb));
        assertTrue(obj.ibanValid(lt1));
        assertTrue(obj.ibanValid(lt2));
        assertFalse(obj.ibanValid(lt3));
        assertFalse(obj.ibanValid(cc));
    }
}