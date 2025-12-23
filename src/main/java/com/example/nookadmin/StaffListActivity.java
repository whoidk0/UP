package com.example.nookadmin;

import android.content.Intent; // Добавить
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.nookadmin.data.DataStore;
import com.example.nookadmin.model.Staff;

public class StaffListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_list);

        ListView listView = findViewById(R.id.listStaff);
        Button btnAddStaff = findViewById(R.id.btnAddStaff);
        Button btnMainMenu = findViewById(R.id.btnMainMenu);

        ArrayAdapter<Staff> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                DataStore.staff
        );

        listView.setAdapter(adapter);

        btnAddStaff.setOnClickListener(v ->
                startActivity(new Intent(this, StaffAddActivity.class)));

        btnMainMenu.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, StaffEditActivity.class);
            intent.putExtra("index", position);
            startActivity(intent);
        });
    }
}