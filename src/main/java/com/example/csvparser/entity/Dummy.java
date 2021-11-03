package com.example.csvparser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dummy")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dummy {

    @Id @GeneratedValue
    private Long id;

    private String data;
    private String type;
    private String fromField;
    private String to;
    private String tags;
    private String amount;
    private String currency;
    private String amountConverted;
    private String currencyOfConversion;
    private String recurrence;
    private String note;



    @Override
    public String toString() {
        return "Dummy{" +
                id  +
                "\t" + data +
                "\t" + type +
                "\t" + fromField +
                "\t" + to +
                "\t" + tags +
                "\t" + amount +
                "\t" + currency +
                "\t" + amountConverted +
                "\t" + currencyOfConversion +
                "\t" + recurrence +
                "\t" + note +
                '}';
    }
}
