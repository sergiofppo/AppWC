package com.example.appwc; // Mantenha o nome do seu pacote

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexaoSQLite extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "copa2026.db";
    // Atualizado para a versão 3 para recriar as tabelas
    private static final int VERSAO_BANCO = 3;

    public ConexaoSQLite(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 1. Tabela de Estádios
        String createTableEstadios = "CREATE TABLE Estadios (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "codigo_estadio_enum INTEGER NOT NULL, " +
                "nome TEXT NOT NULL, " +
                "local TEXT NOT NULL, " +
                "descricao TEXT, " +
                "data_fundacao TEXT, " +
                "capacidade INTEGER, " +
                "imagem TEXT NOT NULL, " +
                "link_maps TEXT" +
                ");";
        db.execSQL(createTableEstadios);

        // Inserir Estádio de teste
        String insertEstadioTeste = "INSERT INTO Estadios (codigo_estadio_enum, nome, local, descricao, data_fundacao, capacidade, imagem, link_maps) " +
                "VALUES (1, 'Estádio Azteca', 'Cidade do México, México', 'Um dos estádios mais icónicos do mundo, palco de duas finais da Copa do Mundo.', '29 de Maio de 1966', 83264, 'ic_estadio_azteca', 'https://maps.app.goo.gl/...');";
        db.execSQL(insertEstadioTeste);

        // 2. Tabela de Configuração (2ª iteração do projeto)
        String createTableConfiguracao = "CREATE TABLE Configuracao (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "lingua TEXT NOT NULL" +
                ");";
        db.execSQL(createTableConfiguracao);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Estadios");
        db.execSQL("DROP TABLE IF EXISTS Configuracao");
        onCreate(db);
    }
}