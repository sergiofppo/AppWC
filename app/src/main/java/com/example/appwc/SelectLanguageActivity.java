package com.example.appwc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;

public class SelectLanguageActivity extends AppCompatActivity {

    // Lista com os 12 idiomas para exibir na tela
    private final String[] idiomasExibicao = {
            "🇧🇷 Português", "🇺🇸 English", "🇪🇸 Español", "🇫🇷 Français",
            "🇩🇪 Deutsch", "🇮🇹 Italiano", "🇸🇦 العربية", "🇯🇵 日本語",
            "🇨🇳 中文", "🇳🇱 Nederlands", "🇷🇺 Русский", "🇰🇷 한국어"
    };

    // Códigos correspondentes que o Android usa para identificar cada idioma
    private final String[] codigosIdiomas = {
            "pt", "en", "es", "fr", "de", "it", "ar", "ja", "zh", "nl", "ru", "ko"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);

        // Altera o título da barra superior especificamente para esta tela
        setTitle("Select Language");

        ListView listViewIdiomas = findViewById(R.id.listViewIdiomas);

        // Criar o adaptador simples para inserir os textos na lista rolável
        // Criar o adaptador usando o nosso novo layout customizado e a fonte bonita
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.item_idioma, // O arquivo XML que acabamos de criar
                R.id.textIdioma,      // A ID do TextView dentro daquele arquivo
                idiomasExibicao
        );

        listViewIdiomas.setAdapter(adapter);

        // Configurar a ação de clique em cada item da lista
        listViewIdiomas.setOnItemClickListener((parent, view, position, id) -> {
            // Pega o código do idioma selecionado (ex: "en", "es")
            String codigoSelecionado = codigosIdiomas[position];

            // Aplica o novo idioma no aplicativo de forma nativa
            LocaleListCompat appLocale = LocaleListCompat.forLanguageTags(codigoSelecionado);
            AppCompatDelegate.setApplicationLocales(appLocale);

            // Avança para a MainActivity
            Intent intent = new Intent(SelectLanguageActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Fecha a tela de idiomas para o usuário não voltar para ela ao apertar "voltar"
        });
    }
}