package com.hllbr.tabjavafragment.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.hllbr.tabjavafragment.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        //Burad ne zaman hangi fragmenti göstereceğimi ifade etmem gerekiyor
        //burada position sorguluyort olacağım hangi tab'e yani hangi fragmente basıldı .
        if(position == 0){
            //İlk değer seçildiyse
            //burada ilk fragmentten bir obje oluşturmak gerekecek
            return FragmentFirst.newInstance();
        }else{
            //Bu alanda da ikinci fragmentten bir obje oluşturmak gerekecek
            return SecondFragment.newInstance();
        }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
    /**
     * bu sınıf içersinide bulunan metodlara bakalım
     * getCount kaç adet fragment olacağını yazdığımz yapı
     * getPageTitle fragmentlerin isinleri ne olacak onları bir listeye atmış bulunuyor verilerin bulunduğu listenin adı ise TAB_TITLE
     *
     */
}