package com.example.pane.novcanik;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pane.novcanik.Baza.Prihod;
import com.google.android.gms.maps.MapView;

/**
 * Created by Pane on 1/24/2018.
 */

public class DodavanjeRashoda extends AppCompatActivity {
    EditText opis,rashod;
    Button dodaj;
    MapView mapa;
    TextView t;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dodavanje_rashoda);
        t=findViewById(R.id.ttt);
        opis=findViewById(R.id.opis);
        rashod=findViewById(R.id.iznos);
        dodaj=findViewById(R.id.dodaj);
        mapa=findViewById(R.id.mapView);
        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long l=Long.parseLong(rashod.getText().toString());

            }
        });
    }
}
