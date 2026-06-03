package com.example.appwc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Verifique se o nome do seu layout de splash é este mesmo:
        setContentView(R.layout.activity_splash);

        // Adiciona um pequeno atraso (ex: 2 segundos) para mostrar a marca da Copa
        new Handler(Looper.getMainLooper()).postDelayed(() -> {

            // Instancia o Model para consultar o SQLite
            ConfiguracaoModel model = new ConfiguracaoModel(this);
            ConfiguracaoPojo config = model.obterConfiguracao();

            // Lógica de verificação da 8ª iteração
            if (config != null && config.getLingua() != null) {
                // Já existe uma língua selecionada, carrega diretamente a aplicação
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            } else {
                // Não existe língua, obriga o utilizador a escolher
                startActivity(new Intent(SplashActivity.this, SelectLanguageActivity.class));
            }

            // Encerra a Splash para que o botão de "Voltar" do Android não a reabra
            finish();

        }, 2000); // 2000 milissegundos = 2 segundos
    }
}