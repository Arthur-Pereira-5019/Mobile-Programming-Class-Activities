package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.app.R;

public class ResultadoIMC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        Double peso = b.getDouble("peso");
        Double altura = b.getDouble("altura");
        TextView tvResultado = findViewById(R.id.textResultado);
        ImageView imageView = findViewById(R.id.viewPerfil);

        setContentView(R.layout.activity_resultado_imc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvResultado.setText(String.valueOf(peso/(altura*altura)));
    }
}