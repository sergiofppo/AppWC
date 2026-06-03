package com.example.appwc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class LinguaModel {

    private ConexaoSQLite conexaoSQLite;

    public LinguaModel(Context context) {
        conexaoSQLite = new ConexaoSQLite(context);
    }

    // Busca todas as línguas cadastradas no banco de dados
    public List<LinguaPojo> getTodasLinguas() {
        List<LinguaPojo> lista = new ArrayList<>();
        SQLiteDatabase db = conexaoSQLite.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM Linguas", null);

        if (cursor.moveToFirst()) {
            do {
                LinguaPojo lingua = new LinguaPojo();
                lingua.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
                lingua.setNome(cursor.getString(cursor.getColumnIndexOrThrow("nome")));
                lista.add(lingua);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return lista;
    }
}