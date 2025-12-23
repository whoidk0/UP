package com.example.nookadmin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.nookadmin.data.DataStore;
import com.example.nookadmin.model.Booking;

public class BookingListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_list);

        ListView listView = findViewById(R.id.listBookings);
        Button btnMenu = findViewById(R.id.btnMenu);

        ArrayAdapter<Booking> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                DataStore.bookings
        );

        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            // Удаляем бронирование
            DataStore.bookings.remove(position);

            // ОБНОВЛЯЕМ СТАТУСЫ СТОЛОВ
            DataStore.updateTableStatuses();

            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Бронирование удалено", Toast.LENGTH_SHORT).show();
            return true;
        });

        btnMenu.setOnClickListener(v -> {
            startActivity(new Intent(this, BookingMenuActivity.class));
            finish();
        });
    }
}