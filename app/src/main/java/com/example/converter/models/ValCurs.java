package com.example.converter.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name = "ValCurs",strict = false)
public class ValCurs {

    @Attribute(name = "Date")
    private String Date;

    @Attribute(name = "name")
    private String name;

    @ElementList(inline = true, required = false)
    private List<Valute> ValCurs;

    public List<Valute> addValute(String valuteName, String valuteValue, String valuteNominal){
        ArrayList<Valute> converter = new ArrayList<>();
        converter.add(new Valute().setName(valuteName).setValue(valuteValue).setNominal(valuteNominal));
        converter.addAll(getValCurs());
        return converter;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Valute> getValCurs() {
        return ValCurs;
    }

    public void setValCurs(List<Valute> valCurs) {
        ValCurs = valCurs;
    }
}
