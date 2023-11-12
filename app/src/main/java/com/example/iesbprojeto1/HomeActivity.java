package com.example.iesbprojeto1;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView NameIdText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        NameIdText = findViewById(R.id.NameIdText);

        Intent intent = getIntent();
        String nameReceived = intent.getStringExtra("KEY_NAME");
        NameIdText.setText("Usuário Logado: " + nameReceived);

    }
}