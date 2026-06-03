package com.example.appwc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ConfiguracaoModel {

    private ConexaoSQLite conexaoSQLite;

    public ConfiguracaoModel(Context context) {
        conexaoSQLite = new ConexaoSQLite(context);
    }

    // Grava na tabela de configurações a língua selecionada
    public void salvarLingua(String lingua) {
        SQLiteDatabase db = conexaoSQLite.getWritableDatabase();

        // Verifica se já existe alguma configuração guardada
        Cursor cursor = db.rawQuery("SELECT id FROM Configuracao", null);

        ContentValues valores = new ContentValues();
        valores.put("lingua", lingua);

        if (cursor.getCount() > 0) {
            // Update se for alguma outra vez que o utilizador escolhe a língua
            cursor.moveToFirst();
            int id = cursor.getInt(0);
            db.update("Configuracao", valores, "id=?", new String[]{String.valueOf(id)});
        } else {
            // Insert se for a primeira vez
            db.insert("Configuracao", null, valores);
        }

        cursor.close();
        db.close();
    }

    // Verifica se já existe na tabela de configuração uma língua selecionada anteriormente
    public ConfiguracaoPojo obterConfiguracao() {
        SQLiteDatabase db = conexaoSQLite.getReadableDatabase();
        ConfiguracaoPojo config = null;

        Cursor cursor = db.rawQuery("SELECT * FROM Configuracao LIMIT 1", null);

        if (cursor.moveToFirst()) {
            config = new ConfiguracaoPojo();
            config.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
            config.setLingua(cursor.getString(cursor.getColumnIndexOrThrow("lingua")));
        }

        cursor.close();
        db.close();

        return config;
    }
}