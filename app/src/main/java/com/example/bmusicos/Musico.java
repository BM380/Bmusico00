package com.example.bmusicos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;

public class Musico {

    private int codigo;
    private String nome;
    private String nascimento;
    private String endereco;
    private String telefone;
    private String rg;
    private String cpf;
    private String email;
    private String usuario;
    private String senha;
    private String genero;
    private String instrumento;
    private boolean excluir;
    private Context context;
    private Throwable e;


    public Musico(Context context){
        this.context= context;
        codigo= -1;

    }


    public int getCodigo() {
        return codigo;
    }

    public String getNome(String s) {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento(String s) {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getEndereco(String s) {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;

    }

    public String getTelefone(String s) {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRg(String s) {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf(String s) {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail(String s) {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario(String s) {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha(String s) {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getGenero(String s) {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getInstrumento(String s) {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public boolean Excluir() {
        DBHelper dbHelper = null;
        SQLiteDatabase sqLiteDatabase = null;
        try {
            dbHelper = new DBHelper(context);
            sqLiteDatabase = dbHelper.getWritableDatabase();
            sqLiteDatabase.delete("musico","codigo=?",new String[]{String.valueOf(codigo)});
            excluir= true;
            sqLiteDatabase.beginTransaction();

            sqLiteDatabase.setTransactionSuccessful();
            sqLiteDatabase.endTransaction();

            return true;







        } catch (Exception e) {
            e.printStackTrace();
            sqLiteDatabase.endTransaction();
            return false;

        } finally {

            if (sqLiteDatabase != null)
                sqLiteDatabase.close();
            if (dbHelper != null)
                dbHelper.close();

        }



    }




    public  boolean salvar(){
        DBHelper dbHelper = null;
        SQLiteDatabase sqLiteDatabase = null;
        try {
            dbHelper = new DBHelper(context);
            sqLiteDatabase = dbHelper.getWritableDatabase();
            String sql="";
            if(codigo==-1){
                sql="INSERT INTO musico(nome,nascimento,endereço,telefone,rg,cpf,email,usuario,semha,genero,instrumento)VALUES(?,?,?,?,?,?,?,?,?,?,?)";


            }else {
                sql="UPDATE musico SET nome=?,nascomento=?,endereço=?,telefone=?,rg=?,cpf=?,email=?,usuario=?,senha=?,genero=?,instrumento=?";

            }
            sqLiteDatabase.beginTransaction();
            SQLiteStatement sqLiteStatement= sqLiteDatabase.compileStatement(sql);
            sqLiteStatement.clearBindings();
            sqLiteStatement.bindString(1,nome);
            sqLiteStatement.bindString(2,nascimento);
            sqLiteStatement.bindString(3,endereco);
            sqLiteStatement.bindString(4,telefone);
            sqLiteStatement.bindString(5,rg);
            sqLiteStatement.bindString(6,cpf);
            sqLiteStatement.bindString(7,email);
            sqLiteStatement.bindString(8,usuario);
            sqLiteStatement.bindString(9,senha);
            sqLiteStatement.bindString(10,genero);
            sqLiteStatement.bindString(11,instrumento);
            if(codigo!=-1)
                sqLiteStatement.bindString(12,String.valueOf(codigo));
            sqLiteStatement.executeInsert();

            sqLiteDatabase.setTransactionSuccessful();
            sqLiteDatabase.endTransaction();




          return  true;


        } catch (Exception e) {
            e.printStackTrace();
            sqLiteDatabase.endTransaction();
            return false;

        } finally {

            if (sqLiteDatabase != null)
                sqLiteDatabase.close();
            if (dbHelper != null)
                dbHelper.close();

        }


    }




    public ArrayList<Musico> getMusico() {
        DBHelper dbHelper = null;
        SQLiteDatabase sqLiteDatabase = null;
        Cursor cursor = null;
        ArrayList<Musico> musicos = new ArrayList<>();
        try {
            dbHelper = new DBHelper(context);
            sqLiteDatabase = dbHelper.getReadableDatabase();
            cursor = sqLiteDatabase.query(Boolean.parseBoolean("musico"), null, null, null, null, null, null, null, null);
            while (cursor.moveToNext()) {
                Musico musico = new Musico(context);
                musico.codigo = cursor.getInt(cursor.getColumnIndex("codigo"));
                musico.nome = cursor.getString(cursor.getColumnIndex("nome"));
                musico.nascimento = cursor.getString(cursor.getColumnIndex("nascimento"));
                musico.endereco = cursor.getString(cursor.getColumnIndex("endereço"));
                musico.telefone = cursor.getString(cursor.getColumnIndex("nome"));
                musico.rg = cursor.getString(cursor.getColumnIndex("rg"));
                musico.cpf = cursor.getString(cursor.getColumnIndex("cpf"));
                musico.email = cursor.getString(cursor.getColumnIndex("email"));
                musico.usuario = cursor.getString(cursor.getColumnIndex("usuario"));
                musico.senha = cursor.getString(cursor.getColumnIndex("senha"));
                musico.genero = cursor.getString(cursor.getColumnIndex("genero"));
                musico.instrumento = cursor.getString(cursor.getColumnIndex("instrumento"));
                musicos.add(musico);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
                if (sqLiteDatabase != null)
                    sqLiteDatabase.close();
                if (dbHelper != null)
                    dbHelper.close();
            }

          return musicos;
        }


    public void excluir() {
    }
}
