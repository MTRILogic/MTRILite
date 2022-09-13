package com.mtrilogic.interfaces;

import android.support.v4.view.ViewPager;

import com.mtrilogic.abstracts.Page;
import com.mtrilogic.adapters.FragmentableAdapter;
import com.mtrilogic.classes.Listable;

@SuppressWarnings("unused")
public interface FragmentableItemListener extends ItemListener, FragmentableListener{
    Listable<Page> getPageListable();

    FragmentableAdapter getFragmentableAdapter();

    ViewPager getViewPager();
}
