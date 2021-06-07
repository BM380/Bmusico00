package com.example.bmusicos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static String  NAME="sqliteapp.db";
    private static int version= 1;
    public DBHelper(Context context) {
        super(context, NAME,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE [musico] (\n" +
                        "[codigo] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                        "[nome] VARCHAR(60)  NOT NULL,\n" +
                        "[nascimento] VARCHAR(60) ,\n" +
                        "[endereco] VARCHAR(60) ,\n" +
                        "[telefone] INTEGER  ,\n" +
                        "[RG] VARCHAR(60)  ,\n" +
                        "[CPF] VARCHAR(60)  ,\n" +
                        "[email] VARCHAR(60)  ,\n" +
                        "[usuario] VARCHAR(60)  NOT NULL,\n" +
                        "[senha] VARCHAR(60)  NOT NULL,\n" +
                        "[genero] VARCHAR(60)  ,\n" +
                        "[instrumento] VARCHAR(60)  \n" +
                        ")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
