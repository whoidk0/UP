package com.example.nookadmin;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.nookadmin.data.DataStore;

public class TablesStatusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables_status);

        ListView listView = findViewById(R.id.listTables);
        Button btnBack = findViewById(R.id.btnBack);

        // Убедимся, что статусы актуальны
        DataStore.updateTableStatuses();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                DataStore.tableStatuses
        );

        listView.setAdapter(adapter);

        btnBack.setOnClickListener(v -> finish());
    }
}