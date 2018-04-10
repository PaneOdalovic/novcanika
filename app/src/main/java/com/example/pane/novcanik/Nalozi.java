package com.example.pane.novcanik;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pane.novcanik.Baza.BazaPodataka;
import com.example.pane.novcanik.Baza.Nalog;

import java.util.List;

/**
 * Created by Pane on 1/24/2018.
 */

public class Nalozi extends AppCompatActivity {
    EditText naziv;
    List<Nalog> nalozi;
    ImageButton dodavanje;
    ListView list;
    Nalog[] web;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nalozi);
        nalozi=MainActivity.bp.vratiSveNalog();
        web=new Nalog[nalozi.size()];
        int i=0;
        for(Nalog n:nalozi){
            //bp.obrisiNalog(n);
            web[i++]=n;
        }

        dodavanje= (ImageButton)findViewById(R.id.dodavanje);
        dodavanje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                naziv=findViewById(R.id.nalog);
                String s=naziv.getText().toString();
                Nalog novi=new Nalog(s, 3000);
                MainActivity.bp.dodajNalog(novi);
            }
        });

        ListaNaloga listAdapter = new ListaNaloga(this, web);
        list=(ListView)findViewById(R.id.lista);
        list.setAdapter(listAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(Nalozi.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
