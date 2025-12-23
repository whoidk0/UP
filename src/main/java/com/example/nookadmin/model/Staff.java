package com.example.nookadmin.model;

public class Staff {
    public String name;
    public String phone;
    public String position;

    public Staff(String name, String phone, String position) {
        this.name = name;
        this.phone = phone;
        this.position = position;
    }

    @Override
    public String toString() {
        return name + " (" + position + ")";
    }
}