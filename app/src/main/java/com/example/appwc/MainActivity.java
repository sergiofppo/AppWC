package com.example.appwc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ajuste de margens do sistema (EdgeToEdge)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configuração da Toolbar (Barra superior)
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Configuração do DrawerLayout (Menu lateral)
        DrawerLayout drawerLayout = findViewById(R.id.main);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // --- NOVO: Lógica de clique do Menu Lateral ---
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                // Já estamos na tela inicial, apenas recua o menu suavemente
                drawerLayout.closeDrawer(GravityCompat.START);

            } else if (id == R.id.nav_language) {
                // Abre a tela de selecionar idioma e fecha o menu
                startActivity(new Intent(MainActivity.this, SelectLanguageActivity.class));
                drawerLayout.closeDrawer(GravityCompat.START);

            } else if (id == R.id.nav_about) {
                // Mostra um pop-up flutuante com informações do projeto e fecha o menu
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Sobre o App")
                        .setMessage("Aplicativo da Copa do Mundo 2026.\n\nDesenvolvido para o projeto da faculdade por Sergio Filippo.")
                        .setPositiveButton("OK", null)
                        .show();
                drawerLayout.closeDrawer(GravityCompat.START);
            }
            return true;
        });

        // --- Lógica de clique dos Cards do Grid ---
        View cardJogos = findViewById(R.id.cardJogos);
        View cardPlacar = findViewById(R.id.cardPlacar);
        View cardTabelas = findViewById(R.id.cardTabelas);
        View cardEstadios = findViewById(R.id.cardEstadios);

        cardJogos.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, JogosActivity.class));
        });

        cardPlacar.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, PlacarActivity.class));
        });

        cardTabelas.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, TabelasActivity.class));
        });

        cardEstadios.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, EstadiosActivity.class));
        });
    }
}