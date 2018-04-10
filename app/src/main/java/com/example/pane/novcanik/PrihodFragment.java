package com.example.pane.novcanik;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pane.novcanik.Baza.Prihod;

/**
 * Created by Pane on 4/7/2018.
 */

public class PrihodFragment extends Fragment implements View.OnClickListener{
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(getContext(),MapsActivity.class);
        startActivity(intent);
    }

    private Prihod prihod;
    public static PrihodFragment instancePrihod(Prihod prihod){
        PrihodFragment prihodFragment=new PrihodFragment();
        prihodFragment.prihod=prihod;
        return prihodFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


}
