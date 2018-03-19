package com.example.davidebelvedere.advanced_tab_layout.ui.fragment;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.example.davidebelvedere.advanced_tab_layout.R;


/**
 * Created by davidebelvedere on 14/03/18.
 */

public class EmailFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.email_layout, container, false);
        Button send = (Button) rootView.findViewById(R.id.sendBtn);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText to = (EditText) rootView.findViewById(R.id.to);
                EditText subject = (EditText) rootView.findViewById(R.id.subject);
                EditText msg = (EditText) rootView.findViewById(R.id.message);
                String mailto = "mailto:" + to.getText() +
                        "?subject=" + Uri.encode("" + subject.getText()) +
                        "&body=" + Uri.encode("" + msg.getText());
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse(mailto));
                try {
                    startActivity(emailIntent);
                } catch (ActivityNotFoundException e) {

                }
            }
        });
        return rootView;

    }
}
