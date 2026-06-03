package com.example.appwc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class EstadioModel {

    private ConexaoSQLite conexaoSQLite;

    public EstadioModel(Context context) {
        conexaoSQLite = new ConexaoSQLite(context);
    }

    // Método para recuperar todos os estádios da tabela
    public List<EstadioPojo> getTodosEstadios() {
        List<EstadioPojo> listaEstadios = new ArrayList<>();
        SQLiteDatabase db = conexaoSQLite.getReadableDatabase();

        String query = "SELECT * FROM Estadios";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                EstadioPojo estadio = popularEstadio(cursor);
                listaEstadios.add(estadio);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return listaEstadios;
    }

    // Método para consultar um único estádio a partir do ID
    public EstadioPojo getEstadioPorId(int id) {
        EstadioPojo estadio = null;
        SQLiteDatabase db = conexaoSQLite.getReadableDatabase();

        String query = "SELECT * FROM Estadios WHERE id = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(id)});

        if (cursor.moveToFirst()) {
            estadio = popularEstadio(cursor);
        }

        cursor.close();
        db.close();
        return estadio;
    }

    // Método auxiliar para evitar repetição de código ao ler os dados do Cursor
    private EstadioPojo popularEstadio(Cursor cursor) {
        EstadioPojo estadio = new EstadioPojo();

        estadio.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
        estadio.setCodigoEstadioEnum(cursor.getInt(cursor.getColumnIndexOrThrow("codigo_estadio_enum")));
        estadio.setNome(cursor.getString(cursor.getColumnIndexOrThrow("nome")));
        estadio.setLocal(cursor.getString(cursor.getColumnIndexOrThrow("local")));
        estadio.setDescricao(cursor.getString(cursor.getColumnIndexOrThrow("descricao")));
        estadio.setDataFundacao(cursor.getString(cursor.getColumnIndexOrThrow("data_fundacao")));
        estadio.setCapacidade(cursor.getInt(cursor.getColumnIndexOrThrow("capacidade")));
        estadio.setImagem(cursor.getString(cursor.getColumnIndexOrThrow("imagem")));
        estadio.setLinkMaps(cursor.getString(cursor.getColumnIndexOrThrow("link_maps")));

        return estadio;
    }
}