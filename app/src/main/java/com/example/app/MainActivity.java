package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button button;

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.btnCalcular);
        EditText campoPeso = findViewById(R.id.editPes);
        EditText campoAlt = findViewById(R.id.editAlt);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this,ResultadoIMC.class);
            Bundle bundle = new Bundle();
            bundle.putDouble("peso",Double.parseDouble(campoPeso.getText().toString()));
            bundle.putDouble("altura",Double.parseDouble(campoAlt.getText().toString()));
            intent.putExtras(bundle);
            startActivity(intent);
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}