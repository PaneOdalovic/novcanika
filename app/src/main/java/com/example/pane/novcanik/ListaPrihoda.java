package com.example.pane.novcanik;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pane.novcanik.Baza.Prihod;

/**
 * Created by Pane on 4/6/2018.
 */

public class ListaPrihoda extends ArrayAdapter<Prihod> {
    private final Activity context;
    private final Prihod[] prihodi;
    public ListaPrihoda(Activity context, Prihod[] prihodi) {
        super(context, R.layout.nalog, prihodi);
        this.context = context;
        this.prihodi = prihodi;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.prihodi, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.cena);
        txtTitle.setText(prihodi[position].getIznos().toString());
        TextView opis = (TextView) rowView.findViewById(R.id.opis);
        opis.setText(prihodi[position].getOpis().toString());
        return rowView;
    }
}
