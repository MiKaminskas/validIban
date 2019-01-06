package com.example.demo.model;

import com.example.demo.model.Iban;
import lombok.Data;

import java.util.List;

@Data
public class Ibans {
    private List<Iban> ibans;
    public Ibans(List<Iban> ibans){
        this.ibans = ibans;
    }
}
