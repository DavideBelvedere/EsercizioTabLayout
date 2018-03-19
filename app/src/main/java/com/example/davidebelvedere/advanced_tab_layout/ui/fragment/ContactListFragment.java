package com.example.davidebelvedere.advanced_tab_layout.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.davidebelvedere.advanced_tab_layout.R;
import com.example.davidebelvedere.advanced_tab_layout.ui.activity.ContactDetailActivity;
import com.example.davidebelvedere.advanced_tab_layout.ui.activity.DetailActivity;
import com.example.davidebelvedere.advanced_tab_layout.ui.activity.MainActivity;
import com.example.davidebelvedere.advanced_tab_layout.ui.adater.contactList.CustomContactListAdapter;
import com.example.davidebelvedere.advanced_tab_layout.ui.data.contactList.Contatto;
import com.example.davidebelvedere.advanced_tab_layout.ui.logic.contactList.Utility;

/**
 * Created by davidebelvedere on 14/03/18.
 */

public class ContactListFragment extends Fragment {

    private CustomContactListAdapter customAdapter;

    public ContactListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.contact_list_layout, container, false);


        Utility.initDataSource(getActivity());
        customAdapter = new CustomContactListAdapter(getActivity(), Utility.getDataSourceItemList(getActivity()));
        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        listView.setAdapter(customAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contatto selectedItem = Utility.getDataSourceItemList(getActivity()).get(position);

                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("nome", selectedItem.getNome());
                intent.putExtra("numero", selectedItem.getTelefono());

                startActivity(intent);

            }
        });
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        customAdapter.refreshValues();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.add_contact_plus, menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add: {
                Intent intent = new Intent(getActivity(), ContactDetailActivity.class);
                startActivity(intent);
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }

}
