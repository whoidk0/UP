package com.example.nookadmin;

import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.nookadmin.data.DataStore;
import com.example.nookadmin.model.Staff;

public class StaffAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_add);

        EditText etName = findViewById(R.id.etName);
        EditText etPhone = findViewById(R.id.etPhone);
        EditText etPosition = findViewById(R.id.etPosition);

        findViewById(R.id.btnSave).setOnClickListener(v -> {
            DataStore.staff.add(
                    new Staff(
                            etName.getText().toString(),
                            etPhone.getText().toString(),
                            etPosition.getText().toString()
                    )
            );
            finish();
        });
    }
}