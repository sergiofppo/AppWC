package com.example.appwc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SelectLanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);

        // Mapeando um dos botões (você fará isso para os outros depois)
        Button btnPortugues = findViewById(R.id.btnPortugues);

        // Ação de clique do botão
        btnPortugues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navega para a MainActivity
                Intent intent = new Intent(SelectLanguageActivity.this, MainActivity.class);
                startActivity(intent);
                // Conforme o quadro, NÃO colocamos o finish() aqui.
            }
        });
    }
}
