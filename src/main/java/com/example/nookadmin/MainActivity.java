package com.example.nookadmin;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnBooking)
                .setOnClickListener(v ->
                        startActivity(new Intent(this, BookingMenuActivity.class)));

        findViewById(R.id.btnStaff)
                .setOnClickListener(v ->
                        startActivity(new Intent(this, StaffListActivity.class)));
    }
}