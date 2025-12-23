package com.example.nookadmin.model;

public class Booking {
    public String date;
    public String name;
    public String phone;
    public String table;

    public Booking(String date, String name, String phone, String table) {
        this.date = date;
        this.name = name;
        this.phone = phone;
        this.table = table;
    }

    @Override
    public String toString() {
        return date + " | " + name + " | стол " + table;
    }
}