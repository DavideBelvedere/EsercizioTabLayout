package com.example.davidebelvedere.advanced_tab_layout.ui.data.contactList;

import java.util.List;

/**
 * Created by davidebelvedere on 14/03/18.
 */

public class ContactSingleton {
    private static List<Contatto> CONTACTS;
    private static ContactSingleton mySingleton = new ContactSingleton();

    private ContactSingleton() {

    }

    public static ContactSingleton getInstance() {
        return mySingleton;
    }

    public  List<Contatto> getContactArray() {
        return CONTACTS;
    }

    public  void setContactArray(List<Contatto> array) {
        CONTACTS = array;
    }

    public void addItem(Contatto newContact){
        CONTACTS.add(newContact);
    }

    public void removeItem(int position){
        CONTACTS.remove(position);
    }
}
