package com.example.appwc;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetalhaEstadioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalha_estadio);

        // Por enquanto, vamos simular (forçar) a busca pelo estádio de ID 1 que acabamos de inserir
        int estadioId = 1;

        // Instancia o Model para buscar as informações no Banco de Dados SQLite
        EstadioModel model = new EstadioModel(this);
        EstadioPojo estadio = model.getEstadioPorId(estadioId);

        if (estadio != null) {
            // Vinculando os componentes XML com o Java
            TextView textNome = findViewById(R.id.textNomeEstadio);
            TextView textLocal = findViewById(R.id.textLocalEstadio);
            TextView textCapacidade = findViewById(R.id.textCapacidade);
            TextView textFundacao = findViewById(R.id.textFundacao);
            TextView textDescricao = findViewById(R.id.textDescricao);

            // Injetando os dados do banco na tela
            textNome.setText(estadio.getNome());
            textLocal.setText(estadio.getLocal());
            textCapacidade.setText(String.valueOf(estadio.getCapacidade()));
            textFundacao.setText(estadio.getDataFundacao());
            textDescricao.setText(estadio.getDescricao());

            // AVISO DAS FOTOS:
            // Logo vamos adicionar um ImageView no layout.
            // Leremos o nome da imagem do banco (estadio.getImagem()) e
            // puxaremos a foto correspondente que o professor te passou!
        }
    }
}