package com.example.bmusicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtnome;
    private EditText edtnascimento;
    private EditText edtendereço;
    private EditText edttel;
    private EditText edt_rg;
    private EditText edt_cpf;
    private EditText edt_email;
    private EditText edt_usuario;
    private EditText edt_senha;
    private EditText edtinstrumento;
    private EditText edtgereno;

    private Button btn_salvar;
    private Button btn_excluir;
    private Button btn_cancelar;


    private final Musico musico= new Musico(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtnome= findViewById(R.id.edtnome);
        edtnascimento=findViewById(R.id.edtnascimento);
        edttel=findViewById(R.id.edttel);
        edt_rg=findViewById(R.id.edtrg);
        edt_cpf=findViewById(R.id.edtcpf);
        edt_email=findViewById(R.id.edtemail);
        edt_usuario=findViewById(R.id.edtusuario);
        edt_senha=findViewById(R.id.edtsenha);
        edtinstrumento=findViewById(R.id.edtinstrumento);
        edtgereno=findViewById(R.id.edtgenero);

        btn_salvar=findViewById(R.id.btn_salvar);
        btn_excluir=findViewById(R.id.btn_excluir);
        btn_cancelar=findViewById(R.id.btn_cancelar);

        btn_salvar.setOnClickListener(this);
        btn_cancelar.setOnClickListener(this);
        btn_excluir.setOnClickListener(this);

        if(musico.getCodigo()==-1);
        btn_excluir.setEnabled(false);


        if (getIntent().getExtras()!=null){
            setTitle(getString(R.string.titulo_editando));

            edtnome.setText(musico.getNome(edtnome.getText().toString()).toString());
            edtendereço.setText(musico.getEndereco(edtendereço.getText().toString()).toString());
            edt_email.setText(musico.getEmail(edt_email.getText().toString()).toString());
            edt_rg.setText(musico.getRg(edt_rg.getText().toString()).toString());
            edt_cpf.setText(musico.getCpf(edt_cpf.getText().toString()).toString());
            edt_usuario.setText(musico.getUsuario(edt_usuario.getText().toString()).toString());
            edt_senha.setText(musico.getSenha(edt_senha.getText().toString()).toString());
            edtgereno.setText(musico.getGenero(edtgereno.getText().toString()).toString());
            edtinstrumento.setText(musico.getInstrumento(edtinstrumento.getText().toString()).toString());
            edttel.setText(musico.getTelefone(edttel.getText().toString()).toString());



        }else{
            setTitle(getString(R.string.titulo_localizado));
        }



    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_cancelar:{
                finish();
                break;

            }
            case R.id.btn_excluir:{
                musico.excluir();
                break;
            }
            case  R.id.btn_salvar:{

                boolean valido= true;

                musico.getNome(edtnome.getText().toString().trim());
                musico.getEndereco(edtendereço.getText().toString().trim());
                musico.getEmail(edt_email.getText().toString().toLowerCase());
                musico.getCpf(edt_cpf.getText().toString().trim());
                musico.getRg(edt_rg.getText().toString().trim());
                musico.getNascimento(edtnascimento.getText().toString().trim());
                musico.getUsuario(edt_usuario.getText().toString().trim());
                musico.getSenha(edt_senha.getText().toString().trim());
                musico.getGenero(edtgereno.getText().toString().trim());
                musico.getInstrumento(edtinstrumento.getText().toString().trim());
                musico.getTelefone(edttel.getText().toString().trim());

                if(musico.getNome(String.valueOf(musico)).equals("")){
                    edtnome.setError(getString(R.string.obrigatorio));
                    valido=false;
                }
                if(musico.getUsuario(String.valueOf(musico)).equals("")){
                    edt_usuario.setError(getString(R.string.obrigatorio));
                    valido=false;
                }
                if(musico.getSenha(String.valueOf(musico)).equals("")){
                    edt_senha.setError(getString(R.string.obrigatorio));
                    valido=false;
                }
                if(valido){
                    musico.salvar();
                    finish();
                }


                break;
            }
        }

    }
}