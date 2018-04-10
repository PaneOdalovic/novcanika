package com.example.pane.novcanik;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pane.novcanik.Baza.Nalog;
import com.example.pane.novcanik.Baza.Prihod;

/**
 * Created by Pane on 1/23/2018.
 */

public class DodavanjePrihoda extends AppCompatActivity {
    EditText opis,prihod;
    Button dodaj;
    TextView t;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dodavanje_prihoda);
        opis=findViewById(R.id.opis);
        prihod=findViewById(R.id.iznos);
        t=findViewById(R.id.textView4);
        dodaj=findViewById(R.id.dodaj);
        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long l=Long.parseLong(prihod.getText().toString());
                Prihod p=new Prihod(opis.getText().toString(),l,1);
                MainActivity.bp.dodajPrihod(p);
                Nalog n=MainActivity.bp.vratiNalog(1);
                Double d=n.get_dug()+l;
                n.set_dug(d);
                MainActivity.iznos.setText(n.get_dug()+"");
                MainActivity.bp.izmeniNaloga(n);

            }
        });
    }
}
