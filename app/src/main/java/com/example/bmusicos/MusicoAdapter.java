package com.example.bmusicos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.BreakIterator;
import java.util.ArrayList;

public class MusicoAdapter extends ArrayAdapter<Musico> {
    private ArrayList<Musico> musicos;
    private BreakIterator edtnome;
    private BreakIterator edtendereco;
    private BreakIterator edttel;
    private BreakIterator edt_email;
    private BreakIterator edtinstrumento;
    private BreakIterator edtgenero;

    public MusicoAdapter(@NonNull Context context, @NonNull ArrayList<Musico> musico) {
        super(context,0, musico);
        this.musicos= musicos;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Musico musico = musicos.get(position);

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_musico,null);

        TextView textviewnome= convertView.findViewById(R.id.textView_nome);
        TextView textviewendereco= convertView.findViewById(R.id.textView_endereco);
        TextView textviewtelefone= convertView.findViewById(R.id.textView_telefone);
        TextView textviewemail= convertView.findViewById(R.id.textView_email);
        TextView textviewinstrumento= convertView.findViewById(R.id.textView_instrumento);
        TextView textviewgenero= convertView.findViewById(R.id.textView_genero);

        textviewnome.setText(musico.getNome(edtnome.getText().toString()));
        textviewendereco.setText(musico.getEndereco(edtendereco.getText().toString()));
        textviewtelefone.setText(musico.getTelefone(edttel.getText().toString()));
        textviewemail.setText(musico.getEmail(edt_email.getText().toString()));
        textviewinstrumento.setText(musico.getInstrumento(edtinstrumento.getText().toString()));
        textviewgenero.setText(musico.getGenero(edtgenero.getText().toString()));

        return convertView;
    }
}
