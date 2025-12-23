package com.example.nookadmin;

import android.content.Intent; // Добавить
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class BookingMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_menu);

        Button btnCreate = findViewById(R.id.btnCreate);
        Button btnList = findViewById(R.id.btnList);
        Button btnTables = findViewById(R.id.btnTables);
        Button btnMainMenu = findViewById(R.id.btnMainMenu);

        btnCreate.setOnClickListener(v ->
                startActivity(new Intent(this, BookingCreateActivity.class)));

        btnList.setOnClickListener(v ->
                startActivity(new Intent(this, BookingListActivity.class)));

        btnTables.setOnClickListener(v ->
                startActivity(new Intent(this, TablesStatusActivity.class)));

        btnMainMenu.setOnClickListener(v ->
                startActivity(new Intent(this, MainActivity.class)));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}