package com.example.davidebelvedere.advanced_tab_layout.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.davidebelvedere.advanced_tab_layout.R;
import com.example.davidebelvedere.advanced_tab_layout.ui.data.contactList.Contatto;
import com.example.davidebelvedere.advanced_tab_layout.ui.logic.contactList.Utility;

import static java.lang.String.valueOf;

/**
 * Created by davidebelvedere on 14/03/18.
 */

public class ContactDetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);

        Intent intent = getIntent();

        // Set onclick listener
        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nome = (EditText) findViewById(R.id.nome);
                EditText numero = (EditText) findViewById(R.id.numero);
                Contatto newContact = new Contatto(valueOf(nome.getText()), valueOf(numero.getText()));
                Utility.addItem(newContact);

                finish();
            }
        });
    }
}