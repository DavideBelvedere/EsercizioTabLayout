package com.example.davidebelvedere.advanced_tab_layout.ui.logic.contactList;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.davidebelvedere.advanced_tab_layout.R;
import com.example.davidebelvedere.advanced_tab_layout.ui.data.contactList.ContactSingleton;
import com.example.davidebelvedere.advanced_tab_layout.ui.data.contactList.Contatto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidebelvedere on 14/03/18.
 */

public class Utility {

    public static void initDataSource(Context context) {
        List<Contatto> contactList = new ArrayList<Contatto>();
        contactList.add(new Contatto("Giacomo", "3483222395"));
        contactList.add(new Contatto("Giacomino", "3483222397"));
        contactList.add(new Contatto("Giacometto", "3483222305"));
        contactList.add(new Contatto("Giacomollo", "2483222395"));
        contactList.add(new Contatto("Giacomonello", "3483222315"));
        ContactSingleton.getInstance().setContactArray(contactList);
    }

    public static int getColorForPosition(Context context, int position) {
        if (position % 2 == 0) {
            return context.getColor(R.color.light_blue);
        } else {
            return context.getColor(R.color.light_gray);
        }
    }


    public static List<Contatto> getDataSourceItemList(Context context) {
        return ContactSingleton.getInstance().getContactArray();
    }

    public static void addItem(Contatto contatto) {
        ContactSingleton.getInstance().addItem(contatto);
    }

    public static void removeItem(int pos) {
        ContactSingleton.getInstance().removeItem(pos);
    }

    public static void writeOnSharedPref(String number, Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences("preferiti",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("Preferito", number);
        editor.commit();
    }

    public static String getFromSharedPref(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences("preferiti", Context.MODE_PRIVATE);

        String preferito= sharedPref.getString("Preferito","");
        return preferito;
    }


}
