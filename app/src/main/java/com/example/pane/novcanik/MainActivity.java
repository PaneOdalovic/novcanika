package com.example.pane.novcanik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pane.novcanik.Baza.BazaPodataka;
import com.example.pane.novcanik.Baza.Nalog;

public class MainActivity extends AppCompatActivity {
    public static BazaPodataka bp;
ImageButton dodavanjePrihoda,istorija,nalozi,dodavanjeRashoda;
TextView transakcije;
    public static TextView iznos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bp=new BazaPodataka(this);
        iznos=findViewById(R.id.ukupnoPara);
        Nalog n=bp.vratiNalog(1);
        iznos.setText(n.get_dug()+"");
        dodavanjePrihoda=(ImageButton) findViewById(R.id.dodavanjePrihoda);
        dodavanjePrihoda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent prihod = new Intent(MainActivity.this, DodavanjePrihoda.class);
                startActivity(prihod);
            }
        });
        dodavanjeRashoda=(ImageButton) findViewById(R.id.dodavanjeRashoda);
        dodavanjeRashoda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rashod = new Intent(MainActivity.this, DodavanjeRashoda.class);
                startActivity(rashod);
            }
        });
        istorija = (ImageButton) findViewById(R.id.istorija);
        istorija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent istorija= new Intent(MainActivity.this,Istorija.class);
                startActivity(istorija);
            }
        });
        nalozi = (ImageButton) findViewById(R.id.nalozi);
        nalozi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nalozi= new Intent(MainActivity.this,Nalozi.class);
                startActivity(nalozi);
            }
        });
        transakcije=findViewById(R.id.transakcije);
        transakcije.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent transakcije= new Intent(MainActivity.this,Transakcije.class);
                startActivity(transakcije);
            }
        });
    }
}
