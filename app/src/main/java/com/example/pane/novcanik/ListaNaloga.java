package com.example.pane.novcanik;

/**
 * Created by Pane on 1/24/2018.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pane.novcanik.Baza.Nalog;

public class ListaNaloga extends ArrayAdapter<Nalog>{
    private final Activity context;
    private final Nalog[] web;
    public ListaNaloga(Activity context,
                       Nalog[] web) {
        super(context, R.layout.nalog, web);
        this.context = context;
        this.web=web;
//        this.web = new Nalog[web.length-1];
//        for(int i=1;i<web.length;i++){
//            this.web[i-1]=web[i];
//        }
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.nalog, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        txtTitle.setText(web[position].get_ime()+":"+web[position].get_dug());
        return rowView;
    }
}