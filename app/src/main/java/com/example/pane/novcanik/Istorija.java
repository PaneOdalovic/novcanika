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
import com.example.pane.novcanik.Baza.Rashod;

import java.util.List;

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
        listaPrihoda = (ListView) findViewById(R.id.prihodi);
        List<Prihod> prihodi=MainActivity.bp.vratiPrihodeZaOdredjeniNalog(1);
        Prihod[] pri=new Prihod[prihodi.size()];
        int i=0;
        for(Prihod p:prihodi){
            pri[i++]=p;
        }
        ListaPrihoda lp=new ListaPrihoda(this,pri);
        listaPrihoda.setAdapter(lp);
    }
}
