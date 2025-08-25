package com.example.app;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }

    @Override
    protected void onStart() {
        Log.d("lifecycle","Start");
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.d("lifecycle","Pause");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.d("lifecycle","Restart");
        super.onRestart();
    }

    @Override
    protected void onStop() {
        Log.d("lifecycle","Stop");

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("lifecycle","Destroy");

        super.onDestroy();
    }

    @Override
    protected void onResume() {
        Log.d("lifecycle","Resume");

        super.onResume();
    }


}