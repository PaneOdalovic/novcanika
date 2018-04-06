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
public class ListaNaloga extends ArrayAdapter<String>{
    private final Activity context;
    private final String[] web;
    public ListaNaloga(Activity context,
                       String[] web) {
        super(context, R.layout.nalog, web);
        this.context = context;
        this.web = web;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.nalog, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        txtTitle.setText(web[position]);
        return rowView;
    }
}