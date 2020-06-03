package com.example.converter.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Valute",strict = false)
public class Valute {

    @Attribute(name = "ID")
    private String ID;

    @Element(name = "NumCode")
    private String NumCode;

    @Element(name = "CharCode")
    private String CharCode;

    @Element(name = "Nominal")
    private String Nominal;

    @Element(name = "Name")
    private String Name;

    @Element(name = "Value")
    private String Value;

    public String getID() {
        return ID;
    }

    public String getNumCode() {
        return NumCode;
    }

    public String getCharCode() {
        return CharCode;
    }

    public String getNominal() {
        return Nominal;
    }

    public String getName() {
        return Name;
    }

    public Valute setID(String ID) {
        this.ID = ID;
        return this;
    }

    public Valute setNumCode(String numCode) {
        NumCode = numCode;
        return this;
    }

    public Valute setCharCode(String charCode) {
        CharCode = charCode;
        return this;
    }

    public Valute setNominal(String nominal) {
        Nominal = nominal;
        return this;
    }

    public Valute setName(String name) {
        Name = name;
        return this;
    }

    public Valute setValue(String value) {
        Value = value;
        return this;
    }

    public String getValue() {
        return Value;
    }

}
