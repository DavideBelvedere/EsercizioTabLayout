package com.example.davidebelvedere.advanced_tab_layout.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.davidebelvedere.advanced_tab_layout.R;

/**
 * Created by davidebelvedere on 14/03/18.
 */

public class StaticImageViewFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.static_image_view_layout, container, false);

        return rootView;

    }
}
