package com.example.appwc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class SelectLanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);

        ListView listViewIdiomas = findViewById(R.id.listViewIdiomas);

        // 1. Busca os idiomas diretamente do Banco de Dados usando o Model
        LinguaModel linguaModel = new LinguaModel(this);
        List<LinguaPojo> listaIdiomasBanco = linguaModel.getTodasLinguas();

        // 2. Preenche a ListView com os dados do banco
        // O ArrayAdapter vai usar aquele método toString() que criamos no LinguaPojo para mostrar os nomes
        ArrayAdapter<LinguaPojo> adapter = new ArrayAdapter<>(
                this,
                R.layout.item_idioma,
                R.id.textIdioma,
                listaIdiomasBanco
        );
        listViewIdiomas.setAdapter(adapter);

        // 3. Lógica do clique (7ª iteração dos slides)
        listViewIdiomas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Descobre qual objeto LinguaPojo foi clicado
                LinguaPojo linguaSelecionada = listaIdiomasBanco.get(position);

                // Grava a configuração no banco de dados
                ConfiguracaoModel configModel = new ConfiguracaoModel(SelectLanguageActivity.this);
                configModel.salvarLingua(linguaSelecionada.getNome());

                // Redireciona para o menu principal
                Intent intent = new Intent(SelectLanguageActivity.this, MainActivity.class);
                startActivity(intent);

                // Finaliza esta tela
                finish();
            }
        });
    }
}