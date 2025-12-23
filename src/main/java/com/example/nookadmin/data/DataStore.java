package com.example.nookadmin.data;

import com.example.nookadmin.model.Booking;
import com.example.nookadmin.model.Staff;
import java.util.ArrayList;

public class DataStore {
    public static ArrayList<Booking> bookings = new ArrayList<>();
    public static ArrayList<Staff> staff = new ArrayList<>();
    public static ArrayList<String> tableStatuses = new ArrayList<>();

    // Новый метод для обновления статусов столов
    public static void updateTableStatuses() {
        tableStatuses.clear();

        // Всего 10 столов
        for (int i = 1; i <= 10; i++) {
            boolean isBooked = false;

            // Проверяем, забронирован ли стол
            for (Booking booking : bookings) {
                if (booking.table.equals(String.valueOf(i))) {
                    tableStatuses.add("Стол " + i + ": ЗАНЯТ (" + booking.name + " - " + booking.date + ")");
                    isBooked = true;
                    break;
                }
            }

            if (!isBooked) {
                tableStatuses.add("Стол " + i + ": СВОБОДЕН");
            }
        }
    }
}