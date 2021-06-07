package com.example.bmusicos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public abstract class ConsultaActivity extends MainActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
   public ListView listademusicos;
    private Button buttonsair;
    private MusicoAdapter musicoAdapter;
    private ArrayList<Musico> musicos;
    private Object Adapter;

    protected ConsultaActivity(Button buttonsair) {
        this.buttonsair = buttonsair;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        listademusicos=findViewById(R.id.listademusicos);

        Button sair= findViewById(R.id.btn_sair);
        buttonsair.setOnClickListener(this);



        musicos= new Musico(this).getMusico();
        musicoAdapter = new MusicoAdapter(this,musicos);



    }

    @Override
    public void onClick(View v){

        finish();
    }


    @Override
    public void onItemClick(AdapterView<?> pareat,View view,int position,long id){

        Musico musico= musicos.get(position);
        Intent intent= new Intent(this,CadastroActivity.class);
        intent.putExtra("consulta",musico.getCodigo());

        startActivity(intent);




    }

    @Override
    protected void onResume(){
    super.onResume();


    }
}


