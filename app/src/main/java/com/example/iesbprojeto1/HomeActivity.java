package com.example.iesbprojeto1;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.inputmethod.InputMethodManager;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private Button btnEnviarNome, btLight, btDark, btSO;
    private EditText homeEditTextView;
    private TextView NameRecievedText;
    private List<String> names = new ArrayList<>();
    private RecyclerView recyclerView;
    private NameAdapter nameAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnEnviarNome = findViewById(R.id.btnEnviarNome);
        NameRecievedText = findViewById(R.id.NameRecievedText);
        homeEditTextView = findViewById(R.id.homeEditTextView);
        recyclerView = findViewById(R.id.recyclerView);
        btLight = findViewById(R.id.btLight);
        btDark = findViewById(R.id.btDark);
        btSO = findViewById(R.id.btSO);

        Intent intent = getIntent();
        String nameReceived = intent.getStringExtra("KEY_NAME");
        NameRecievedText.setText("Usuário Logado: " + nameReceived);

        names.add("Mamede");
        names.add("IESB");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        nameAdapter = new NameAdapter(names);
        recyclerView.setAdapter(nameAdapter);

        btLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });
        btDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        });
        btSO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
            }
        });

        btnEnviarNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = homeEditTextView.getText().toString().trim();
                names.add(name);
                hideKeybaord(view);
            }
        });

        //Atualizacao no meu Adapter
        nameAdapter.notifyItemInserted(names.size() - 1);
    }

    private void hideKeybaord(View v) {
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
    }
}