package com.example.iesbprojeto1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private Button btnEntrar;
    private EditText NameIdText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NameIdText = findViewById(R.id.NameIdText);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = NameIdText.getText().toString().trim();

                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra("KEY_NAME", name);
                startActivity(intent);
                finish();
            }
        });
    }
}