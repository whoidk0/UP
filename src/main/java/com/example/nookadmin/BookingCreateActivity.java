package com.example.nookadmin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.nookadmin.data.DataStore;
import com.example.nookadmin.model.Booking;

public class BookingCreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_create);

        EditText etDate = findViewById(R.id.etDate);
        EditText etName = findViewById(R.id.etName);
        EditText etPhone = findViewById(R.id.etPhone);
        EditText etTable = findViewById(R.id.etTable);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnMenu = findViewById(R.id.btnMenu);

        btnSave.setOnClickListener(v -> {
            // Добавляем бронирование
            DataStore.bookings.add(new Booking(
                    etDate.getText().toString(),
                    etName.getText().toString(),
                    etPhone.getText().toString(),
                    etTable.getText().toString()
            ));

            // ОБНОВЛЯЕМ СТАТУСЫ СТОЛОВ
            DataStore.updateTableStatuses();

            Toast.makeText(this, "Бронирование создано", Toast.LENGTH_SHORT).show();
            finish();
        });

        btnMenu.setOnClickListener(v -> {
            startActivity(new Intent(this, BookingMenuActivity.class));
            finish();
        });
    }
}