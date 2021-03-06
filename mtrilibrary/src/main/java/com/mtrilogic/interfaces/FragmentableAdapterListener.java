package com.mtrilogic.interfaces;

import android.support.v4.view.ViewPager;

import com.mtrilogic.adapters.FragmentableAdapter;

@SuppressWarnings("unused")
public interface FragmentableAdapterListener extends OnMakeToastListener{

    // ================< PUBLIC ABSTRACT METHODS >==================================================

    FragmentableAdapter getFragmentableAdapter();
    ViewPager getViewPager();
}
