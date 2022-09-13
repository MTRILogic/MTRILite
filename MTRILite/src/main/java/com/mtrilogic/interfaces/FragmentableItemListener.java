package com.mtrilogic.interfaces;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;

import com.mtrilogic.abstracts.Page;
import com.mtrilogic.adapters.FragmentableAdapter;
import com.mtrilogic.classes.Listable;

@SuppressWarnings("unused")
public interface FragmentableItemListener extends ItemListener, FragmentableListener{
    @NonNull
    Listable<Page> getPageListable();

    @NonNull
    FragmentableAdapter getFragmentableAdapter();

    @NonNull
    ViewPager getViewPager();
}
