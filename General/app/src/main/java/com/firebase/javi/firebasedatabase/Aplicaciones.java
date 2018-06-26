package com.firebase.javi.firebasedatabase;

import java.util.Map;

/**
 * Created by javi on 2/5/18.
 */

public class Aplicaciones {
    String name;
    String tiempo;

    public Aplicaciones(){
    }

    public Aplicaciones(String name, String tiempo) {
        this.name = name;
        this.tiempo = tiempo;
    }

    public String getName() {
        return name;
    }

    public String getTiempo() {
        return tiempo;
    }
}
