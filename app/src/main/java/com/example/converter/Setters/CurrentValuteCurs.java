package com.example.converter.Setters;

import com.example.converter.models.ValCurs;

public class CurrentValuteCurs {

    public static ValCurs getCurrentValuteCurs() {
        return currentValuteCurs;
    }

    public static void setCurrentValuteCurs(ValCurs currentValuteCurs) {
        CurrentValuteCurs.currentValuteCurs = currentValuteCurs;
    }

    private static ValCurs currentValuteCurs;


}
