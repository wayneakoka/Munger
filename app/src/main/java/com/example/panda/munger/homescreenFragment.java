package com.example.panda.munger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.example.panda.munger.Facebook.PrefUtils.getCurrentUser;


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


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.homescreenfragment, container, false);
       TextView facebookID = (TextView) rootView.findViewById(R.id.facebookID);
       TextView username = (TextView) rootView.findViewById(R.id.username);
       TextView gender = (TextView) rootView.findViewById(R.id.gender);


       facebookID.setText(getCurrentUser(getContext()).facebookID);
       username.setText(getCurrentUser(getContext()).username);
       gender.setText(getCurrentUser(getContext()).gender);

        //profilePictureView.setPresetSize(ProfilePictureView.LARGE);
        // profilePictureView.setProfileId(getCurrentUser(getContext()).facebookID);
        // rootView.setVisibility(View.VISIBLE);

        return rootView;
    }


}
