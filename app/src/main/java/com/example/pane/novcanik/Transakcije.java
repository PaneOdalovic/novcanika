package com.example.pane.novcanik;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;

/**
 * Created by Pane on 2/14/2018.
 */

public class Transakcije extends AppCompatActivity {
    EditText opis,iznos;
    ImageButton dodaj,oduzmi;
    long vrednost;
    RadioButton nalozi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transakcije);
        nalozi=findViewById(R.id.nalozi);
        opis=findViewById(R.id.opisTransakcije);
        dodaj=findViewById(R.id.prihodTransakcije);
        oduzmi=findViewById(R.id.rashodTransakcije);
        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        oduzmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
