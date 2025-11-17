package com.example.app;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Dado extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle bundle = getIntent().getExtras();
        ContentValues cv = new ContentValues();

        TextView titulo = findViewById(R.id.dado);
        TextView texto = findViewById(R.id.campoTexto);
        TextView id = findViewById(R.id.idDado);
        Button save = findViewById(R.id.salvar);
        Long idB = bundle.getLong("id");

        titulo.setText(bundle.getString("titulo", "Default String"));
        texto.setText(bundle.getString("texto", "Default String"));
        id.setText(idB.toString());

        db = openOrCreateDatabase("db", MODE_PRIVATE, null);
        save.setOnClickListener(b -> {db.update("notas", cv, "id", new String[]{idB.toString()});});
    }
}