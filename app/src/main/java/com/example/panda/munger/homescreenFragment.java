package com.example.panda.munger;

import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;



/**
 * Created by Panda on 11/22/16.
 */

public class homescreenFragment extends Fragment {

    public static homescreenFragment newInstance() {
        homescreenFragment fragment = new homescreenFragment();
        return fragment;
    }

    public homescreenFragment() {
    }

    Button ClickMe;
    TextView tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.homescreenfragment, container, false);
        ClickMe = (Button) rootView.findViewById(R.id.button);
        tv = (TextView) rootView.findViewById(R.id.textView2);

        ClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tv.getText().toString().contains("Hey")){
                    tv.setText("Yo");
                }else tv.setText("Hey");
            }
        });
        return rootView;
    }


}
