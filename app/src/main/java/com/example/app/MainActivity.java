package com.example.app;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        db = openOrCreateDatabase("db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo VARCHAT, texto TEXT)");
        ContentValues cv = new ContentValues();


        b = findViewById(R.id.button);
        b.setOnClickListener(v -> {
            EditText editText = findViewById(R.id.name);
            String texto = editText.getText().toString();
            cv.put("titulo", "Minha primeira nota");
            cv.put("texto", texto);
            db.insert("notas",null, cv);
            Toast.makeText("Nota salva com sucesso!", Toast.LENGTH_SHORT).show();
        });
    }
}