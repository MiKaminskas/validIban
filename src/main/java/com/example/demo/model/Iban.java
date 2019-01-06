package com.example.demo.model;

import lombok.Data;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name= "Iban", propOrder = {
        "iban",
        "isValid"
})
//@XmlRootElement(name="Iban")
@Data
public class Iban {
    @XmlElement(required = true)
    private String iban;
    @XmlElement(required = true)
    private boolean isValid;
}
