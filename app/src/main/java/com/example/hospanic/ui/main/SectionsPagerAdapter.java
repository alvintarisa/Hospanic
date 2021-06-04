package com.example.hospanic.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.hospanic.Fragment.DaftarRumahSakit;
import com.example.hospanic.Fragment.Home;
import com.example.hospanic.Fragment.Profile;
import com.example.hospanic.Fragment.Transaksi;
import com.example.hospanic.R;


/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes

    private static final int[] TAB_TITLES = new int[]{R.string.tab_home, R.string.tab_daftar_rumah_sakit, R.string.tab_transaksi, R.string.tab_profile};
//    private static final int[] TAB_TITLES = new int[]{R.string.tab_home, R.string.penyakit_seboreic_dermatitis, R.string.penyakit_lichen_planus, R.string.penyakit_pityriasis_rosea, R.string.penyakit_cronic_dermatitis, R.string.penyakit_pityriasis_rubra_pilaris};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new Home();
                break;
            case 1:
                fragment = new DaftarRumahSakit();
                break;
            case 2:
                fragment = new Transaksi();
                break;
            case 3:
                fragment = new Profile();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return TAB_TITLES.length;
    }
}