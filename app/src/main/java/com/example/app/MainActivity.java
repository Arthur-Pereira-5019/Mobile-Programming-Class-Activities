package com.example.app;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editTextMin, editTextMax;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        editTextMin = findViewById(R.id.edMin);
        editTextMax = findViewById(R.id.edMax);
        tv = findViewById(R.id.tvResultado);

        button.setOnClickListener(v -> {
            Random r = new Random();
            int min = 0, max = 1000;
            int a = min;
            try {
                min = Integer.parseInt(editTextMin.getText().toString());
                max = Integer.parseInt(editTextMax.getText().toString());
                a = r.nextInt(min, max+1);
            } catch (Exception e) {

            }
            tv.setText(Integer.toString(a));
        });
    }
}