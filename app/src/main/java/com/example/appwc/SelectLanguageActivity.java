package com.example.appwc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class SelectLanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);
        setTitle("Selecione o Idioma / Select Language");

        ListView listViewIdiomas = findViewById(R.id.listViewIdiomas);

        // Os idiomas que estão no seu ecrã
        String[] idiomasExibicao = {"Português", "English", "Español", "Français", "Deutsch", "Italiano", "العربية", "日本語", "中文", "Nederlands", "Русский", "한국어"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.item_idioma,
                R.id.textIdioma,
                idiomasExibicao
        );
        listViewIdiomas.setAdapter(adapter);

        // --- LÓGICA DA 7ª ITERAÇÃO ---
        listViewIdiomas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Descobre qual idioma foi clicado
                String linguaEscolhida = idiomasExibicao[position];

                // Instancia o Model e grava a configuração na base de dados SQLite
                ConfiguracaoModel model = new ConfiguracaoModel(SelectLanguageActivity.this);
                model.salvarLingua(linguaEscolhida);

                // Carrega o próximo ecrã via Intent
                Intent intent = new Intent(SelectLanguageActivity.this, MainActivity.class);
                startActivity(intent);

                // Fecha este ecrã para limpar o histórico de navegação
                finish();
            }
        });
    }
}