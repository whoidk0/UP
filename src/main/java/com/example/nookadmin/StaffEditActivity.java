package com.example.nookadmin;

import android.content.Intent; // Добавить
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.nookadmin.data.DataStore;
import com.example.nookadmin.model.Staff;

public class StaffEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_edit);

        int index = getIntent().getIntExtra("index", -1);
        Staff staff = DataStore.staff.get(index);

        EditText etName = findViewById(R.id.etName);
        EditText etPhone = findViewById(R.id.etPhone);
        EditText etPosition = findViewById(R.id.etPosition);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnDelete = findViewById(R.id.btnDelete);

        etName.setText(staff.name);
        etPhone.setText(staff.phone);
        etPosition.setText(staff.position);

        btnSave.setOnClickListener(v -> {
            staff.name = etName.getText().toString();
            staff.phone = etPhone.getText().toString();
            staff.position = etPosition.getText().toString();
            startActivity(new Intent(this, StaffListActivity.class));
            finish();
        });

        btnDelete.setOnClickListener(v -> {
            DataStore.staff.remove(index);
            startActivity(new Intent(this, StaffListActivity.class));
            finish();
        });
    }
}