package com.example.appwc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexaoSQLite extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "copa2026.db";
    // Versão atualizada para 5 para incluir a tabela de Línguas
    private static final int VERSAO_BANCO = 5;

    public ConexaoSQLite(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 1. Tabela de Estádios
        String createTableEstadios = "CREATE TABLE Estadios (id INTEGER PRIMARY KEY AUTOINCREMENT, codigo_estadio_enum INTEGER NOT NULL, nome TEXT NOT NULL, local TEXT NOT NULL, descricao TEXT, data_fundacao TEXT, capacidade INTEGER, imagem TEXT NOT NULL, link_maps TEXT);";
        db.execSQL(createTableEstadios);
        db.execSQL("INSERT INTO Estadios (codigo_estadio_enum, nome, local, descricao, data_fundacao, capacidade, imagem, link_maps) VALUES (1, 'Estádio Azteca', 'Cidade do México, México', 'Um dos estádios mais icónicos do mundo.', '29 de Maio de 1966', 83264, 'ic_estadio_azteca', 'http://...');");

        // 2. Tabela de Configuração (Guarda o idioma escolhido pelo usuário)
        String createTableConfiguracao = "CREATE TABLE Configuracao (id INTEGER PRIMARY KEY AUTOINCREMENT, lingua TEXT NOT NULL);";
        db.execSQL(createTableConfiguracao);

        // 3. Tabela de Seleções
        String createTableSelecoes = "CREATE TABLE Selecoes (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, bandeira TEXT NOT NULL);";
        db.execSQL(createTableSelecoes);
        db.execSQL("INSERT INTO Selecoes (nome, bandeira) VALUES ('Brasil', 'ic_bandeira_brasil');");
        db.execSQL("INSERT INTO Selecoes (nome, bandeira) VALUES ('Argentina', 'ic_bandeira_argentina');");

        // 4. Tabela de Línguas (A tabela que faltava!)
        String createTableLinguas = "CREATE TABLE Linguas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT NOT NULL" +
                ");";
        db.execSQL(createTableLinguas);

        // Populando a tabela de línguas com as 12 opções solicitadas
        db.execSQL("INSERT INTO Linguas (nome) VALUES ('Português');");
        db.execSQL("INSERT INTO Linguas (nome) VALUES ('English');");
        db.execSQL("INSERT INTO Linguas (nome) VALUES ('Español');");
        db.execSQL("INSERT INTO Linguas (nome) VALUES ('Français');");
        db.execSQL("INSERT INTO Linguas (nome) VALUES ('Deutsch');");
        db.execSQL("INSERT INTO Linguas (nome) VALUES ('Italiano');");
        db.execSQL("INSERT INTO Linguas (nome) VALUES ('العربية');");
        db.execSQL("INSERT INTO Linguas (nome) VALUES ('日本語');");
        db.execSQL("INSERT INTO Linguas (nome) VALUES ('中文');");
        db.execSQL("INSERT INTO Linguas (nome) VALUES ('Nederlands');");
        db.execSQL("INSERT INTO Linguas (nome) VALUES ('Русский');");
        db.execSQL("INSERT INTO Linguas (nome) VALUES ('한국어');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Estadios");
        db.execSQL("DROP TABLE IF EXISTS Configuracao");
        db.execSQL("DROP TABLE IF EXISTS Selecoes");
        db.execSQL("DROP TABLE IF EXISTS Linguas");
        onCreate(db);
    }
}