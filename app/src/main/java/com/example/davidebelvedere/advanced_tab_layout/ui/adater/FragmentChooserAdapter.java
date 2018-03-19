package com.example.davidebelvedere.advanced_tab_layout.ui.adater;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.davidebelvedere.advanced_tab_layout.R;
import com.example.davidebelvedere.advanced_tab_layout.ui.fragment.ContactListFragment;
import com.example.davidebelvedere.advanced_tab_layout.ui.fragment.EmailFragment;
import com.example.davidebelvedere.advanced_tab_layout.ui.fragment.StaticImageViewFragment;

/**
 * Created by davidebelvedere on 14/03/18.
 */

public class FragmentChooserAdapter extends FragmentPagerAdapter {


    private Context mContext;

    public FragmentChooserAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }


    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new StaticImageViewFragment();
        } else if (position == 1) {
            return new ContactListFragment();
        } else if (position == 2) {
            return new EmailFragment();
        }
        return null;

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.tab_1);
            case 1:
                return mContext.getString(R.string.tab_2);
            case 2:
                return mContext.getString(R.string.tab_3);
            default:
                return null;
        }
    }

}
