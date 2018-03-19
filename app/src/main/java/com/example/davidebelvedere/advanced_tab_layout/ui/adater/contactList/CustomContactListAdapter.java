package com.example.davidebelvedere.advanced_tab_layout.ui.adater.contactList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.davidebelvedere.advanced_tab_layout.R;
import com.example.davidebelvedere.advanced_tab_layout.ui.data.contactList.ContactSingleton;
import com.example.davidebelvedere.advanced_tab_layout.ui.data.contactList.Contatto;
import com.example.davidebelvedere.advanced_tab_layout.ui.fragment.ContactListFragment;
import com.example.davidebelvedere.advanced_tab_layout.ui.logic.contactList.Utility;

import java.util.List;

/**
 * Created by davidebelvedere on 14/03/18.
 */

public class CustomContactListAdapter extends ArrayAdapter<Contatto>{
    private final Context context;
    private List<Contatto> values;

    public CustomContactListAdapter(Context context, List<Contatto> values) {
        super(context, R.layout.contact_layout, values);
        this.context = context;
        this.values = values;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        return getViewOptimize(position, convertView, parent);
    }

    public View getViewOptimize(int position, View convertView, ViewGroup parent) {
        String preferito = Utility.getFromSharedPref(this.context);

        ViewHolder viewHolder = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.contact_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.nome);
            viewHolder.number = (TextView) convertView.findViewById(R.id.telefono);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.colore);
            viewHolder.favourite = (ImageView) convertView.findViewById(R.id.favourite);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Contatto contatto = this.values.get(position);
        viewHolder.name.setText(contatto.getNome());
        viewHolder.number.setText(contatto.getTelefono());
        viewHolder.image.setBackgroundColor(Utility.getColorForPosition(this.context, position));


        if (!preferito.equals("")) {
            if (preferito.equals(contatto.getTelefono())) {

                viewHolder.favourite.setVisibility(View.VISIBLE);

            } else {
                viewHolder.favourite.setVisibility(View.INVISIBLE);
            }
        }
        return convertView;
    }

    @Override
    public int getCount() {
        return values.size();
    }

    public void refreshValues() {
        this.values = ContactSingleton.getInstance().getContactArray();
        notifyDataSetChanged();
    }

    private class ViewHolder {
        public TextView name;
        public TextView number;
        public ImageView image;
        public ImageView favourite;
    }
}
