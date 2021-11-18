package com.rp.petroute_java;

public class ElementList {
    public String color;
    public String name;
    public String country;
    public String status;

    // Constructor
    public ElementList(String color, String name, String country, String status) {
        this.color = color;
        this.name = name;
        this.country = country;
        this.status = status;
    }
    // GET = obtener el dato
    // SET = Modificar el dato

    // Métodos GET y SET
    public String getColor() {

        return color;
    }

    public void setColor(String color) {

        this.color = color;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getCountry() {

        return country;
    }

    public void setCountry(String country) {

        this.country = country;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {

        this.status = status;
    }
}

