package com.example.bmusicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button consulta;
    private Button incluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        consulta=findViewById(R.id.btn_consulta);
        incluir= findViewById(R.id.btn_incluir);

        consulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Musico.class);
                startActivity(intent);
            }
        });

        incluir.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,CadastroActivity.class);
            startActivity(intent);
        });

    }
}