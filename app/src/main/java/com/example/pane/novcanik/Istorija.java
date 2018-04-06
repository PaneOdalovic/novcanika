package com.example.pane.novcanik;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pane.novcanik.Baza.Prihod;

/**
 * Created by Pane on 1/24/2018.
 */

public class Istorija extends AppCompatActivity {
TextView mesec;
ImageButton pre,posle;
ListView listaPrihoda;
int i=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.istorija);
        final String[] meseci={"Januar","Februar","Mart","April","Maj","Jun","Jul","Avgust","Septembar","Oktobar","Novembar","Decembar"};

        mesec=(TextView) findViewById(R.id.mesec);
        pre=(ImageButton) findViewById(R.id.pre);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i>0){
                    i--;
                    mesec.setText(meseci[i]);
                }
            }
        });
        posle=(ImageButton) findViewById(R.id.posle);
        posle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i<11){
                    i++;
                    mesec.setText(meseci[i]);
                }
            }
        });
        listaPrihoda = (ListView) findViewById(R.id.prihodi);
        Prihod p=new Prihod("sadasd", 30L, 1);
        Prihod p2=new Prihod("sadsadasdasasd", 30L, 1);
        Prihod p3=new Prihod("sadassadsadasd", 30L, 1);
        Prihod[] pri=new Prihod[3];
        pri[0]=p;
        pri[1]=p2;
        pri[2]=p3;

        ListaPrihoda lp=new ListaPrihoda(this,pri);
        listaPrihoda.setAdapter(lp);
    }
}
