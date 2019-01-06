package com.example.demo;

import com.example.demo.model.Iban;
import com.example.demo.model.Ibans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IbanRestController {
    private IbanValidator validator;

    @Autowired
    IbanRestController(IbanValidator validator){
        this.validator = validator;
    }

        // example of request: http://localhost:8080/checkiban?iban=GB82WEST12345698765432
    @RequestMapping("/checkiban")
    public Iban oneIbanCheck(@RequestParam String iban){
        Iban answ = new Iban();
        answ.setIban(iban);
        answ.setValid(validator.ibanValid(answ.getIban()));
        return answ;
    }

    /* example of request
    * All ibans was separated by semicolon.
    * http://localhost:8080/checkibans?ibans=AA051245445454552117989;GB82WEST12345698765432;LT647044001231465456;LT517044077788877777;LT227044077788877777;CC051245445454552117989
    * */
    @RequestMapping("/checkibans")
    public Ibans checkList(@RequestParam String ibans){
        List<Iban> lst = new ArrayList<>();

        String[] splited = ibans.split(";");

        for (String s : splited) {
            Iban obj = new Iban();
            obj.setIban(s);
            obj.setValid(validator.ibanValid(obj.getIban()));
            lst.add(obj);
        }
        return new Ibans(lst);
    }

}
